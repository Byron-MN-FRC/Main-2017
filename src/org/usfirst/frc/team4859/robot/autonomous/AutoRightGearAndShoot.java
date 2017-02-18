package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightGearAndShoot extends CommandGroup {
	
    public  AutoRightGearAndShoot() {
    	addSequential(new DriveStraightGyro(0.25, 2.15));
    	addSequential(new DriveStop(0.1));
    	addSequential(new TurnToAngle(-37, 4));
    	addSequential(new DriveStop(0));
    	addSequential(new DriveStraightGyro(0.3, 1.75));
    }
}