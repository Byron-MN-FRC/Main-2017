package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public static DoubleSolenoid solenoid1 = new DoubleSolenoid(0,1);
	public static DoubleSolenoid solenoid2 = new DoubleSolenoid(2,3);
	
	public Pneumatics() {
	}
	
    public void initDefaultCommand() {}
    
    public void solenoidForward1() {
		solenoid1.set(DoubleSolenoid.Value.kForward);
	}
    
    public void solenoidBackward1() {
    	solenoid1.set(DoubleSolenoid.Value.kReverse);
	}
    
    public void solenoidOff1() {
    	solenoid1.set(DoubleSolenoid.Value.kOff);
	}
    public void solenoidForward2() {
		solenoid2.set(DoubleSolenoid.Value.kForward);
	}
    
    public void solenoidBackward2() {
    	solenoid2.set(DoubleSolenoid.Value.kReverse);
	}
    
    public void solenoidOff2() {
    	solenoid2.set(DoubleSolenoid.Value.kOff);
	}
}