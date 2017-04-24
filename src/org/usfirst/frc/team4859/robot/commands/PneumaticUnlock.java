package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticUnlock extends Command {
	
	private double time;

    public PneumaticUnlock(double inputTime) {
        requires(Robot.pneumaticsLock);
    }

    protected void initialize() {
    	Robot.pneumaticsLock.pneumaticUnlock();
    	RobotMap.locked = false;
    	setTimeout(time);
    }

    protected void execute() {
    	RobotMap.locked = false;
    	Robot.pneumaticsLock.pneumaticUnlock();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumaticsLock.pneumaticStop();
    }

    protected void interrupted() {
    	Robot.pneumaticsLock.pneumaticStop();
    }
}