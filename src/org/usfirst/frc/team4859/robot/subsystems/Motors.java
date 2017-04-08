package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Motors extends Subsystem {

	public static CANTalon talonSRX = new CANTalon(RobotMap.talonSRX);
	public static Talon talonSR = new Talon(RobotMap.talonSRX);
	public static Spark spark1 = new Spark(RobotMap.talonSRX);
	public static Spark spark2 = new Spark(RobotMap.talonSRX);
	
	public Motors() {
	}
	
    public void initDefaultCommand() {}
    
    public void motorFoward() {
		talonSRX.set(-1);
		talonSR.set(-1);
		spark1.set(-1);
		spark2.set(-1);
	}
    
    public void motorBackward() {
    	talonSRX.set(1);
		talonSR.set(1);
		spark1.set(1);
		spark2.set(1);
	}
    
    public void motorStop() {
    	talonSRX.set(0);
		talonSR.set(0);
		spark1.set(0);
		spark2.set(0);
	}
}