package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.FlywheelBackward;
import org.usfirst.frc.team4859.robot.commands.FlywheelFeedIn;
import org.usfirst.frc.team4859.robot.commands.FlywheelFeedOut;
import org.usfirst.frc.team4859.robot.commands.FlywheelFeedStop;
import org.usfirst.frc.team4859.robot.commands.FlywheelForward;
import org.usfirst.frc.team4859.robot.commands.FlywheelForwardSpin;
import org.usfirst.frc.team4859.robot.commands.FlywheelStop;
import org.usfirst.frc.team4859.robot.commands.LauncherAngleDown;
import org.usfirst.frc.team4859.robot.commands.LauncherAngleStop;
import org.usfirst.frc.team4859.robot.commands.LauncherAngleUp;
import org.usfirst.frc.team4859.robot.commands.Outtake;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
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
	// Create button for precision mode for joystick button 12
	Button precisionMode = new JoystickButton(joystickP0, 12);
	
	//Button shuffleLeft = new JoystickButton(joystickP0, 11);
	
	Button flywheelForward = new JoystickButton(xboxP1, 7);
	Button flywheelBackward = new JoystickButton(xboxP1, 5);
	Button ultimateShooter = new JoystickButton(xboxP1, 6);
	
	
	Button flywheelForwardSpin = new JoystickButton(joystickP0, 8);
	
	Button flywheelFeedIn = new JoystickButton(xboxP1, 3);
	Button flywheelFeedOut = new JoystickButton(xboxP1, 2);
	
	Button launcherAngleUp = new JoystickButton(xboxP1, 4);
	Button launcherAngleDown = new JoystickButton(xboxP1, 1);
 
	public OI() {
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		flywheelForward.whenPressed(new FlywheelForward());
		flywheelForward.whenReleased(new FlywheelStop());
		
		flywheelBackward.whenPressed(new FlywheelBackward());
		flywheelBackward.whenReleased(new FlywheelStop());
		
		flywheelForwardSpin.whenPressed(new FlywheelForwardSpin());
		flywheelForwardSpin.whenReleased(new FlywheelStop());
		
		flywheelFeedIn.whenPressed(new FlywheelFeedIn());
		flywheelFeedIn.whenReleased(new FlywheelFeedStop());
		
		flywheelFeedOut.whenPressed(new FlywheelFeedOut());
		flywheelFeedOut.whenReleased(new FlywheelFeedStop());
		ultimateShooter.whenPressed(new Outtake());
		ultimateShooter.whenReleased(new FlywheelStop());
		launcherAngleUp.toggleWhenPressed(new LauncherAngleUp());
		
		launcherAngleDown.toggleWhenPressed(new LauncherAngleDown());
		
		//shuffleLeft.whenPressed(new ShuffleRight());
		//shuffleLeft.whenReleased(new DriveStop(1));		
	}
	
	public Joystick getJoystick() {
		return joystickP0;
	}
}