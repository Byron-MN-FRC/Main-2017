package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	public static CANTalon motor3 = new CANTalon(RobotMap.talonIDMotor3);
	public static CANTalon motor4 = new CANTalon(RobotMap.talonIDMotor4);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public MotorSubsystem() {
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void motorForward() {
    	motor3.set(1);
    	motor4.set(1);
    }
    
    public void motorBackward() {
    	motor3.set(-1);
    	motor4.set(-1);
    }
    
    public void motorStop() {
    	motor3.set(0);
    	motor4.set(0);
    }
}

