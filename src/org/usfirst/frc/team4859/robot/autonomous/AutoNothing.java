package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNothing extends CommandGroup {
	
    public  AutoNothing() {
    	addSequential(new DriveStop(0));
    }
}