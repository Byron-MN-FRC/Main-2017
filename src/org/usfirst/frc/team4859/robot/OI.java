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
	// Create joystick on port 0
	private final Joystick joystickP0 = new Joystick(0);
	
	// Create joystick on port 1 (xbox)
	private final Joystick xboxP1 = new Joystick(1);
	
	// Create button precisionMode on joystickP0, button 12
	Button precisionMode = new JoystickButton(joystickP0, 12);
	
	Button motorForward = new JoystickButton(xboxP1, 1);
	Button motorBackward = new JoystickButton(xboxP1, 3);
 
	public OI() {
		// Bind button precisionMode to toggle PrecisionMode command when pressed
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		motorForward.whenPressed(new MotorForward());
		motorForward.whenReleased(new MotorStop());
		
		motorBackward.whenPressed(new MotorBackward());
		motorBackward.whenReleased(new MotorStop());
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}