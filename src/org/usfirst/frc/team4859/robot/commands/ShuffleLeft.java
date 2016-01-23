package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveBackwards;
import org.usfirst.frc.team4859.robot.autonomous.DriveLeftCenter;
import org.usfirst.frc.team4859.robot.autonomous.DriveLeftForwards;
import org.usfirst.frc.team4859.robot.autonomous.DriveRightBackwards;
import org.usfirst.frc.team4859.robot.autonomous.DriveStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShuffleLeft extends CommandGroup {
	
    public  ShuffleLeft() {
    	
        addSequential(new DriveRightBackwards(0.5,1));
        addSequential(new DriveLeftCenter(0.5,1));
    	addSequential(new DriveStop(0));
    }
}  