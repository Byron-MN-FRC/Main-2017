package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SlowAndGun2 extends CommandGroup {
    
    public  SlowAndGun2() {
    	addParallel(new PivotUp());
    	addSequential(new DriveStraightGyro(0.5, 3.5));
    	addSequential(new DriveStraight(1, 1.5));
    	
    	addSequential(new FlywheelForwardTime(2.5));
        addParallel(new FlywheelForwardTime(3));
        addSequential(new FlywheelFeedOutTime(3));
        
        addSequential(new TurnToAngle(180, 2));   
    }
}