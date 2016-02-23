package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterBall extends CommandGroup{
	
	public CenterBall() {
		
		addSequential(new FlywheelFeedOutTime(-1,1));
		addSequential(new FlywheelFeedOutTime(1,1));
	
	}
	
}
