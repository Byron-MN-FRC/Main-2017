package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoStartLeftCanInitialize extends Command {

    public AutoStartLeftCanInitialize()
    {
       requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	System.out.println("AutoStartLeftCanInitialize Initialize()");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	System.out.println("AutoStartLeftCanInitialize execute()");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	System.out.println("AutoStartLeftCanInitialize isFinished()");
        return true;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	System.out.println("AutoStartLeftCanInitialize end()");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
