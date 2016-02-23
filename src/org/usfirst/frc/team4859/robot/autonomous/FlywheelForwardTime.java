package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelForwardTime extends Command {

	private double time;
	
    public FlywheelForwardTime(double inputTime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.flywheels);
        time = inputTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.flywheels.FlywheelForward();
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flywheels.FlywheelForward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flywheels.FlywheelStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.flywheels.FlywheelStop();
    }
}