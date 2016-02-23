package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pivot extends Subsystem {
	
	public CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	public DigitalInput limitSwitchUp = new DigitalInput(0);
	public DigitalInput limitSwitchDown = new DigitalInput(1);
	public static double mult;
	
	public Pivot() {
		super();
		motorLauncherAngle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
      
    public void AngleUp() {
    	// difference variable is the up position minus the position it's actually at
    	double diff = RobotMap.upPosition - motorLauncherAngle.getPosition();
    	mult += 0.15;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void AngleDown() {
    	double power = 0.0;
    	if (motorLauncherAngle.getPosition() < 0.7)
    		power = 0.5;
    	
    	motorLauncherAngle.set(power);
    }
    
    public void AngleFlat() {
    	// difference variable is the up position minus the position it's actually at
    	double diff = RobotMap.flatPosition - motorLauncherAngle.getPosition();
    	mult += 0.15;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void AngleStop() {
    	motorLauncherAngle.set(0.0);
    } 
    
    public boolean LimitSwitchUp() {
    	return limitSwitchUp.get();
    }
    
    public boolean LimitSwitchDown() {
    	return limitSwitchDown.get();
    }
}