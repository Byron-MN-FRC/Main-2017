package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {	
	// Create a joysticks on port 0 and 1
	private final Joystick joystick = new Joystick(0);
	
	// Creating buttons
	Button motorForward = new JoystickButton(joystick, 5);
	Button motorBackward = new JoystickButton(joystick, 3);
	
	Button solenoidForward1 = new JoystickButton(joystick, 9);
	Button solenoidBackward1 = new JoystickButton(joystick, 10);
	
	Button solenoidForward2 = new JoystickButton(joystick, 11);
	Button solenoidBackward2 = new JoystickButton(joystick, 12);
 
	public OI() {
		// Mapping buttons to commands
		motorForward.whenPressed(new MotorForward());
		motorForward.whenReleased(new MotorStop());
		
		motorBackward.whenPressed(new MotorBackward());
		motorBackward.whenReleased(new MotorStop());
		
		solenoidForward1.whenPressed(new SolenoidForward1());
		solenoidForward1.whenReleased(new SolenoidOff1());
		
		solenoidBackward1.whenPressed(new SolenoidBackward1());
		solenoidBackward1.whenReleased(new SolenoidOff1());
		
		solenoidForward2.whenPressed(new SolenoidForward2());
		solenoidForward2.whenReleased(new SolenoidOff2());
		
		solenoidBackward2.whenPressed(new SolenoidBackward2());
		solenoidBackward2.whenReleased(new SolenoidOff2());
	}
}