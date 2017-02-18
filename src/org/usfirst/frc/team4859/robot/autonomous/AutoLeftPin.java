package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftPin extends CommandGroup {
	
    public  AutoLeftPin() {
    	addSequential(new CircleTurnRight(0.2, 1.1057, 4));
    	addSequential(new DriveStop(1));
    }
}