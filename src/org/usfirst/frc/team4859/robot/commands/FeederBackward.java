package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FeederBackward extends Command {

    public FeederBackward() {
        requires(Robot.feeder);
    }

    protected void initialize() {
    	Robot.feeder.feederBackward();
    }

    protected void execute() {
    	Robot.feeder.feederBackward();
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
