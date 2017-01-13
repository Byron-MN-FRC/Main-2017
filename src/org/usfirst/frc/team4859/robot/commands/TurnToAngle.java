package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	
	private double twist;
	private double angle;

	public TurnToAngle(double twist, double angle) {
		requires(Robot.chassis);
//		Robot.gyro.reset();
		this.twist = twist;
		this.angle = angle;
	}
	
	@Override
	protected void initialize() {
		Robot.chassis.DriveRightCenterGyro(twist);
	}

	@Override
	protected void execute() {
		Robot.chassis.DriveRightCenterGyro(twist);
	}

	@Override
	protected boolean isFinished() {
		return false;
//		return Robot.gyro.getAngle() >= angle;
	}

	@Override
	protected void end() {
		Robot.chassis.DriveStop();
	}

	@Override
	protected void interrupted() {
	}

}