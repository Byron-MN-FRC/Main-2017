package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLock extends Command {
	
	private double time;

    public PneumaticLock(double inputTime) {
        requires(Robot.pneumatics);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLock();
    	RobotMap.locked = false;
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLock();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumatics.pneumaticLock();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticStop();
    }
}