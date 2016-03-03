package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.commands.PivotDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAuto extends CommandGroup {

	public PortcullisAuto() {
		addParallel(new PivotDown());
		addSequential(new DriveStraightGyro(0.4, 5));
		//addParallel(new PivotUpTime(5));
		//addSequential(new DriveStraightGyro(1, 1.5));
		addSequential(new PivotDown());
	}
}