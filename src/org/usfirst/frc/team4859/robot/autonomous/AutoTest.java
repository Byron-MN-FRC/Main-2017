package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest extends CommandGroup {
	
    public  AutoTest() {
    	addSequential(new DriveStraight(500, 20));
    	addSequential(new DriveStop(0));
    }
}