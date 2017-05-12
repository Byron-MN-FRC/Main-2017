package org.usfirst.frc.team4859.robot;

public class RobotMap {
	
	public static int talonIDChassisFrontLeft = 2;
	public static int talonIDChassisFrontRight = 3;
	
	public static int talonIDChassisBackLeft = 4;
	public static int talonIDChassisBackRight = 5;
	
	public static int talonIDClimberMotor = 0;
	
	// Creating variables to scale axis' across the entire curve (values from 0 to 1)
	public static double xAxisScale = 1;
	public static double yAxisScale = 1;
	public static double twistScale = 1;
	
	public static boolean pMode = false;
	public static boolean fMode = false; 
	
	public static boolean islocked;
	public static boolean isDown;
	public static boolean isGearInRobot;
}