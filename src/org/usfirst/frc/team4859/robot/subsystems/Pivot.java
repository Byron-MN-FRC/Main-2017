package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pivot extends Subsystem {
	
	public CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	public DigitalInput limitSwitchUp = new DigitalInput(0);
	public DigitalInput limitSwitchDown = new DigitalInput(1);
	public static double mult;
	
	public Pivot() {
		super();
		SmartDashboard.putNumber("Pivot Angle", RobotMap.shootPosition);
		motorLauncherAngle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
      
    public void AngleShoot() {
    	// difference variable is the up position minus the position it's actually at
    	//SmartDashboard.getNumber("Pivot Angle")
    	double diff = RobotMap.shootPosition - motorLauncherAngle.getPosition();
    	mult += 0.2;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void AngleDown() {
    	double power = 0.0;
    	if (motorLauncherAngle.getPosition() < 0.6)
    		power = 0.4;
    	
    	motorLauncherAngle.set(power);
    }
    
    public void AngleUp() {
    	// difference variable is the up position minus the position it's actually at
    	//SmartDashboard.getNumber("Pivot Angle")
    	double diff = RobotMap.upPosition - motorLauncherAngle.getPosition();
    	mult += 0.2;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void AngleFlat() {
    	// difference variable is the up position minus the position it's actually at
    	double diff = RobotMap.flatPosition - motorLauncherAngle.getPosition();
    	mult += 0.2;
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