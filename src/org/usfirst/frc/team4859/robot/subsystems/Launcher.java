package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	static Talon motorLauncherFlywheelRight = new Talon(RobotMap.talonDevIDLauncherFlywheelRight);
	static Talon motorLauncherFlywheelLeft = new Talon(RobotMap.talonDevIDLauncherFlywheelLeft);
	static Talon motorLauncherFlywheelFeed = new Talon(RobotMap.talonDevIDLauncherFlywheelFeed);
	
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
    	motorLauncherFlywheelRight.set(-.2);
    	motorLauncherFlywheelLeft.set(.2);
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
    
    public void Intake() {
    	motorLauncherFlywheelRight.set(-.75);
    	motorLauncherFlywheelLeft.set(.75);
    	motorLauncherFlywheelFeed.set(-1);
    }
    
    public void IntakeStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    	motorLauncherFlywheelFeed.set(0);
    }
    
    public void FlywheelSpinUp(double inputSpeed){
    	motorLauncherFlywheelRight.set(inputSpeed);
    	motorLauncherFlywheelLeft.set(-inputSpeed);
	}
    
    public void FlywheelFeedOutTime(double inputSpeed) {
    	motorLauncherFlywheelFeed.set(-inputSpeed);
    }
}