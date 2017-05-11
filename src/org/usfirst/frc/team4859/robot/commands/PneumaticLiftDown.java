package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftDown extends Command {
	
	private double time;

    public PneumaticLiftDown(double inputTime) {
        requires(Robot.pneumatics);
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLiftDown();
    	RobotMap.isDown = true;
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLiftDown();
    	RobotMap.isDown = true;
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