package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveStraightGyro;
import org.usfirst.frc.team4859.robot.autonomous.PivotUpTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAuto extends CommandGroup {

	public PortcullisAuto() {
		addSequential(new DriveStraightGyro(0.4, 5));
		//addParallel(new PivotUpTime(5));
		//addSequential(new DriveStraightGyro(1, 1.5));
		addSequential(new PivotDown());
	}
}