package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbUp extends Command {

    public ClimbUp() {
        requires(Robot.climber);
    }

    protected void initialize() {
    	Robot.climber.climbUp();
    	Robot.compressor.stop();
    }

    protected void execute() {
    	Robot.climber.climbUp();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.climbStop();
    	Robot.compressor.start();
    }

    protected void interrupted() {
    	Robot.climber.climbStop();
    	Robot.compressor.start();
    }
}