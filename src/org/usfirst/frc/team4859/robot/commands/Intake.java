package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {

    public Intake() {
    	requires(Robot.flywheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.flywheels.Intake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flywheels.Intake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flywheels.IntakeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.flywheels.IntakeStop();
    }
}