package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGearCurve;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearLeft;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearRight;
import org.usfirst.frc.team4859.robot.autonomous.VisionGearStraight;
import org.usfirst.frc.team4859.robot.commands.PneumaticLiftUp;
import org.usfirst.frc.team4859.robot.autonomous.AutoCenterGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGearCurve;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;
import org.usfirst.frc.team4859.robot.subsystems.Pneumatics;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Subsystem variables
	public static Chassis chassis;
	public static Climber climber;
	public static Pneumatics pneumatics;
	public static Compressor compressor;
	/*public static AHRS ahrs;*/
	public static OI oi;
	
//vision tracking variables
	private double imgWidth = 640;
	NetworkTable table;
	private double centerXG = 0;
    private double centerXr = 0.0;
	private double centerXb = 0.0;
    //output values for gear
	public static double power = 0;
	//what networktable/key that the code will look at and the default value(what will appear if it doesnt see anything)
	private static String networktable = "GRIP/myContoursReport";
	private static String contour1 = "centerX";
	private static String contour2 = "centerX";
	private double defaultValue = imgWidth/2;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    public void robotInit() {	
    	chassis = new Chassis();
    	climber = new Climber();
    	pneumatics = new Pneumatics();
    	/*ahrs = new AHRS(SerialPort.Port.kUSB);*/
		oi = new OI();
		
		
		table = NetworkTable.getTable(networktable);
		
		
		/*ahrs.reset();*/
    
		UsbCamera cameraBackward = CameraServer.getInstance().startAutomaticCapture("Backward", 0);
		cameraBackward.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 10);

		UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward", 1);
		cameraForward.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 10);
		
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
       
      /*  double[] defaultValue = new double [320];
        //SmartDashboard.putNumber("Yaw", ahrs.getYaw());
        double[] tablX1 = table.getNumberArray("x", defaultValue); */
        
        //Moved this here because the sections ending in "periodic" are loops that run while that mode of the robot is running
    	centerXr = table.getNumber(contour1, defaultValue);
		centerXb = table.getNumber(contour2, defaultValue);
		 centerXG = (centerXr + centerXb)/2;
			power = centerXG-(imgWidth/2);
			SmartDashboard.putNumber("centerAv", centerXG);
			SmartDashboard.putNumber("center1", centerXr);
			SmartDashboard.putNumber("center2", centerXb);
			SmartDashboard.putNumber("POWER", power);
			//This code won't work right now, as grip outputs an array of values to the networktables. To fix this we would 
			//either find a way to get a specific value from the networktables array(i havent been able to find one) or
			//get an array from the networktables and pull the value from there(i dont know how to use arrays)
			
        if (Chassis.gearSensor.getVoltage() < 0.15) {
        	RobotMap.isGearInRobot = true;
        	Chassis.lightStrip.set(false);
        }
        else {
        	RobotMap.isGearInRobot = false;
        	Chassis.lightStrip.set(true);
        }
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
		
	/*	//ahrs.reset(); */
		
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
        
        if (Chassis.gearSensor.getVoltage() < 0.15) {
        	RobotMap.isGearInRobot = true;
        	Chassis.lightStrip.set(true);
        }
        else {
        	RobotMap.isGearInRobot = false;
        	Chassis.lightStrip.set(false);
        }
        
        //put it here as well so we could use it in teleop as well if we wanted
       	centerXr = table.getNumber(contour1, defaultValue);
    		centerXb = table.getNumber(contour2, defaultValue);
    		 centerXG = (centerXr + centerXb)/2;
    			power = centerXG-(imgWidth/2);
    			SmartDashboard.putNumber("centerAv", centerXG);
    			SmartDashboard.putNumber("center1", centerXr);
    			SmartDashboard.putNumber("center2", centerXb);
    			SmartDashboard.putNumber("POWER", power);
    			
    			
    			
        /*SmartDashboard.putBoolean("light strip", Chassis.lightStrip.get());
        
        //SmartDashboard.putNumber("voltage", Chassis.gearSensor.getVoltage());*/
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}