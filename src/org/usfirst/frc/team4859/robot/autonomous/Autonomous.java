package org.usfirst.frc.team4859.robot.autonomous;

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
    	
    	//double timel = NetworkTable.getTable("SmartDashboard").getNumber("timel");
    	addSequential(new DriveStop(0));
    	//addSequential(new DriveStraight(.5, timel));
    	addSequential(new DriveStop(2));
    	addSequential(new DriveStraight(-.5, 1));
    	addSequential(new DriveStop(0));
    }
}