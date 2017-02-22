package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightGearCurve extends CommandGroup {
	
    public  AutoRightGearCurve() {
    	addSequential(new CircleTurnLeft(0.3, 1.575, 3));
    	addSequential(new DriveStop(1));
    }
}