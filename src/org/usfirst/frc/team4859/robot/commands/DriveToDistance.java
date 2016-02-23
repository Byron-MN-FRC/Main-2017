package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {

	private double inputSpeed;
	private double distance;
	
	public DriveToDistance(double inputSpeed, double distance) {
		requires(Robot.chassis);
		this.inputSpeed = inputSpeed;
		this.distance = distance;
	}	
	
	@Override
	protected void initialize() {
		Robot.chassis.DriveStraight(inputSpeed);
	}

	@Override
	protected void execute() {
		Robot.chassis.DriveStraight(inputSpeed);
	}

	@Override
	protected boolean isFinished() {
		return Robot.ultra.getVoltage()*3.28084*12 <= distance;
	}

	@Override
	protected void end() {
		Robot.chassis.DriveStop();
	}

	@Override
	protected void interrupted() {
	}

}