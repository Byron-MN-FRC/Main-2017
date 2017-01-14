package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	
	private double angle;
	private double time;
	
	public TurnToAngle(double angle, double time) {
		requires(Robot.chassis);
		this.angle = angle;
        this.time = time;
	}
	
	@Override
	protected void initialize() {
//		Robot.gyro.reset();
		setTimeout(time);
		Robot.chassis.driveRightCenterGyro(angle);
	}

	@Override
	protected void execute() {
		Robot.chassis.driveRightCenterGyro(angle);
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
				//Robot.gyro.getAngle()%360 >= angle;
	}

	@Override
	protected void end() {
		Robot.chassis.driveStop();
	}

	@Override
	protected void interrupted() {
		Robot.chassis.driveStop();
	}

}
