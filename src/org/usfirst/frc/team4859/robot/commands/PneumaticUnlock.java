package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticUnlock extends Command {
	
	private double time;

    public PneumaticUnlock(double inputTime) {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticUnlock();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticUnlock();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumatics.pneumaticStop();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticStop();
    }
}