package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest2 extends CommandGroup {
	
    public  AutoTest2() {
    	addSequential(new CircleTurn(0.25, 1.106, 0.5));
    	addSequential(new CircleTurn(0.4, 1.125, 2));
    	addSequential(new CircleTurn(0.25, 1.106, 0.5));
    	addSequential(new DriveStop(1));
    }
}