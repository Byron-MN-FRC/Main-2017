package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCircleTurn extends CommandGroup {
	
    public  AutoCircleTurn() {
    	addSequential(new CircleTurn(0.2, 1.1057, 20));
    	//addSequential(new CircleTurn(0.4, 1.1057, 2));
    	//addSequential(new CircleTurn(0.25, 1.1057, 0.5));
    	addSequential(new DriveStop(1));
    }
}