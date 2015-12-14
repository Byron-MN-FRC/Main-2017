package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class PrecisionMode extends Command
{
	protected void initialize()
	{
		RobotMap.pMode = true;
	}
	
	protected void execute(){}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		RobotMap.pMode = false;
	}
	
	protected void interrupted()
	{
		end();
	}
	
}
