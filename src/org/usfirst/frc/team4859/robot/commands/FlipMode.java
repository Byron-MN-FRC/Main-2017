package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class FlipMode extends Command {
	protected void initialize() {
		RobotMap.fMode = true;
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		RobotMap.fMode = false;
	}
	
	protected void interrupted() {
		RobotMap.fMode = false;
	}
}