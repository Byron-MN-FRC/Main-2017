package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flywheels extends Subsystem {
	
	static Talon motorLauncherFlywheelRight = new Talon(RobotMap.talonDevIDLauncherFlywheelRight);
	static Talon motorLauncherFlywheelLeft = new Talon(RobotMap.talonDevIDLauncherFlywheelLeft);
	double voltage = DriverStation.getInstance().getBatteryVoltage();
	
	public Flywheels() {
		super();
		SmartDashboard.putNumber("Flywheel", 1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void FlywheelForwardMax() {
    	voltage = DriverStation.getInstance().getBatteryVoltage();
    	motorLauncherFlywheelRight.set((11/voltage));
    	motorLauncherFlywheelLeft.set((-11/voltage));
    }
    
    public void FlywheelForward() {
    	voltage = DriverStation.getInstance().getBatteryVoltage();
    	motorLauncherFlywheelRight.set((11/voltage)*0.85);
    	motorLauncherFlywheelLeft.set((-11/voltage)*0.85);
    }
    
    public void FlywheelForwardSlow() {
    	voltage = DriverStation.getInstance().getBatteryVoltage();
    	motorLauncherFlywheelRight.set((11/voltage)*0.4);
    	motorLauncherFlywheelLeft.set((-11/voltage)*0.4);
    }
    
    public void FlywheelBackward() {
    	motorLauncherFlywheelRight.set(-.2);
    	motorLauncherFlywheelLeft.set(.2);
    }
    
    public void FlywheelStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    }
    
    public void Intake() {
    	motorLauncherFlywheelRight.set(-0.65);
    	motorLauncherFlywheelLeft.set(0.65);
    	Feeder.motorLauncherFlywheelFeed.set(1);
    }
    
    public void IntakePower() {
    	motorLauncherFlywheelRight.set(-1);
    	motorLauncherFlywheelLeft.set(1);
    	Feeder.motorLauncherFlywheelFeed.set(1);
    }
    
    public void IntakeStop() {
    	motorLauncherFlywheelRight.set(0);
    	motorLauncherFlywheelLeft.set(0);
    	Feeder.motorLauncherFlywheelFeed.set(0);
    }
    
//  public void FlywheelSpinUp(double inputSpeed){
//    	voltage = DriverStation.getInstance().getBatteryVoltage();
//    	motorLauncherFlywheelRight.set(inputSpeed/voltage);
//    	motorLauncherFlywheelLeft.set(-inputSpeed/voltage);
//	}
}