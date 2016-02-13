package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    
    public void FlywheelSpinup() {
    	motorLauncherFlywheelRight.set(1);
    	motorLauncherFlywheelLeft.set(-1);
    }
    
    public void Intake() {
    	motorLauncherFlywheelRight.set(-.5);
    	motorLauncherFlywheelLeft.set(.5);
    	motorLauncherFlywheelFeed.set(-1);
    }
    
    public void FlywheelForwardSpin() {
    	motorLauncherFlywheelRight.set(1);
    	motorLauncherFlywheelLeft.set(-0.8);
    }
    
    public void FlywheelStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    	motorLauncherFlywheelFeed.set(0);
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
    public void LauncherAngleDown(){
    	motorLauncherAngle.set(.545);
    }
    public void LauncherAngleUp() {
    	motorLauncherAngle.set(.35);
    }
    public void LauncherAngleStop() {
    	motorLauncherAngle.set(0.0);
    }
    
    public double LauncherMotorGo(double input, double multiplier) {
    	double diff = input - motorLauncherAngle.getPosition();
    	double new_multiplier = multiplier + 0.3;
    	if (new_multiplier > 100) new_multiplier = 100;
    	motorLauncherAngle.set(new_multiplier*diff);
    	return new_multiplier;
    }
    
    public void FlywheelSpinUp(double inputSpeed){
    	motorLauncherFlywheelRight.set(inputSpeed);
    	motorLauncherFlywheelLeft.set(-inputSpeed);
	}
    
    public void FlywheelFeedOutTime(double inputSpeed) {
    	motorLauncherFlywheelFeed.set(-inputSpeed);
    }
}