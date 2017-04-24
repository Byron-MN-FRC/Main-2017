package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftStop extends Command {
	
	private double time;

    public PneumaticLiftStop(double inputTime) {
        requires(Robot.pneumaticsLift);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    }

    protected void interrupted() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    }
}