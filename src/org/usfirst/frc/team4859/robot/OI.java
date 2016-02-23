package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.CenterBall;
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

	//Button flywheelBackward = new JoystickButton(xboxP1, 8);
	
	//Button flywheelFeedIn = new JoystickButton(xboxP1, 3);
	Button flywheelFeedOut = new JoystickButton(xboxP1, 6);
	
	Button launcherAngleUp = new JoystickButton(xboxP1, 4);
	Button launcherAngleDown = new JoystickButton(xboxP1, 1);
	Button flatAngle = new JoystickButton(xboxP1, 2);
	
	Button intake = new JoystickButton(joystickP0, 1);
	
	//Button outtake = new JoystickButton(xboxP1, 6);
	
	Button center = new JoystickButton(xboxP1, 3);
 
	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flywheelForward.whenPressed(new FlywheelForward());
		flywheelForward.whenReleased(new FlywheelStop());
		
//		flywheelBackward.whenPressed(new FlywheelBackward());
//		flywheelBackward.whenReleased(new FlywheelStop());
		
		intake.whenPressed(new Intake());
		intake.whenReleased(new IntakeStop());
		
//		outtake.whenPressed(new Outtake());
//		outtake.whenReleased(new FlywheelStop());
		
//		flywheelFeedIn.whenPressed(new FlywheelFeedIn());
//		flywheelFeedIn.whenReleased(new FlywheelFeedStop());
		
		flywheelFeedOut.whenPressed(new FeedOut());
		flywheelFeedOut.whenReleased(new FeedStop());
		
		launcherAngleUp.toggleWhenPressed(new PivotUp());
		
		launcherAngleDown.toggleWhenPressed(new PivotDown());
		
		flatAngle.toggleWhenPressed(new PivotFlat());
		
		center.whenPressed(new CenterBall());
		center.whenReleased(new FlywheelStop());
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}