package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidBackward2 extends Command {

    public SolenoidBackward2() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.solenoidBackward2();
    }

    protected void execute() {
    	Robot.pneumatics.solenoidBackward2();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.solenoidOff2();
    }

    protected void interrupted() {
    	Robot.pneumatics.solenoidOff2();
    }
}