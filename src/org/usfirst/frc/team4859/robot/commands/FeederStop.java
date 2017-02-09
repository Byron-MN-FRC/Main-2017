package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FeederStop extends Command {

    public FeederStop() {
        requires(Robot.feeder);
    }

    protected void initialize() {
    	Robot.feeder.feederStop();
    }

    protected void execute() {
    	Robot.feeder.feederStop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.feeder.feederStop();
    }

    protected void interrupted() {
    	Robot.feeder.feederStop();
    }
}