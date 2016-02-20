package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pivot extends Subsystem {
	
	public CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	public DigitalInput limitSwitch = new DigitalInput(0);
	public static double mult;
	
	public Pivot() {
		super();
		motorLauncherAngle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
      
    public void LauncherAngleUp() {
    	// difference variable is the up position minus the position it's actually at
    	double diff = (0.15 /*Max is about 0.74 OLD VALUES: Normal: 0.24 Max: 0.24*/) - motorLauncherAngle.getPosition();
    	mult += 0.1;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void LauncherAngleDown() {
    	double power = 0.0;
    	if (motorLauncherAngle.getPosition() < 0.7)
    		power = 0.4;
    	
    	motorLauncherAngle.set(power);
    }
    
    public void LauncherAngleStop() {
    	motorLauncherAngle.set(0.0);
    } 
    
    public boolean LimitSwitchCheck() {
    	return limitSwitch.get();
    }
}