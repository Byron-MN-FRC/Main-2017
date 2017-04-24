package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticsLock extends Subsystem {
	
	DoubleSolenoid pneumaticLock = new DoubleSolenoid(0, 1);

	public PneumaticsLock() {
	}
	
    public void initDefaultCommand() {}
    
    public void pneumaticLock() {
		pneumaticLock.set(Value.kForward);
	}
    
    public void pneumaticUnlock() {
    	pneumaticLock.set(Value.kReverse);
	}
    public void pneumaticStop() {
    	pneumaticLock.set(Value.kOff);
	}
}