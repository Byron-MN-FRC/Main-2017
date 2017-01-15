package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {

	private double inputSpeed;
	private double distance;
//	private boolean ultra;
//	private double[] last_fifty = {1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0};
	public double pethan;
	
	public DriveToDistance(double inputSpeed, double distance) {
		requires(Robot.chassis);
		this.inputSpeed = inputSpeed;
		this.distance = distance;
//		this.ultra = ultra;
	}
	
	@Override
	protected void initialize() {
    	Robot.ahrs.reset();
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected void execute() {
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected boolean isFinished() {
//		double val = 0.0;
//		if (ultra)
//			val = Robot.ultra.getAverageVoltage()*8.8365*12;
//		else 
//			val = Robot.ultra2.getAverageVoltage()*8.8365*12;
//		
//		
//		for (int i = 0; i < 49; i++) {                
//			this.last_fifty[i+1] = this.last_fifty[i];
//		}
//		this.last_fifty[0] = val;
//		
//		double[] copied = Arrays.copyOf(this.last_fifty, 50);
//		Arrays.sort(copied);
//		SmartDashboard.putNumber("Pethan", copied[25]);
//		return copied[25] <= distance;
		
		return true;
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
