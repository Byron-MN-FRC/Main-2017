package org.usfirst.frc.team4859.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGearRelease extends CommandGroup {

    public AutoGearRelease() {  	
    	addSequential(new PneumaticUnlock(0.2));
    	addSequential(new PneumaticRelease(0.5));
    	addSequential(new PneumaticRetract(0.5));
    }
}