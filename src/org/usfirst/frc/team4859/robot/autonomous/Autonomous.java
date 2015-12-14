package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
    
    public  Autonomous()
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveStopTime(0.5));
    	addParallel(new LiftUpTime(0.3));
    	addSequential(new DriveStraight(1.25));
    	addSequential(new LiftDownTime(0.25));
    	addParallel(new LiftUpTime(0.30));
    	addSequential(new DriveStraight(1.3));
    	addSequential(new LiftDownTime(0.2));
    	addParallel(new LiftUpTime(0.35));
    	addSequential(new DriveRight(0.50));
    	addSequential(new DriveStraight(1.5));
    	addParallel(new LiftDownTime(0.20));
    	addSequential(new DriveLeft(0.50));
    	addSequential(new DriveBackwards(0.5));
    	addSequential(new DriveStop());
    }
}
