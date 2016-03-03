package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SlowAndGun extends CommandGroup {
    
    public  SlowAndGun() {
    	addParallel(new PivotUp());
    	addSequential(new DriveStraightGyro(0.3, 3));
    	addSequential(new DriveStraight(1, 1.5));
    }
}