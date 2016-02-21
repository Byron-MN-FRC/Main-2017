package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.Autonomous;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Launcher;
import org.usfirst.frc.team4859.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Create subsystems
	public static Chassis chassis;
	public static Launcher launcher;
	public static Pivot pivot;
	public static OI oi;
	public static AnalogInput ultra;
	public static ADXRS450_Gyro gyro;
	
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
    	launcher = new Launcher();
    	pivot = new Pivot();
		oi = new OI();
		ultra = new AnalogInput(0);
		gyro = new ADXRS450_Gyro();
		
		pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
		start = pivot.motorLauncherAngle.getPosition();
		
		// Add autonomous modes
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Default", new Autonomous());
		autonomousChooser.addObject("Nothing", new AutoNothing());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // Instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
    	pivot.LauncherAngleStop();
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//if (launcher.limitDown.get()) start = launcher.motorLauncherAngle.getPosition();
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
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
    	//if (launcher.limitDown.get()) start = launcher.motorLauncherAngle.getPosition();
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}