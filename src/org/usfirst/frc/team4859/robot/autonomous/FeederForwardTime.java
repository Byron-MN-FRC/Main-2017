package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FeederForwardTime extends Command {
	
	private double time;
	private double speed;

    public FeederForwardTime(double inputSpeed, double inputTime) {
        requires(Robot.feeder);
        
        speed = inputSpeed;
        time = inputTime;
    }

    protected void initialize() {
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.feeder.feederForwardTime(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.feeder.feederStop();
    }

    protected void interrupted() {
    	Robot.feeder.feederStop();
    }
}