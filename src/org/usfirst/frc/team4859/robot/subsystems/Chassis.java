package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;
import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	public static WPI_TalonSRX motorChassisFrontLeft = new WPI_TalonSRX(RobotMap.talonIDChassisFrontLeft);
	public static WPI_TalonSRX motorChassisFrontRight = new WPI_TalonSRX(RobotMap.talonIDChassisFrontRight);
	
	public static WPI_TalonSRX motorChassisBackLeft = new WPI_TalonSRX(RobotMap.talonIDChassisBackLeft);
	public static WPI_TalonSRX motorChassisBackRight = new WPI_TalonSRX(RobotMap.talonIDChassisBackRight);

	public static RobotDrive chassisDrive = new RobotDrive(motorChassisFrontLeft, motorChassisBackLeft, motorChassisFrontRight, motorChassisBackRight);
	
	public static DigitalOutput lightStrip = new DigitalOutput(0);
	public static AnalogInput gearSensor = new AnalogInput(0);
	public static AnalogOutput gearLED = new AnalogOutput(1);
	
	public Chassis() {
		
		chassisDrive.setSafetyEnabled(true);
		chassisDrive.setExpiration(3);
	}
	
	public void initDefaultCommand () {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void driveWithJoystick(Joystick joystickP0) {
		double y = joystickP0.getY();
		double x = joystickP0.getX();
		double twist = joystickP0.getTwist();
		
		// Apply translations to the values from the controller
		y = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowY", y) : ThrottleLookup.calcJoystickCorrection("NormY", y);
		x = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowX", x) : ThrottleLookup.calcJoystickCorrection("NormX", x);
		twist = (RobotMap.pMode) ? ThrottleLookup.calcJoystickCorrection("SlowT", twist) : ThrottleLookup.calcJoystickCorrection("NormT", twist);
		
		// Apply flip if the flip button is toggled
		if (RobotMap.fMode) {
			y *= -1;
			x *= -1;
		}
		
		// Final joystick value adjustments
		x *= RobotMap.xAxisScale;
		y *= RobotMap.yAxisScale;
		twist *= RobotMap.twistScale;
		
		SmartDashboard.putString("Robot Mode", (RobotMap.pMode) ? "Slow" : "Normal");	
		
		chassisDrive.mecanumDrive_Cartesian(x, y, twist, 0);
	}
	
	public void driveStraight(double inputSpeed) {
		chassisDrive.mecanumDrive_Cartesian(0, inputSpeed, 0, 0);
	}
	
	public void driveStraightGyro(double inputSpeed) {
		//inputSpeed *= 500;
		//double inputTwist = -(Robot.ahrs.getYaw()%360)*0;
		
//		motorChassisFrontLeft.set(inputSpeed + inputTwist);
//		motorChassisFrontRight.set(inputSpeed - inputTwist);
//		motorChassisBackLeft.set(inputSpeed + inputTwist);
//		motorChassisBackRight.set(inputSpeed - inputTwist);
	}
	
	public void driveBackwards(double inputSpeed) {
		chassisDrive.mecanumDrive_Cartesian(0, inputSpeed, 0, 0);
	}
	
	public void strafeLeft(double inputSpeed) {
		chassisDrive.mecanumDrive_Cartesian(-inputSpeed, 0, 0, 0);
	}
	
	public void strafeRight(double inputSpeed) {
		chassisDrive.mecanumDrive_Cartesian(inputSpeed, 0, 0, 0);
	}
	
	public void driveStop() {
		chassisDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
	}
	
	public void turnToAngle(double targetAngle) {
//		double sensorAngle = Robot.ahrs.getYaw() % 360;
//		double turn = (targetAngle-sensorAngle)*2;
//		if (turn < 30) { turn = 30; }
//		
//		SmartDashboard.putNumber("anglemod", Robot.ahrs.getYaw()%360);
//		SmartDashboard.putNumber("turnspd", turn);
//		
//		motorChassisFrontLeft.set(turn);
//		motorChassisFrontRight.set(-turn);
//		motorChassisBackLeft.set(turn);
//		motorChassisBackRight.set(-turn);
	}
	
	public void wiggle(double forwardSpeed, double turnSpeed) {
		chassisDrive.mecanumDrive_Cartesian(0, forwardSpeed, turnSpeed, 0);
	}
	
	public void circleTurnLeft(double speed, double ratio) {
		motorChassisFrontLeft.set(speed);
		motorChassisFrontRight.set(speed*ratio);
		motorChassisBackLeft.set(speed);
		motorChassisBackRight.set(speed*ratio);
	}
	
	public void circleTurnRight(double speed, double ratio) {
		motorChassisFrontLeft.set(speed*ratio);
		motorChassisFrontRight.set(speed);
		motorChassisBackLeft.set(speed*ratio);
		motorChassisBackRight.set(speed);
	}
}