package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest extends CommandGroup {
	
    public  AutoTest() {
    	addSequential(new DriveStraight(0.2, 2.5));
    	addSequential(new DriveStop(1));
    	addSequential(new StrafeLeft(0.2, 2));
    	addSequential(new DriveStop(1));
    	addSequential(new DriveBackwards(0.2, 2.5));
    	addSequential(new DriveStop(1));
    	addSequential(new StrafeRight(0.2, 2.5));
    }
}