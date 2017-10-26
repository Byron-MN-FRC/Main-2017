package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class wiggl1 extends Command {

	private double time;
	private double speed;
	
    public wiggl1(double inputSpeed, double inputTime) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        speed = inputSpeed;
        time = inputTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.driveRight(speed);
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveRight(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveStop();
    }

    protected void interrupted() {
    	Robot.chassis.driveStop();
    }
}
