package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveLeftCenter;
import org.usfirst.frc.team4859.robot.autonomous.DriveRightBackwards;
import org.usfirst.frc.team4859.robot.autonomous.DriveStop;
import org.usfirst.frc.team4859.robot.autonomous.DriveStraight;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShuffleLeft extends CommandGroup {
	
    public  ShuffleLeft() {
    	
        addSequential(new DriveRightBackwards(0.7,.75));
        addSequential(new DriveLeftCenter(0.7,.3));
        addSequential(new DriveStraight(0.7,0.386));
    	
//    	addSequential(new DriveRightBackwards(0.5,0.1));
//    	addSequential(new DriveRightBackwards(1,.25));
//    	addSequential(new DriveStop(.1));
//    	addSequential(new DriveLeftCenter(.5, 0.22));
//      addSequential(new DriveLeftCenter(1,.01));
//      addSequential(new DriveStraight(1,0.21));
    	addSequential(new DriveStop(0));
    }
}  