package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	// Create a joysticks on port 0 and 1
	private final Joystick joystickP0 = new Joystick(0);
	//private final Joystick xboxP1 = new Joystick(1);
	
	// Creating buttons
	Button precisionMode = new JoystickButton(joystickP0, 1);
	Button flipMode = new JoystickButton(joystickP0, 2);
	
	Button climbUp = new JoystickButton(joystickP0, 6);
	Button climbDown = new JoystickButton(joystickP0, 4);
 
	public OI() {
		// Mapping buttons to command
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flipMode.toggleWhenPressed(new FlipMode());
		
		climbUp.whenPressed(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
		climbDown.whenPressed(new ClimbDown());
		climbDown.whenReleased(new ClimbStop());
	}
	
	// Creating a method that returns joystick values for driving
	public Joystick getJoystick() {
		return joystickP0;
	}
}