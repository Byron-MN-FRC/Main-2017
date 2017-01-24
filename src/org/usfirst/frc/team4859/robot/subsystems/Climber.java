package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//public static CANTalon climberMotor = new CANTalon(RobotMap.talonIDClimberMotor);
	
	public Climber() {
	}
	
    public void initDefaultCommand() {}
    
    public void climbUp() {
		//climberMotor.set(1.0);
	}
    
    public void climbStop() {
    	//climberMotor.set(0.0);
	}
}