package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.Autonomous;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Solenoids;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Create subsystems
	public static Chassis chassis;
	public static OI oi;
	public static Solenoids solenoids;

    Command autonomousCommand;
    SendableChooser autonomousChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	// Initialize subsystems
    	chassis = new Chassis();
    	solenoids = new Solenoids();
		oi = new OI();
		
		// Add autonomous modes
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Default", new Autonomous());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // Instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit()
    {
    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
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
    public void disabledInit()
    {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
