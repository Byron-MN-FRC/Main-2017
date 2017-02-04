package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStraightForwardGear extends CommandGroup {
	
    public  AutoStraightForwardGear() {
    	addSequential(new DriveStraight(0.1, 1.5));
    }
}