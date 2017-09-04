package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftStop extends Command {
	
	private double time;

    public PneumaticLiftStop(double inputTime) {
        requires(Robot.pneumatics);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLiftStop();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLiftStop();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumatics.pneumaticLiftStop();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticLiftStop();
    }
}