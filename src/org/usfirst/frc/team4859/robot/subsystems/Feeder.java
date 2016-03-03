package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {
	
	static Talon motorLauncherFlywheelFeed = new Talon(RobotMap.talonDevIDLauncherFlywheelFeed);
	
	public Feeder() {
		super();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FeedIn() {
    	motorLauncherFlywheelFeed.set(1);
    }
    
    public void FeedOut() {
    	motorLauncherFlywheelFeed.set(-1);
    }
    
    public void FeedStop() {
    	motorLauncherFlywheelFeed.set(0);
    }
    
    public void FeedOutTime() {
    	motorLauncherFlywheelFeed.set(-1);
    }
}