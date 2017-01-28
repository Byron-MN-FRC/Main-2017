package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Other extends Subsystem {

	public static Servo linearActuator = new Servo(9);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Other() {
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void servoForward() {
    	linearActuator.set(-1);
    }
    
    public void servoStop() {
    	linearActuator.set(-1);
    }
}