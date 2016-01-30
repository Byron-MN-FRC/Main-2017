
package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class Launcher extends Subsystem {
	
	Accelerometer accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	
	public Launcher()
	{
		super();
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    

}

