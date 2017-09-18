package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftGearCurve extends CommandGroup {
	
    public  AutoLeftGearCurve() {
    	addSequential(new CircleTurnRight(0.3, 1.545, 3));
    	 /*	addSequential(new wiggl2(-0.3, .2));
    	addSequential(new wiggl2(0.3, .2));
    	addSequential(new wiggl1(-0.3, .2));
    	addSequential(new wiggl1(0.3, .2));
    	addSequential(new DriveStop(1));
   */ 
    	addSequential(new DriveStop(1));
    }
}