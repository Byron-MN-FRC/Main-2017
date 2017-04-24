package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLock extends Command {
	
	private double time;

    public PneumaticLock(double inputTime) {
        requires(Robot.pneumaticsLock);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumaticsLock.pneumaticLock();
    	RobotMap.locked = true;
    	setTimeout(time);
    }

    protected void execute() {
    	RobotMap.locked = true;
    	Robot.pneumaticsLock.pneumaticLock();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumaticsLock.pneumaticLock();
    }

    protected void interrupted() {
    	Robot.pneumaticsLock.pneumaticStop();
    }
}