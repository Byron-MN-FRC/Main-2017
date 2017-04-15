package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	DoubleSolenoid pneumaticLock = new DoubleSolenoid(0, 1);
	DoubleSolenoid pneumaticLift = new DoubleSolenoid(2, 3);

	public Pneumatics() {
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
    
    public void pneumaticLiftUp() {
    	pneumaticLift.set(Value.kForward);
	}
    
    public void pneumaticLiftDown() {
    	pneumaticLift.set(Value.kReverse);
	}
    
    public void pneumaticLiftStop() {
    	pneumaticLift.set(Value.kOff);
	}
}

