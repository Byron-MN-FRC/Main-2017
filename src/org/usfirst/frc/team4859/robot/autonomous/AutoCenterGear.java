package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterGear extends CommandGroup {
	
    public  AutoCenterGear() {
    	addSequential(new DriveStraight(-0.3, 2.5));
    	 /*	addSequential(new wiggl2(-0.3, .2));
    	addSequential(new wiggl2(0.3, .2));
    	addSequential(new wiggl1(-0.3, .2));
    	addSequential(new wiggl1(0.3, .2));
    	addSequential(new DriveStop(1));
   */ 
    	addSequential(new DriveStop(1));
    }
}