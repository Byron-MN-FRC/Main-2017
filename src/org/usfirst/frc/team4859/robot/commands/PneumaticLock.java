package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLock extends Command {

    public PneumaticLock() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLock();
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLock();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.pneumaticStop();
    }

    protected void interrupted() {
    	Robot.pneumatics.pneumaticStop();
    }
}