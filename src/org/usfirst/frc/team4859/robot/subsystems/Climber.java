package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	public static Talon climberMotor = new Talon(RobotMap.talonIDClimberMotor);
	
	public Climber() {
	}
	
    public void initDefaultCommand() {}
    
    public void climbUp() {
		climberMotor.set(1);
	}
    
    public void climbDown() {
    	climberMotor.set(-1);
	}
    
    public void climbStop() {
    	climberMotor.set(0.0);
	}
}