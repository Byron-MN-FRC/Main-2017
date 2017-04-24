package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticsLift extends Subsystem {
	
	DoubleSolenoid pneumaticLift = new DoubleSolenoid(2, 3);

	public PneumaticsLift() {
	}
	
    public void initDefaultCommand() {}
    
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

