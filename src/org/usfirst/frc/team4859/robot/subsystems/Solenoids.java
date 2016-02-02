package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Solenoids extends Subsystem {
    
	static DoubleSolenoid SolenoidDoublePiston = new DoubleSolenoid(0,1);

    // here. Call these from Commands.
	
	public Solenoids()
	{
		super();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void SolenoidForward()
    {
    	SolenoidDoublePiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void SolenoidReverse()
    {
    	SolenoidDoublePiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void SolenoidStop()
    {
    	SolenoidDoublePiston.set(DoubleSolenoid.Value.kOff);

    }
    
}