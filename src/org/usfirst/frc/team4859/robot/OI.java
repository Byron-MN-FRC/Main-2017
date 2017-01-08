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
	
	Button precisionMode = new JoystickButton(joystickP0, 12);
	
	Button flywheelForward = new JoystickButton(xboxP1, 5);
	
	Button flywheelForwardSlow = new JoystickButton(xboxP1, 8);

	//Button flywheelBackward = new JoystickButton(xboxP1, 8);
	
	//Button flywheelFeedIn = new JoystickButton(xboxP1, 3);
	Button flywheelFeedOut = new JoystickButton(xboxP1, 6);
	
	Button angleUp = new JoystickButton(xboxP1, 3);
	Button angleDown = new JoystickButton(xboxP1, 1);
	
	Button angleShoot = new JoystickButton(xboxP1, 4);
	
	Button angleFlat = new JoystickButton(xboxP1, 2);
	
	Button intake = new JoystickButton(joystickP0, 1);
	
	Button intakePower = new JoystickButton(xboxP1, 7);
	
	Button portcullis = new JoystickButton(joystickP0, 8);
	
	//Button outtake = new JoystickButton(xboxP1, 6);
	
	//Button center = new JoystickButton(xboxP1, 3);
 
	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
//		flywheelBackward.whenPressed(new FlywheelBackward());
//		flywheelBackward.whenReleased(new FlywheelStop());
		
//		flywheelFeedIn.whenPressed(new FlywheelFeedIn());
//		flywheelFeedIn.whenReleased(new FlywheelFeedStop());
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}