package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// The lifting mechanism  control

public class Lifter extends Subsystem
{	
	//Forward limit switch is bottom limit switch
	//Reverse limit switch is the top limit switch
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	
	static Talon motorLifterSRLeft = new Talon(RobotMap.talonDevIDLifterSRLeft);
	static Talon motorLifterSRRight = new Talon(RobotMap.talonDevIDLifterSRRight);
	
	//Creating PhotoSensor
	static AnalogInput photoSwitch = new AnalogInput(0);
	
	public Lifter()
	{
		super();
		motorLifterLeft.changeControlMode(ControlMode.Follower); //change left motor control mode to follower mode
		motorLifterLeft.set(RobotMap.talonDevIDLifterRight); //tell the left motor to follow the right motor
	}
	
	
	protected void initDefaultCommand() 
	{
	}
	
	// brings lift up 
	public void liftUp()
	{ 
		//set motor speeds for when you call LiftUp
		motorLifterRight.set(-0.65);
		motorLifterSRLeft.set(0.5);
		motorLifterSRRight.set(-0.5);
		SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
		SmartDashboard.putString("Lift", "Up");
	}
	
	public void liftUpFast(){ // brings lift up du
		//set motor speeds for when you call LiftUp
		motorLifterRight.set(-1.0);
		motorLifterSRLeft.set(0.7);
		motorLifterSRRight.set(-0.7);
		SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
		SmartDashboard.putString("Lift", "Up");
	}
	
	public void liftDown() //brings lift down du.
	{
		//set motor speeds for when you call LiftDown
		motorLifterRight.set(0.6);
		motorLifterSRLeft.set(-0.4);
		motorLifterSRRight.set(0.4);
		SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
		SmartDashboard.putString("Lift", "Down");
	}
	
	public void liftDownFast() //brings lift down du.
	{
		//set motor speeds for when you call LiftDown
		motorLifterRight.set(1.0);
		motorLifterSRLeft.set(-0.65);
		motorLifterSRRight.set(0.65);
		SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
		SmartDashboard.putString("Lift", "Down");
	}
	
	public void liftStop() //stops lift motors du
	{
		motorLifterRight.ClearIaccum();
		//set motor speeds for when you call LiftStop
		motorLifterRight.set(0.0);
		motorLifterSRLeft.set(0.0);
		motorLifterSRRight.set(0.0);
		SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
		SmartDashboard.putString("Lift", "Stopped");
	}
	
	public void liftUpTime()
	{
		motorLifterRight.set(-0.7);
		motorLifterSRLeft.set(0.65);
		motorLifterSRRight.set(-0.65);

	}

	public void liftDownTime()
	{
		motorLifterRight.set(0.5);
		motorLifterSRLeft.set(-0.45);
		motorLifterSRRight.set(0.45);

	}
	
	
	//		// Utility function to adjust joystick coordinates
	//		private double joystickAdjust(double value, double deadzone)
	//		{
	//			double temp;
	//			// Value is the value from the joystick, deadzone is self-explanatory
	//			// Squaring and deadzones for cartesian (X, Y, and Twist(Z) value
	//					if(value > deadzone)
	//					{
	//						temp = value;
	//					}
	//					else if(value < -deadzone)
	//					{
	//						temp = value;
	//					}
	//					else
	//					{
	//						motorLifterRight.ClearIaccum();
	//						temp = 0;
	//					}
	//			return temp;
	//		}
	//		
	//		
	//		//Made this to adjust the speed up and down from dashboard the values and to see the values
	//		//Also made the Lift Up & Down by VIA the Second Joystick joystickP1 or in Port 1
	//		public void joystickLifter(Joystick joystickP1) {
	//			double y = joystickAdjust(joystickP1.getY()*1000, .06);
	//			
	//			motorLifterRight.set(y/2);
	//		}
		
		public void liftAutoUp()
		{
			// Set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >1 && photoSwitch.getVoltage()<0){	
					motorLifterRight.set(-0.7);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putString("Lift", "UP");
				} else if((motorLifterRight.isRevLimitSwitchClosed())){
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Up");
				} 
		}
		
		public void liftAutoDown()
		{
			// Set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10 && photoSwitch.getVoltage()<4){	
					motorLifterRight.set(.40);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putString("Lift", "DOWN");
			}else if(motorLifterRight.isFwdLimitSwitchClosed()){
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Down");
			} 
		}
}