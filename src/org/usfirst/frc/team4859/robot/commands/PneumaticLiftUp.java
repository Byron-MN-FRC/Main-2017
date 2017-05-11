package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftUp extends Command {

	private double time;

    public PneumaticLiftUp(double inputTime) {
        requires(Robot.pneumatics);        
        time = inputTime;
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLiftUp();
    	setTimeout(time);
    	RobotMap.isDown = false;
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLiftUp();
    	RobotMap.isDown = false;
    }

    protected boolean isFinished() {
    	if (time <= 0) return false;
    	else return isTimedOut();
    }

    protected void end() {
    	Robot.pneumatics.pneumaticLiftUp();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticLiftStop();
    }
}