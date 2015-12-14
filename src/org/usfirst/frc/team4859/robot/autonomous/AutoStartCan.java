package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStartCan extends CommandGroup {
    
    public  AutoStartCan()
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
    	System.out.println("AutoStartCan");
    	addSequential(new AutoServo90(1));
    	//Speed needs to be NEGATIVE
    	addSequential(new DriveStraight(2, -.7));
    	addSequential(new AutoServo0(1));
    	addSequential(new LiftUpTime(0.75));
    	addSequential(new DriveStop());
    }
}
