package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftUp extends Command {

	private double time;

    public PneumaticLiftUp(double inputTime) {
        requires(Robot.pneumaticsLift);        
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumaticsLift.pneumaticLiftUp();
    	setTimeout(time);
    	RobotMap.down = false;
    }

    protected void execute() {
    	Robot.pneumaticsLift.pneumaticLiftUp();
    	RobotMap.down = false;
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumaticsLift.pneumaticLiftUp();
    }

    protected void interrupted() {
    	Robot.pneumaticsLift.pneumaticLiftStop();
    }
}