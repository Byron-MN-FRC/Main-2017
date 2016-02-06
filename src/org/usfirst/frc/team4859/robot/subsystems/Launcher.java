package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	static Talon motorLauncherFlywheelRight = new Talon(RobotMap.talonDevIDLauncherFlywheelRight);
	static Talon motorLauncherFlywheelLeft = new Talon(RobotMap.talonDevIDLauncherFlywheelLeft);
	static Talon motorLauncherFlywheelFeed = new Talon(RobotMap.talonDevIDLauncherFlywheelFeed);
	static CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	
	public Launcher() {
		super();
		motorLauncherAngle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FlywheelForward() {
    	motorLauncherFlywheelRight.set(1);
    	motorLauncherFlywheelLeft.set(-1);
    }
    
    public void FlywheelBackward() {
    	motorLauncherFlywheelRight.set(-1);
    	motorLauncherFlywheelLeft.set(1);
    }
    
    public void FlywheelForwardSpin() {
    	motorLauncherFlywheelRight.set(1);
    	motorLauncherFlywheelLeft.set(-0.8);
    }
    
    public void FlywheelStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    }
    
    public void FlywheelFeedIn() {
    	motorLauncherFlywheelFeed.set(1);
    }
    
    public void FlywheelFeedOut() {
    	motorLauncherFlywheelFeed.set(-1);
    }
    
    public void FlywheelFeedStop() {
    	motorLauncherFlywheelFeed.set(0);
    }
}