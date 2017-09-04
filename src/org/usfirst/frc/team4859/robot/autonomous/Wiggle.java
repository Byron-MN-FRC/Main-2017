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

    protected void initialize() {
    	Robot.chassis.wiggle(forwardSpeed, turnSpeed);
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.chassis.wiggle(forwardSpeed, turnSpeed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.chassis.driveStop();
    }

    protected void interrupted() {
    	Robot.chassis.driveStop();
    }
}