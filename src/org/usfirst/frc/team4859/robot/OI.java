package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.LiftDown;
import org.usfirst.frc.team4859.robot.commands.LiftDownFast;
import org.usfirst.frc.team4859.robot.commands.LiftStop;
import org.usfirst.frc.team4859.robot.commands.LiftUp;
import org.usfirst.frc.team4859.robot.commands.LiftUpFast;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
import org.usfirst.frc.team4859.robot.commands.Servo0;
import org.usfirst.frc.team4859.robot.commands.Servo90;

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

	// Create a xbox controller on port 1
	private final Joystick xboxP1 = new Joystick(1);
	
	// Create button for precision mode for joystick button 12
	Button precisionMode = new JoystickButton(joystickP0, 12);

	// Create liftUp button on xboxP1 for button 1
	Button liftUp = new JoystickButton(xboxP1, 1);

	// Create liftDown button on xboxP1 for button 2
	Button liftDown = new JoystickButton(xboxP1, 2);
	
	// Create liftDownFast button on xboxP1 for button 3
	Button liftDownFast = new JoystickButton(xboxP1, 3);

	// Create liftUpFast button on xboxP1 for button 4
	Button liftUpFast = new JoystickButton(xboxP1, 4);
	
	Button servo0 = new JoystickButton(joystickP0, 8);

	Button servo90 = new JoystickButton(joystickP0, 7);

	public OI()
	{
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		liftUp.whenPressed(new LiftUp());
		liftUp.whenReleased(new LiftStop());
		
		liftDown.whenPressed(new LiftDown());
		liftDown.whenReleased(new LiftStop());
		
		liftUpFast.whenPressed(new LiftUpFast());
		liftUpFast.whenReleased(new LiftStop());
		
		liftDownFast.whenPressed(new LiftDownFast());
		liftDownFast.whenReleased(new LiftStop());
		
		servo0.whileHeld(new Servo0());

		servo90.whileHeld(new Servo90());
	}
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

