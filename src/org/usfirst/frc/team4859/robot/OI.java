package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {	
	// Create a joysticks on port 0 and 1
	private final Joystick joystick = new Joystick(0);
	//private final Joystick xbox = new Joystick(1);
	
	// Creating buttons
	Button precisionMode = new JoystickButton(joystick, 7);
	Button flipMode = new JoystickButton(joystick, 2);
	
	Button climbUp = new JoystickButton(joystick, 12);
	
	Button pneumaticLock = new JoystickButton(joystick, 4);
	Button pneumaticUnlock = new JoystickButton(joystick, 1);
	
	Button pneumaticGearRelease = new JoystickButton(joystick, 6);
	
	Button pneumaticLiftDown = new JoystickButton(joystick, 3);
	Button pneumaticLiftUp = new JoystickButton(joystick, 5);
 
	public OI() {
		// Mapping buttons to command
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flipMode.toggleWhenPressed(new FlipMode());
		
		climbUp.whenPressed(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
		// All commands are called with "0" to pass the timeout check so they run normally
		pneumaticLock.whenPressed(new PneumaticLock(0));
		pneumaticLock.whenReleased(new PneumaticStop(0));
		
		pneumaticUnlock.whenPressed(new PneumaticUnlock(0));
		pneumaticUnlock.whenReleased(new PneumaticStop(0));
		
		pneumaticLiftDown.whenPressed(new PneumaticLiftDown(0));
		pneumaticLiftDown.whenReleased(new PneumaticLiftStop(0));
		
		pneumaticLiftUp.whenPressed(new PneumaticLiftUp(0));
		pneumaticLiftUp.whenReleased(new PneumaticLiftStop(0));
		
		pneumaticGearRelease.whenPressed(new AutoGearRelease());
	}
	
	// Creating a method that returns joystick values for driving
	public Joystick getJoystick() {
		return joystick;
	}
}