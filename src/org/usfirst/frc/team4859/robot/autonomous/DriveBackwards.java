package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwards extends Command {

	private double time;
	private double speed;
	
    public DriveBackwards(double inputSpeed, double inputTime) {
        requires(Robot.chassis);
        
        speed = inputSpeed;
        time = inputTime;
    }

    protected void initialize() {
    	Robot.chassis.driveBackwards(speed);
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.chassis.driveBackwards(speed);
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