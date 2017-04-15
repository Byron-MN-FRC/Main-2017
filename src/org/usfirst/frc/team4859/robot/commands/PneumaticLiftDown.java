package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftDown extends Command {

    public PneumaticLiftDown() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLiftDown();
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLiftDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.pneumaticLiftStop();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticLiftStop();
    }
}