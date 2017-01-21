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
	
	Button precisionMode = new JoystickButton(joystickP0, 1);
	Button climbUp = new JoystickButton(joystickP0, 3);
	Button climbStop = new JoystickButton(joystickP0, 4);
	
	//Button flywheelForward = new JoystickButton(xboxP1, 5);
 
	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		climbUp.toggleWhenPressed(new ClimbUp());
		climbStop.whenPressed(new ClimbStop());
		
//		flywheelBackward.whenPressed(new FlywheelBackward());
//		flywheelBackward.whenReleased(new FlywheelStop());
		
//		flywheelFeedIn.whenPressed(new FlywheelFeedIn());
//		flywheelFeedIn.whenReleased(new FlywheelFeedStop());
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}