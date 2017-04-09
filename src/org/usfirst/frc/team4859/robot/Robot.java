package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.subsystems.Motorss;
import org.usfirst.frc.team4859.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	// Creating subsystems
	public static Motorss motorss;
	public static Pneumatics pneumatics;
	public static ADXRS450_Gyro gyro;
	public static Ultrasonic ultra;
	public static Compressor compressor;
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    public void robotInit() {
    	// Initializing subsystems (and gyro)
    	motorss = new Motorss();
    	pneumatics = new Pneumatics();
    	gyro = new ADXRS450_Gyro();
    	//ultra = new Ultrasonic();
    	compressor = new Compressor();
		oi = new OI();
		
		gyro.reset();
		
		UsbCamera cameraBackward = CameraServer.getInstance().startAutomaticCapture("Backward", 0);
		cameraBackward.setResolution(320, 240);
		cameraBackward.setFPS(10);

		UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward", 1);
		cameraForward.setResolution(320, 240);
		cameraForward.setFPS(10);
		
		// Adding autonomous modes
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
				
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
//    	Chassis.motorChassisFrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	Chassis.motorChassisFrontRight.reverseSensor(true);
//    	Chassis.motorChassisFrontLeft.configEncoderCodesPerRev(360);
//		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);

    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("Yaw", gyro.getAngle());
        
//        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        
//		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);

		gyro.reset();
    }

    public void disabledInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putBoolean("Compressor on/off", compressor.enabled());
        
//        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}