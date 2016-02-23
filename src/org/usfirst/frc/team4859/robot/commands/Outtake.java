package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.FlywheelFeedOutTime;
import org.usfirst.frc.team4859.robot.autonomous.FlywheelForwardTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Outtake extends CommandGroup {
	
    public  Outtake() {
        addSequential(new FlywheelForwardTime(2));
        addParallel(new FlywheelForwardTime(2));
        addSequential(new FlywheelFeedOutTime(1, 2));
        addParallel(new FlywheelStop());
        addSequential(new FeedStop());
    }
}  