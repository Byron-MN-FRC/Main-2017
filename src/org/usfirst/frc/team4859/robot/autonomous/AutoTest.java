package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest extends CommandGroup {
	
    public  AutoTest() {
    	addSequential(new DriveStraight(Robot.speed1, Robot.time1));
    	addSequential(new DriveStop(0.5));
    	addSequential(new StrafeLeft(Robot.speed2, Robot.time2));
    	addSequential(new DriveStop(0.5));
    	addSequential(new DriveBackwards(Robot.speed3, Robot.time3));
    	addSequential(new DriveStop(0.5));
    	addSequential(new StrafeRight(Robot.speed4, Robot.time4));
    }
}