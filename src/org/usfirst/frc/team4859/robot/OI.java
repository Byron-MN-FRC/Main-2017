package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {	
	private final Joystick joystick = new Joystick(0);
	
	Button precisionMode = new JoystickButton(joystick, 7);
	Button flipMode = new JoystickButton(joystick, 2);
	
	Button climbUp = new JoystickButton(joystick, 12);
	
	Button pneumaticLock = new JoystickButton(joystick, 4);
	Button pneumaticUnlock = new JoystickButton(joystick, 1);
	Button pneumaticAutoGearRelease = new JoystickButton(joystick, 6);
	
	Button pneumaticLiftUp = new JoystickButton(joystick, 5);
	Button pneumaticLiftDown = new JoystickButton(joystick, 3);
 
	public OI() {
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
		
		pneumaticAutoGearRelease.whenPressed(new AutoGearRelease());
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}