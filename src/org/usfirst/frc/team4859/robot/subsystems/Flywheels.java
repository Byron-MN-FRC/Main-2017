package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flywheels extends Subsystem {

	public static CANTalon flywheelLeft = new CANTalon(RobotMap.talonIDFlywheelLeft);
	public static CANTalon flywheelRight = new CANTalon(RobotMap.talonIDFlywheelRight);
	
	public Flywheels() {
	}
	
    public void initDefaultCommand() {}
    
    public void flywheelForward() {
    	flywheelLeft.set(1);
    	flywheelRight.set(-1);
	}
    
    public void flywheelBackward() {
    	flywheelLeft.set(-1);
    	flywheelRight.set(1);
	}
    
    public void flywheelStop() {
    	flywheelLeft.set(0);
    	flywheelRight.set(0);
	}
    
    public void flywheelSpinUp(double inputSpeed) {
    	flywheelLeft.set(inputSpeed);
    	flywheelRight.set(-inputSpeed);
	}
}