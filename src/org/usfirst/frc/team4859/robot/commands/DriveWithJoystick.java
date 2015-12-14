package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command
{

	public DriveWithJoystick()
	{
		requires(Robot.chassis);
	}
	
	protected void initialize(){}
	
	protected void execute()
	{
		Robot.chassis.driveWithJoystick(Robot.oi.getJoystick());
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		//Robot.chassis.driveWithJoystick(0,0);
	}
	
	protected void interrupted()
	{
	}	
}
