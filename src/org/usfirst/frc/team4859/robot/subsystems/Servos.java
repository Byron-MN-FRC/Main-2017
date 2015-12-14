package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Servos extends Subsystem {
    
	static Servo binServo = new Servo(9);
	
    public void initDefaultCommand()
    {
    }

	public void servo0()
	{
		binServo.setAngle(0.0);	
	}

	public void servo90()
	{
		binServo.setAngle(90.0);
	}
}