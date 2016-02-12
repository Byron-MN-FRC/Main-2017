package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.FlywheelFeedOutTime;
import org.usfirst.frc.team4859.robot.autonomous.FlywheelSpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Outtake extends CommandGroup {
	
    public  Outtake() {
    	
        addSequential(new FlywheelSpinUp(1, 2));
        addParallel(new FlywheelSpinUp(1, 2));
        addParallel(new FlywheelFeedOutTime(1, 2));
        addSequential(new FlywheelStop());
    }
}  