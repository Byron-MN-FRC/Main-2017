package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{
	//Setting chassis motors to CANTalon IDs
	static CANTalon motorChassisFrontRight = new CANTalon(RobotMap.talonDevIDChassisFrontRight);
	static CANTalon motorChassisBackRight = new CANTalon(RobotMap.talonDevIDChassisBackRight);
	
	static CANTalon motorChassisFrontLeft = new CANTalon(RobotMap.talonDevIDChassisFrontLeft);
	static CANTalon motorChassisBackLeft = new CANTalon(RobotMap.talonDevIDChassisBackLeft);

	// Creates robot drive configuration with four motors
	static RobotDrive chassisDrive = new RobotDrive(motorChassisFrontLeft,motorChassisBackLeft,motorChassisFrontRight,motorChassisBackRight);
	
	public Chassis() {
		super();
		//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		//chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
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
		double fakeYAxis = -twist;
		double fakeTwist = -yAxis;
		
		// Apply translations to the values from the controller
		fakeTwist = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("FakeSlowT", fakeTwist) : ThrottleLookup.calcJoystickCorrection("FakeNormT", fakeTwist);
		fakeYAxis = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("FakeSlowY", fakeYAxis) : ThrottleLookup.calcJoystickCorrection("FakeNormY", fakeYAxis); 
		
		SmartDashboard.putString("ROBOT MODE", (RobotMap.pMode) ? "Slow" : "Normal");	
				
		SmartDashboard.putNumber("JoystickY", yAxis);
		SmartDashboard.putNumber("JoystickX", xAxis);
		SmartDashboard.putNumber("JoystickTwist", twist);
		SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);
		//left/right, forward/backward, turning, gyro (none)
		chassisDrive.mecanumDrive_Cartesian(xAxis, fakeYAxis, fakeTwist, 0);
		//chassisDrive.arcadeDrive(-yAxis, -twist);
	}
}