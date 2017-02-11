package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class FlipMode extends Command {
	protected void initialize() {
		RobotMap.fMode = true;
		Chassis.lightStrip.set(true);
	}
	
	protected void execute() {}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		RobotMap.fMode = false;
		Chassis.lightStrip.set(false );
	}
	
	protected void interrupted() {
		RobotMap.fMode = false;
		Chassis.lightStrip.set(false);
	}
}