package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGearCurve;
import org.usfirst.frc.team4859.robot.autonomous.AutoCenterGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoLeftGearCurve;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;
import org.usfirst.frc.team4859.robot.subsystems.Pneumatics;

import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	// Creating subsystems
	public static Chassis chassis;
	public static Climber climber;
	public static Pneumatics pneumatics;
	public static Preferences prefs;
	public static Compressor compressor;
	public static AHRS ahrs;
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    public void robotInit() {
    	// Initializing subsystems (and navx)
    	chassis = new Chassis();
    	climber = new Climber();
    	pneumatics = new Pneumatics();
    	prefs = Preferences.getInstance();
    	compressor = new Compressor();
    	ahrs = new AHRS(SerialPort.Port.kUSB);
		oi = new OI();
		
		ahrs.reset();
		
		UsbCamera cameraBackward = CameraServer.getInstance().startAutomaticCapture("Backward", 0);
		cameraBackward.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 15);

		UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward", 1);
		cameraForward.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 15);
		
		// Adding autonomous modes
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		//autonomousChooser.addObject("Test", new AutoTest());
		autonomousChooser.addObject("Center Gear", new AutoCenterGear());
		autonomousChooser.addObject("Right Gear Curve", new AutoRightGearCurve());
		autonomousChooser.addObject("Left Gear Curve", new AutoLeftGearCurve());
		autonomousChooser.addObject("Right Gear", new AutoRightGear());
		autonomousChooser.addObject("Left Gear", new AutoLeftGear());
				
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
//    	Chassis.motorChassisFrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	Chassis.motorChassisBackLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	Chassis.motorChassisFrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	Chassis.motorChassisBackRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	
//    	Chassis.motorChassisFrontRight.reverseSensor(true);
//    	Chassis.motorChassisBackRight.reverseSensor(true);
//    	
//    	Chassis.motorChassisFrontLeft.configEncoderCodesPerRev(360);
//    	Chassis.motorChassisBackLeft.configEncoderCodesPerRev(360);
//    	Chassis.motorChassisFrontRight.configEncoderCodesPerRev(360);
//    	Chassis.motorChassisBackRight.configEncoderCodesPerRev(360);
    	
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
        
        SmartDashboard.putNumber("compressor current", compressor.getCompressorCurrent());
//        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
//        SmartDashboard.putNumber("FR", Chassis.motorChassisFrontRight.getSpeed());
//        SmartDashboard.putNumber("BL", Chassis.motorChassisBackLeft.getSpeed());
//        SmartDashboard.putNumber("BR", Chassis.motorChassisBackRight.getSpeed());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}