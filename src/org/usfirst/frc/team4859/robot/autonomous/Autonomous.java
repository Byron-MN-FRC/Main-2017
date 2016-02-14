package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
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
    	
    	//addSequential(new DriveStop(0));
    	//addSequential(new DriveStop(2));
    	//addSequential(new DriveStraight(-.5, 1));
    	//addSequential(new DriveStop(0));
    	addSequential(new PivotAngleDown());
    	addSequential(new DriveStraight(-0.5,3));
    	addSequential(new DriveStop(0.5));
    	addSequential(new DriveRightCenter(0.5,1));
    	addSequential(new DriveStop(0.5));
    	addSequential(new DriveStraight(-0.5,2));
    	addSequential(new DriveStop(0.5));
    	addSequential(new Outtake());
    }
}