package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftGearAndShoot extends CommandGroup {
	
    public  AutoLeftGearAndShoot() {
    	addSequential(new DriveStraightGyro(0.25, 2.15));
    	addSequential(new DriveStop(0.1));
    	addParallel(new FlywheelSpinUp(1, 8));
    	addSequential(new TurnToAngle(29.83, 4));
    	addParallel(new DriveStop(0));
    	addSequential(new FeederForwardTime(1, 4));
    	addSequential(new TurnToAngle(30.17, 4));
    	addSequential(new DriveStraightGyro(0.25, 1.75));
    }
}