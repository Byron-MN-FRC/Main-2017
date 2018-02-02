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
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}