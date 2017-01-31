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
	// Create a joystick on port 0
	private final Joystick joystickP0 = new Joystick(0);
	private final Joystick xboxP1 = new Joystick(1);
	
	Button precisionMode = new JoystickButton(xboxP1, 6);
	Button flipMode = new JoystickButton(xboxP1, 5);
	
	Button climbUp = new JoystickButton(xboxP1, 4);
	Button climbDown = new JoystickButton(xboxP1, 1);
	
	//Button flywheelForward = new JoystickButton(xboxP1, 5);
 
	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flipMode.toggleWhenPressed(new FlipMode());
		
		climbUp.whenPressed(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
		climbDown.whenPressed(new ClimbDown());
		climbDown.whenReleased(new ClimbStop());
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
	
	public Joystick getXbox() {
		return xboxP1;
	}
}