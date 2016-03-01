package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {

	private double inputSpeed;
	private double distance;
	private boolean ultra;
	
	public DriveToDistance(double inputSpeed, double distance, boolean ultra) {
		requires(Robot.chassis);
		this.inputSpeed = inputSpeed;
		this.distance = distance;
		this.ultra = ultra;
	}	
	
	@Override
	protected void initialize() {
    	Robot.gyro.reset();
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected void execute() {
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected boolean isFinished() {
		if (ultra)
			return Robot.ultra.getVoltage()*8.8365*12 <= distance;
		else 
			return Robot.ultra2.getVoltage()*8.8365*12 <= distance;
	}

	@Override
	protected void end() {
		Robot.chassis.DriveStop();
	}

	@Override
	protected void interrupted() {
    	Robot.chassis.DriveStop();
	}
}
