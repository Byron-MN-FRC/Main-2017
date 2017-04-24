package org.usfirst.frc.team4859.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int talonIDChassisFrontLeft = 2;
	public static int talonIDChassisFrontRight = 3;
	
	public static int talonIDChassisBackLeft = 4;
	public static int talonIDChassisBackRight = 5;
	
	public static int talonIDClimberMotor = 0;
	
	public static int talonIDFeeder = 7;
	
	public static int talonIDFlywheelLeft = 8;
	public static int talonIDFlywheelRight = 9;
	
	// Creating variables to scale axis' across the entire curve (values from 0 to 1)
	public static double xAxisScale = 1;
	public static double yAxisScale = 1;
	public static double twistScale = 1;
	
	// Creating precision mode variable and set to false by default
	public static boolean pMode = false;
	
	public static boolean fMode = false; 
	
	public static boolean locked = false;
}