package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Wiggle extends Command {

	private double forwardSpeed;
	private double turnSpeed;
	private double time;
	
    public Wiggle(double inputForwardSpeed, double inputTurnSpeed, double inputTime) {
        requires(Robot.chassis);
        
        forwardSpeed = inputForwardSpeed;
        turnSpeed = inputTurnSpeed;
        time = inputTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.wiggle(forwardSpeed, turnSpeed);
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.wiggle(forwardSpeed, turnSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.driveStop();
    }
}