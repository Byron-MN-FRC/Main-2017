package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbDown extends Command {

    public ClimbDown() {
        requires(Robot.climber);
    }

    protected void initialize() {
    	Robot.climber.climbDown();
    }

    protected void execute() {
    	Robot.climber.climbDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.climbStop();
    }

    protected void interrupted() {
    	Robot.climber.climbStop();
    }
}