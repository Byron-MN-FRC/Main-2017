package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidForward2 extends Command {

    public SolenoidForward2() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.solenoidForward2();
    }

    protected void execute() {
    	Robot.pneumatics.solenoidForward2();
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