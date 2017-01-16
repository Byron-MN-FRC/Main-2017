package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	// Creating and setting motors
	public static CANTalon motorChassisFrontLeft = new CANTalon(RobotMap.talonIDChassisFrontLeft);
	public static CANTalon motorChassisFrontRight = new CANTalon(RobotMap.talonIDChassisFrontRight);
	
	public static CANTalon motorChassisBackLeft = new CANTalon(RobotMap.talonIDChassisBackLeft);
	public static CANTalon motorChassisBackRight = new CANTalon(RobotMap.talonIDChassisBackRight);

	// Creates robot drive configuration with four motors
	static RobotDrive chassisDrive = new RobotDrive(motorChassisFrontLeft, motorChassisBackLeft, motorChassisFrontRight, motorChassisBackRight);
	
	public Chassis() {
		motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		
		motorChassisFrontRight.changeControlMode(TalonControlMode.PercentVbus);
		motorChassisBackRight.changeControlMode(TalonControlMode.PercentVbus);
		
		// Set a timeout for the motors (1 seconds)
		chassisDrive.setSafetyEnabled(true);
		chassisDrive.setExpiration(1);
	}
	
	public void initDefaultCommand () {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void driveWithJoystick(Joystick joystickP0) {
		// Get raw values from joystick controller
		double yAxis = joystickP0.getY();
		double xAxis = joystickP0.getX();
		double twist = joystickP0.getTwist();
		
		// Apply translations to the values from the controller
		yAxis = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowY", yAxis) : ThrottleLookup.calcJoystickCorrection("NormY", yAxis);
		xAxis = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowX", xAxis) : ThrottleLookup.calcJoystickCorrection("NormX", xAxis);
		twist = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowT", twist) : ThrottleLookup.calcJoystickCorrection("NormT", twist);
		
		SmartDashboard.putString("Robot Mode", (RobotMap.pMode) ? "Slow" : "Normal");	
				
		SmartDashboard.putNumber("JoystickY", yAxis);
		SmartDashboard.putNumber("JoystickX", xAxis);
		SmartDashboard.putNumber("JoystickTwist", twist);
		SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);
		
		chassisDrive.mecanumDrive_Cartesian(xAxis, -twist*0.9, -yAxis, 0);
	}
	
	public void DriveStraight(double inputSpeed)
	{
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		chassisDrive.arcadeDrive(inputSpeed,0);
	}
	
	public void DriveStraightGyro(double inputSpeed)
	{
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
//		chassisDrive.arcadeDrive(inputSpeed,Robot.gyro.getAngle()*0.06);
	}
	
	public void DriveBackwards(double inputSpeed){		
		chassisDrive.arcadeDrive(-inputSpeed,0);
	}
	
	public void DriveStop(){
		chassisDrive.arcadeDrive(0,0);
	}
	
	public void DriveLeftCenter(double inputSpeed){
		chassisDrive.arcadeDrive(0,inputSpeed);
	}
	
	public void DriveLeftForwards(double inputSpeed){

		chassisDrive.arcadeDrive(inputSpeed,inputSpeed);
	}
	
	public void DriveLeftBackwards(double inputSpeed){
		chassisDrive.arcadeDrive(-inputSpeed,inputSpeed);
	}
	
	public void DriveRightCenterGyro(double angle){
//		chassisDrive.arcadeDrive(0,(Robot.gyro.getAngle()%360-angle)*0.04);
	}
	
	public void DriveRightForwards(double inputSpeed){
		chassisDrive.arcadeDrive(inputSpeed,-inputSpeed);
		}
	
	public void DriveRightBackwards(double inputSpeed){
		chassisDrive.arcadeDrive(-inputSpeed,-inputSpeed);
		}
}