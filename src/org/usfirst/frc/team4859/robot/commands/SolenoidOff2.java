package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidOff2 extends Command {

    public SolenoidOff2() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.solenoidOff2();
    }

    protected void execute() {
    	Robot.pneumatics.solenoidOff2();
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