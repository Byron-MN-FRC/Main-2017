package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	// Creating and setting motors
	public static CANTalon motorChassisRight = new CANTalon(RobotMap.talonDevIDChassisRight);
	public static CANTalon motorChassisRightSlave = new CANTalon(RobotMap.talonDevIDChassisRightSlave);
	
	public static CANTalon motorChassisLeft = new CANTalon(RobotMap.talonDevIDChassisLeft);
	public static CANTalon motorChassisLeftSlave = new CANTalon(RobotMap.talonDevIDChassisLeftSlave);

	// Creates robot drive configuration with four motors
	static RobotDrive chassisDrive = new RobotDrive(motorChassisLeft, motorChassisRight);
	
	public Chassis() {
		super();
		
		motorChassisRight.changeControlMode(TalonControlMode.PercentVbus);
		motorChassisLeft.changeControlMode(TalonControlMode.PercentVbus);
		
		motorChassisRightSlave.changeControlMode(TalonControlMode.Follower);
		motorChassisLeftSlave.changeControlMode(TalonControlMode.Follower);
		
		motorChassisRightSlave.set(RobotMap.talonDevIDChassisRight);
		motorChassisLeftSlave.set(RobotMap.talonDevIDChassisLeft);
		
		//motorChassisRight.changeControlMode(TalonControlMode.Speed);
		//motorChassisLeft.changeControlMode(TalonControlMode.Speed);
		
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
		
		// Sensors
		SmartDashboard.putNumber("Distance (inches)", Robot.ultra.getVoltage()*8.8365*12);
		SmartDashboard.putNumber("Distance (feet)", (Robot.ultra.getVoltage()*8.8365));
		SmartDashboard.putNumber("Distance 2 (inches)", Robot.ultra2.getVoltage()*8.8365*12);
		SmartDashboard.putNumber("Distance 2 (feet)", (Robot.ultra2.getVoltage()*8.8365));
		SmartDashboard.putNumber("Gyro Angle", (Robot.gyro.getAngle()));
		
		chassisDrive.arcadeDrive(-yAxis, -twist*0.8);
	}
	
	public void DriveStraight(double inputSpeed)
	{
		Chassis.motorChassisRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisLeft.changeControlMode(TalonControlMode.PercentVbus);
		chassisDrive.arcadeDrive(inputSpeed,0);
	}
	
	public void DriveStraightGyro(double inputSpeed)
	{
		Chassis.motorChassisRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisLeft.changeControlMode(TalonControlMode.PercentVbus);
		chassisDrive.arcadeDrive(inputSpeed,Robot.gyro.getAngle()*0.04);
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
		chassisDrive.arcadeDrive(0,(Robot.gyro.getAngle()%360-angle)*0.03);
	}
	
	public void DriveRightForwards(double inputSpeed){
		chassisDrive.arcadeDrive(inputSpeed,-inputSpeed);
		}
	
	public void DriveRightBackwards(double inputSpeed){
		chassisDrive.arcadeDrive(-inputSpeed,-inputSpeed);
		}
}