package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CircleTurn extends Command {
	
	private double speed;
	private double ratio;
	private double time;
	
	public CircleTurn(double inputSpeed, double inputRatio, double inputTime) {
		requires(Robot.chassis);
		
		speed = inputSpeed;
		ratio = inputRatio;
        time = inputTime;
	}
	
	protected void initialize() {
		setTimeout(time);
		Robot.chassis.circleTurn(speed, ratio);
	}

	protected void execute() {
		Robot.chassis.circleTurn(speed, ratio);
		
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		//Robot.chassis.driveStop();
	}

	protected void interrupted() {
		Robot.chassis.driveStop();
	}
}