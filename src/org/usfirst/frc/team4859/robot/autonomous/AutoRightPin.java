package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightPin extends CommandGroup {
	
    public  AutoRightPin() {
    	addSequential(new CircleTurnLeft(0.2, 1.1057, 4));
    	addSequential(new DriveStop(1));
    }
}