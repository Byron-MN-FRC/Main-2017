package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	//Setting chassis motors to CANTalon IDs
	static CANTalon motorChassisRight = new CANTalon(RobotMap.talonDevIDChassisRight);
	static CANTalon motorChassisRightSlave = new CANTalon(RobotMap.talonDevIDChassisRightSlave);
	
	static CANTalon motorChassisLeft = new CANTalon(RobotMap.talonDevIDChassisLeft);
	static CANTalon motorChassisLeftSlave = new CANTalon(RobotMap.talonDevIDChassisLeftSlave);

	// Creates robot drive configuration with four motors
	static RobotDrive chassisDrive = new RobotDrive(motorChassisLeft, motorChassisRight);
	
	public Chassis() {
		super();
		//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRight, true);
		//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRight, true);
		
		motorChassisRightSlave.changeControlMode(ControlMode.Follower);
		motorChassisLeftSlave.changeControlMode(ControlMode.Follower);
		
		motorChassisRightSlave.set(12);
		motorChassisLeftSlave.set(16);
		
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
		twist = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowT", twist) : ThrottleLookup.calcJoystickCorrection("NormT", twist);
		
		SmartDashboard.putString("ROBOT MODE", (RobotMap.pMode) ? "Slow" : "Normal");	
				
		SmartDashboard.putNumber("JoystickY", yAxis);
		SmartDashboard.putNumber("JoystickX", xAxis);
		SmartDashboard.putNumber("JoystickTwist", twist);
		SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);
		
		chassisDrive.arcadeDrive(yAxis, twist);
	}
	
	public void DriveStraight(double inputSpeed)
	{
		//motorChassisRight.changeControlMode(ControlMode.Speed);
		//motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(inputSpeed,0);
	}
	
	public void DriveBackwards(double inputSpeed){		
		//motorChassisRight.changeControlMode(ControlMode.Speed);
		//motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(inputSpeed,0);
	}
	
	public void DriveStop(){
		chassisDrive.arcadeDrive(0,0);
	}
	
	public void DriveLeft(double inputSpeed){
		//motorChassisRight.changeControlMode(ControlMode.Speed);
		//motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(0,inputSpeed);
	}
	
	public void DriveRight(double inputSpeed){
	//	motorChassisRight.changeControlMode(ControlMode.Speed);
		//motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(0,-inputSpeed);
	}
}