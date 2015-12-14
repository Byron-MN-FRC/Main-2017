package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
//the lift up commands
import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command
{
	public LiftUp()
	{
		requires(Robot.lifter);
	}
	
	
	protected void initialize() {
		Robot.lifter.liftUp();
	}

	
	protected void execute() {
		Robot.lifter.liftUp();
		
	}

	
	protected boolean isFinished() {
		return false;
	}

	
	protected void end()
	{
		Robot.lifter.liftStop();
	}

	
	protected void interrupted() {
		
	}	
}
