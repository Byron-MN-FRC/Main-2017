package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.autonomous.Wiggle;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGearGrab extends CommandGroup {

    public AutoGearGrab() {  	
    	requires(Robot.chassis);
    	requires(Robot.pneumatics);
    	
    	addSequential(new PneumaticUnlock(0.2));
    	addSequential(new PneumaticLiftDown(1));
    	addSequential(new Wiggle(0.25, 0.15, 0.2));
    	addSequential(new Wiggle(0.25, -0.15, 0.2));
    	addSequential(new Wiggle(0.25, 0.15, 0.2));
    	addSequential(new Wiggle(0.25, -0.15, 0.2));
    	addSequential(new PneumaticLock(0.2));
    	addSequential(new PneumaticLiftUp(1));
    }
}