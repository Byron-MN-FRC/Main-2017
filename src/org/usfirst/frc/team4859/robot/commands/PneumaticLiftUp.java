package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticLiftUp extends Command {

    public PneumaticLiftUp() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.pneumaticLiftUp();
    }

    protected void execute() {
    	Robot.pneumatics.pneumaticLiftUp();
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