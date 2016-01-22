package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
import org.usfirst.frc.team4859.robot.commands.SolenoidForward;
import org.usfirst.frc.team4859.robot.commands.SolenoidReverse;
import org.usfirst.frc.team4859.robot.commands.SolenoidStop;

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
	Button precisionMode = new JoystickButton(joystickP0, 12);
	Button solenoidForward = new JoystickButton(joystickP0, 5);
	Button solenoidReverse = new JoystickButton(joystickP0, 3);
	Button solenoidStop = new JoystickButton(joystickP0, 2);

	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		solenoidForward.whenPressed(new SolenoidForward());
		solenoidForward.whenReleased(new SolenoidStop());
		solenoidReverse.whenPressed(new SolenoidReverse());
		solenoidReverse.whenReleased(new SolenoidStop());
		solenoidStop.whileHeld(new SolenoidStop());
		
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}