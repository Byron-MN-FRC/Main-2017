package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveStop;
import org.usfirst.frc.team4859.robot.autonomous.DriveStraight;
import org.usfirst.frc.team4859.robot.autonomous.DriveStraightGyro;
import org.usfirst.frc.team4859.robot.autonomous.PivotDownTime;
import org.usfirst.frc.team4859.robot.autonomous.PivotUpTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalDeFrise extends CommandGroup {

	public ChevalDeFrise() {
    	addParallel(new PivotUpTime(3.2));
    	addSequential(new DriveStraightGyro(0.5, 3.25));
    	addParallel(new DriveStop(0));
    	addSequential(new PivotDownTime(1.5));
    	addParallel(new PivotDownTime(2));
    	addSequential(new DriveStraightGyro(0.8, 2));
	}
}