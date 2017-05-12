package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class StrafeLeft extends Command {

	private double time;
	private double speed;
	
    public StrafeLeft(double inputSpeed, double inputTime) {
        requires(Robot.chassis);
        
        speed = inputSpeed;
        time = inputTime;
    }

    protected void initialize() {
    	Robot.chassis.strafeLeft(speed);
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.chassis.strafeLeft(speed);
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