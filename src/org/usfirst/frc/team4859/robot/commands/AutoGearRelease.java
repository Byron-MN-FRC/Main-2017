package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGearRelease extends CommandGroup {

    public AutoGearRelease() {  	
    	requires(Robot.pneumatics);
    	
    	addSequential(new PneumaticUnlock(0.1));
    	addSequential(new PneumaticRelease(0.5));
    	addSequential(new PneumaticRetract(0.5));
    }
}