
package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	Ultrasonic DistanceSensor = new Ultrasonic(1,1);
	
	public Launcher()
	{
		super();
		DistanceSensor.setAutomaticMode(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void DistanceSensor()
    {
    	double distance = DistanceSensor.getRangeInches();
    }
}

