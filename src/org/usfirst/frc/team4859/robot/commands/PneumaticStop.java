package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticStop extends Command {
	
	private double time;

    public PneumaticStop(double inputTime) {
        requires(Robot.pneumaticsLock);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumaticsLock.pneumaticStop();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumaticsLock.pneumaticStop();
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