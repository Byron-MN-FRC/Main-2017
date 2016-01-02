package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.PrecisionMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	// Create a joystick on port 0
	private final Joystick joystickP0 = new Joystick(0);
	
	// Create button for precision mode for joystick button 12
	//Button precisionMode = new JoystickButton(joystickP0, 12);

	public OI()
	{
		//precisionMode.toggleWhenPressed(new PrecisionMode());
		
	}
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

