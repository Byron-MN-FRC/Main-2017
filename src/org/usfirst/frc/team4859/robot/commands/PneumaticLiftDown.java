package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftDown extends Command {
	
	private double time;

    public PneumaticLiftDown(double inputTime) {
        requires(Robot.pneumaticsLift);
        requires(Robot.pneumaticsLock);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumaticsLift.pneumaticLiftDown();
    	Robot.pneumaticsLock.pneumaticUnlock();
    	RobotMap.down = true;
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumaticsLift.pneumaticLiftDown();
    	RobotMap.down = true;
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    	Robot.pneumaticsLock.pneumaticStop();
    }

    protected void interrupted() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    }
}