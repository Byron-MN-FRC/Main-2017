package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {	
	// Create a joysticks on port 0 and 1
	private final Joystick joystick = new Joystick(0);
	
	// Creating buttons
	Button motorForward = new JoystickButton(joystick, 6);
 
	public OI() {
		// Mapping buttons to commands
		motorForward.whenPressed(new MotorForward());
		motorForward.whenReleased(new MotorStop());
	}
	
	// Creating a method that returns joystick values for driving
	public Joystick getJoystick() {
		return joystick;
	}
}