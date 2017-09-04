package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticRetract extends Command {
	
	private double time;

    public PneumaticRetract(double inputTime) {
        requires(Robot.pneumatics);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticRetract();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticRetract();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumatics.pneumaticStopRelease();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticStopRelease();
    }
}