package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launcher extends Subsystem {
	
	static Talon motorLauncherFlywheelRight = new Talon(RobotMap.talonDevIDLauncherFlywheelRight);
	static Talon motorLauncherFlywheelLeft = new Talon(RobotMap.talonDevIDLauncherFlywheelLeft);
	static Talon motorLauncherFlywheelFeed = new Talon(RobotMap.talonDevIDLauncherFlywheelFeed);
	public CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	public DigitalInput limitDown = new DigitalInput(0);
	public static double mult;
	
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
    	motorLauncherFlywheelRight.set(-.75);
    	motorLauncherFlywheelLeft.set(.75);
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
    
    public void LauncherAngleStop() {
    	motorLauncherAngle.set(0.0);
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
    
    public void LauncherAngleUp() {
    	double diff = (Robot.start - 0.16) - motorLauncherAngle.getPosition();
    	mult += 0.15;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void LauncherAngleDown() {
    	double diff = Robot.start - motorLauncherAngle.getPosition();
    	mult += 0.15;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void FlywheelSpinUp(double inputSpeed){
    	motorLauncherFlywheelRight.set(inputSpeed);
    	motorLauncherFlywheelLeft.set(-inputSpeed);
	}
    
    public void FlywheelFeedOutTime(double inputSpeed) {
    	motorLauncherFlywheelFeed.set(-inputSpeed);
    }
}