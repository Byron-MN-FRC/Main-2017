package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStop extends Command {
	
	private double time;
	
	public DriveStop(double inputTime) {
        requires(Robot.chassis);
        
        time = inputTime;
    }

    protected void initialize() {
    	Robot.chassis.driveStop();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.chassis.driveStop();
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