package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGearCurve;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearLeft;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearRight;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearStraight;
import org.usfirst.frc.team4859.robot.commands.PneumaticLiftUp;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4859.robot.autonomous.AutoCenterGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGearCurve;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;
import org.usfirst.frc.team4859.robot.subsystems.Pneumatics;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class Robot extends IterativeRobot {
	public static Chassis chassis;
	public static Climber climber;
	public static Pneumatics pneumatics;
	public static Compressor compressor;
	public static AHRS ahrs;
	public static OI oi;
	//VTrak stuff
    private final Object imgLock = new Object();
    private VisionThread visionThread;
	private int imgWidth = 320;
	private int imgHiegth = 240;
	private int filtSize = 0;
	private int findSize = 0;
	private double centerXG = 0;
    private double centerXr = 0.0;
	private double centerXb = 0.0;
    //output values for gear
	public static double power = 0;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    public void robotInit() {
    	chassis = new Chassis();
    	climber = new Climber();
    	pneumatics = new Pneumatics();
    	ahrs = new AHRS(SerialPort.Port.kUSB);
		oi = new OI();
		
		ahrs.reset();
		
		UsbCamera cameraBackward = CameraServer.getInstance().startAutomaticCapture("Backward", 0);
		cameraBackward.setVideoMode(VideoMode.PixelFormat.kGray, 320, 240, 10);

		UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward", 1);
		cameraForward.setVideoMode(VideoMode.PixelFormat.kGray, 320, 240, 10);
		
		visionThread = new VisionThread(cameraBackward, new RoboPipeline(), pipeline -> {
		    if (!pipeline.filterContoursOutput().isEmpty()) 
		    {
		    	filtSize = pipeline.filterContoursOutput().size();
		    }
        	findSize = pipeline.findContoursOutput().size();
        	Rect p = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
        	Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
        	  synchronized (imgLock) {
        	centerXr = p.x + (p.width/2);
        	centerXb = r.x + (r.width/2);
        	 centerXG = (centerXr + centerXb)/2;
        	 }
          });
		
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		autonomousChooser.addObject("Center Gear", new AutoCenterGear());
		autonomousChooser.addObject("Right Gear Curve", new AutoRightGearCurve());
		autonomousChooser.addObject("Left Gear Curve", new AutoLeftGearCurve());
		autonomousChooser.addObject("Right Gear", new AutoRightGear());
		autonomousChooser.addObject("Left Gear", new AutoLeftGear());
		autonomousChooser.addObject("Vision Gear Left", new VisionGearLeft());
		autonomousChooser.addObject("Vision Gear Right", new VisionGearRight());
		autonomousChooser.addObject("Vision Gear Straight", new VisionGearStraight());
		
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command)autonomousChooser.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("Yaw", ahrs.getYaw());
        double centerXG;
        double power;
        synchronized (imgLock) {
			
			centerXG = this.centerXG;
			power = this.power;
		}
		power = centerXG-(imgWidth/2);
		

        if (Chassis.gearSensor.getVoltage() < 0.3) RobotMap.isGearInRobot = true;
        else RobotMap.isGearInRobot = false;
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
		
		ahrs.reset();
		
		// Just to get the lifting solenoid flipped the right way
		new PneumaticLiftUp(0.5);
    }

    public void disabledInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("Is the grabber down", RobotMap.isDown);
        SmartDashboard.putBoolean("Is the gear locked", RobotMap.islocked);
        SmartDashboard.putBoolean("Is the gear in the robot", RobotMap.isGearInRobot);
        
        if (Chassis.gearSensor.getVoltage() < 0.3) RobotMap.isGearInRobot = true;
        else RobotMap.isGearInRobot = false;
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}