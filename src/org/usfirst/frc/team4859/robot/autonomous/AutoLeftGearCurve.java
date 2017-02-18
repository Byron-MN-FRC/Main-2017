package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftGearCurve extends CommandGroup {
	
    public  AutoLeftGearCurve() {
    	addSequential(new CircleTurnRight(0.2, 1.1057, 4));
    	addSequential(new DriveStop(1));
    }
}