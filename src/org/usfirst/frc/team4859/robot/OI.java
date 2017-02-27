package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {	
	// Create a joysticks on port 0 and 1
	private final Joystick joystick = new Joystick(0);
	private final Joystick xbox = new Joystick(1);
	
	// Creating buttons
	Button precisionMode = new JoystickButton(joystick, 1);
	Button flipMode = new JoystickButton(joystick, 2);
	
	Button climbUp = new JoystickButton(joystick, 6);
//	Button climbDown = new JoystickButton(joystick, 4);
	
	Button flywheelForward = new JoystickButton(xbox, 1);
//	Button flywheelBackward = new JoystickButton(xbox, 2);
	
	Button feederForward = new JoystickButton(xbox, 3);
	Button feederBackward = new JoystickButton(xbox, 4);
 
	public OI() {
		// Mapping buttons to command
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flipMode.toggleWhenPressed(new FlipMode());
		
		climbUp.whenPressed(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
//		climbDown.whenPressed(new ClimbDown());
//		climbDown.whenReleased(new ClimbStop());
		
		flywheelForward.whenPressed(new FlywheelForward());
		flywheelForward.whenReleased(new FlywheelStop());
		
//		flywheelBackward.whenPressed(new FlywheelBackward());
//		flywheelBackward.whenReleased(new FlywheelStop());
		
		feederForward.whenPressed(new FeederForward());
		feederForward.whenReleased(new FeederStop());
		
		feederBackward.whenPressed(new FeederBackward());
		feederBackward.whenReleased(new FeederStop());
	}
	
	// Creating a method that returns joystick values for driving
	public Joystick getJoystick() {
		return joystick;
	}
}