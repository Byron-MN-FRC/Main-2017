package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveStraightGyro;
import org.usfirst.frc.team4859.robot.autonomous.PivotDownTime;
import org.usfirst.frc.team4859.robot.autonomous.PivotUpTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChevalDeFrise extends CommandGroup {

	public ChevalDeFrise() {
		addParallel(new PivotUpTime(2));
		addSequential(new DriveStraightGyro(0.4, 2));
		addSequential(new PivotDownTime(1));
		addSequential(new DriveStraightGyro(1, 1));
	}
}