package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.Autonomous;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Create subsystems
	public static Chassis chassis;
	public static AnalogInput ultra;
	public static ADXRS450_Gyro gyro;
	public static OI oi;

	public static double start;
	
    Command autonomousCommand;
    SendableChooser autonomousChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initialize subsystems
    	chassis = new Chassis();
		ultra = new AnalogInput(0);
//		ultra.setOversampleBits(6);
//		ultra.setAverageBits(6)
		gyro = new ADXRS450_Gyro();
		oi = new OI();
		gyro.reset();
		
		// Add autonomous modes
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		autonomousChooser.addObject("Straight (Shooter Down)", new Autonomous());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // Instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		Chassis.motor1.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motor2.changeControlMode(TalonControlMode.PercentVbus);

		gyro.reset();
    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//if (launcher.limitDown.get()) start = launcher.motorLauncherAngle.getPosition();
    	
    	SmartDashboard.putNumber("Distance (inches)", Robot.ultra.getAverageVoltage()*8.8365*12);
		SmartDashboard.putNumber("Distance (feet)", (Robot.ultra.getAverageVoltage()*8.8365));
		SmartDashboard.putNumber("Gyro Angle", (Robot.gyro.getAngle()));
		
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.

		gyro.reset();
        if (autonomousCommand != null) autonomousCommand.cancel();
        
		Chassis.motor1.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motor2.changeControlMode(TalonControlMode.PercentVbus);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    	SmartDashboard.putNumber("Distance (inches)", Robot.ultra.getVoltage()*8.8365*12);
		SmartDashboard.putNumber("Distance (feet)", (Robot.ultra.getVoltage()*8.8365));
		SmartDashboard.putNumber("Gyro Angle", (Robot.gyro.getAngle()));
		
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}