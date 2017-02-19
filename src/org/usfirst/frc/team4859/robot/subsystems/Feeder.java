package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {
	
	public static CANTalon feederMotor = new CANTalon(RobotMap.talonIDFeeder);
	
	public Feeder() {
	}
	
    public void initDefaultCommand() {}
    
    public void feederForward() {
    	feederMotor.set(0.42);
	}
    
    public void feederBackward() {
    	feederMotor.set(-0.42);
	}
    
    public void feederStop() {
    	feederMotor.set(0);
	}
    
    public void feederForwardTime(double inputSpeed) {
    	feederMotor.set(inputSpeed);
	}
}