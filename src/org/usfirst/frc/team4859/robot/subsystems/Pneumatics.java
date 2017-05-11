
package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	DoubleSolenoid pneumaticLock = new DoubleSolenoid(0, 1);
	DoubleSolenoid pneumaticLift = new DoubleSolenoid(2, 3);
	DoubleSolenoid pneumaticRelease1 = new DoubleSolenoid(4, 5);
	DoubleSolenoid pneumaticRelease2 = new DoubleSolenoid(6, 7);

	public Pneumatics() {
	}
	
    public void initDefaultCommand() {}
    
    public void pneumaticLiftUp() {
    	pneumaticLift.set(Value.kForward);
    	pneumaticLock.set(Value.kForward);
	}
    
    public void pneumaticLiftDown() {
    	pneumaticLift.set(Value.kReverse);
    	pneumaticLock.set(Value.kReverse);
    	pneumaticRelease1.set(Value.kReverse);
		pneumaticRelease2.set(Value.kReverse);
	}
    
    public void pneumaticLiftStop() {
    	pneumaticLift.set(Value.kOff);
	}
    public void pneumaticLock() {
		pneumaticLock.set(Value.kForward);
		pneumaticRelease1.set(Value.kReverse);
		pneumaticRelease2.set(Value.kReverse);
	}
    
    public void pneumaticUnlock() {
    	pneumaticLock.set(Value.kReverse);
    	
    	if (!RobotMap.isDown) {
    		pneumaticRelease1.set(Value.kForward);
    		pneumaticRelease2.set(Value.kForward);
    	}
    	else {
    		pneumaticRelease1.set(Value.kReverse);
    		pneumaticRelease2.set(Value.kReverse);
    	}
	}
    public void pneumaticStop() {
    	pneumaticLock.set(Value.kOff);
	}
}