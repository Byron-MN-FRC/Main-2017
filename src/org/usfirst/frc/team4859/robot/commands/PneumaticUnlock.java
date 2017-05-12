package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticUnlock extends Command {
	
	private double time;

    public PneumaticUnlock(double inputTime) {
        requires(Robot.pneumatics);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticUnlock();
    	RobotMap.islocked = false;
    	setTimeout(time);
    }

    protected void execute() {
    	RobotMap.islocked = false;
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