
package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	static Victor motorLauncherFlywheelRight = new Victor(RobotMap.talonDevIDLauncherFlywheelRight);
	static Victor motorLauncherFlywheelLeft = new Victor(RobotMap.talonDevIDLauncherFlywheelRight);
	static Talon motorLauncherFlywheelFeed = new Talon(RobotMap.talonDevIDLauncherFlywheelFeed);
	static CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	
	public Launcher() {
		super();
		
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
    	motorLauncherFlywheelLeft.set(-0.75);
    }
    
    public void FlywheelStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    }
    
    public void FlywheelFeedIn() {
    	motorLauncherFlywheelFeed.set(-1);
    }
    
    public void FlywheelFeedOut() {
    	motorLauncherFlywheelFeed.set(1);
    }
    
    public void FlywheelFeedStop() {
    	motorLauncherFlywheelFeed.set(0);
    }
    
    public void LauncherAngle30() {
    	
    }
    
    public void LauncherAngle40() {
    	
    }

    public void LauncherAngle50() {
	
    }

    public void LauncherAngle60() {
	
    }

    public void LauncherAngle70() {
	
    }
    
    public void LauncherAngle80() {
    	
    }
    
    public void LauncherAngle90() {
    	
    }
}

