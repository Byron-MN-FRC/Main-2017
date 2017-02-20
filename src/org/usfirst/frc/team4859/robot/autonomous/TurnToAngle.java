package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	
	private double angle;
	private double time;
	
	public TurnToAngle(double inputAngle, double inputTime) {
		requires(Robot.chassis);
		
		angle = inputAngle;
        time = inputTime;
	}
	
	protected void initialize() {
		//Robot.ahrs.reset();
		setTimeout(time);
		Robot.chassis.turnToAngle(angle);
	}

	protected void execute() {
		Robot.chassis.turnToAngle(angle);
		
	}

	protected boolean isFinished() {
		return isTimedOut();
		//Robot.ahrs.getYaw()%360 >= angle;
	}

	protected void end() {
		Robot.chassis.driveStop();
	}

	protected void interrupted() {
		Robot.chassis.driveStop();
	}
}