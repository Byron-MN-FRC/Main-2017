package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGearCurve;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearLeft;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearRight;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearStraight;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4859.robot.autonomous.AutoCenterGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGearCurve;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;
import org.usfirst.frc.team4859.robot.subsystems.Feeder;
import org.usfirst.frc.team4859.robot.subsystems.Flywheels;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class Robot extends IterativeRobot {
	// Creating subsystems
	public static Chassis chassis;
	public static Climber climber;
	public static Flywheels flywheels;
	public static Feeder feeder;
	public static Preferences prefs;
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
    	// Initializing subsystems (and navx)
    	chassis = new Chassis();
    	climber = new Climber();
    	feeder = new Feeder();
    	flywheels = new Flywheels();
    	prefs = Preferences.getInstance();
    	ahrs = new AHRS(SerialPort.Port.kUSB);
		oi = new OI();
		
		ahrs.reset();
		
		UsbCamera cameraBackward = CameraServer.getInstance().startAutomaticCapture("Backward", 0);
		cameraBackward.setResolution(320, 240);
		cameraBackward.setFPS(10);
		UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward", 1);
		cameraForward.setResolution(320, 240);
		cameraForward.setFPS(10);
		
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
		// Adding autonomous modes
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		//autonomousChooser.addObject("Test", new AutoTest());
		autonomousChooser.addObject("Center Gear", new AutoCenterGear());
		autonomousChooser.addObject("Right Gear Curve", new AutoRightGearCurve());
		autonomousChooser.addObject("Left Gear Curve", new AutoLeftGearCurve());
		autonomousChooser.addObject("Right Gear", new AutoRightGear());
		autonomousChooser.addObject("Left Gear", new AutoLeftGear());
		autonomousChooser.addObject("Vision Gear Left", new VisionGearLeft());
		autonomousChooser.addObject("Vision Gear Right", new VisionGearRight());
		autonomousChooser.addObject("Vision Gear Straight", new VisionGearStraight());

		//autonomousChooser.addObject("Right Gear and Shoot", new AutoRightGearAndShoot());
		//autonomousChooser.addObject("Left Gear and Shoot", new AutoLeftGearAndShoot());
				
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	Chassis.motorChassisFrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisBackLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisFrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisBackRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	
    	Chassis.motorChassisFrontRight.reverseSensor(true);
    	Chassis.motorChassisBackRight.reverseSensor(true);
    	
    	Chassis.motorChassisFrontLeft.configEncoderCodesPerRev(360);
    	Chassis.motorChassisBackLeft.configEncoderCodesPerRev(360);
    	Chassis.motorChassisFrontRight.configEncoderCodesPerRev(360);
    	Chassis.motorChassisBackRight.configEncoderCodesPerRev(360);
    	
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisFrontRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackRight.changeControlMode(TalonControlMode.PercentVbus);

    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
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
		
//        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
//        SmartDashboard.putNumber("FR", Chassis.motorChassisFrontRight.getSpeed());
//        SmartDashboard.putNumber("BL", Chassis.motorChassisBackLeft.getSpeed());
//        SmartDashboard.putNumber("BR", Chassis.motorChassisBackRight.getSpeed());
    }

    public void teleopInit() {
    	
        if (autonomousCommand != null) autonomousCommand.cancel();
        
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisFrontRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackRight.changeControlMode(TalonControlMode.PercentVbus);
		
		ahrs.reset();
    }

    public void disabledInit() {
    }

    public void teleopPeriodic() {  
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
        SmartDashboard.putNumber("FR", Chassis.motorChassisFrontRight.getSpeed());
        SmartDashboard.putNumber("BL", Chassis.motorChassisBackLeft.getSpeed());
        SmartDashboard.putNumber("BR", Chassis.motorChassisBackRight.getSpeed());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}