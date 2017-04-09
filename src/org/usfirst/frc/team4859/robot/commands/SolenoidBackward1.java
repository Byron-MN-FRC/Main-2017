package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidBackward1 extends Command {

    public SolenoidBackward1() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {
    	Robot.pneumatics.solenoidBackward1();
    }

    protected void execute() {
    	Robot.pneumatics.solenoidBackward1();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.solenoidOff1();
    }

    protected void interrupted() {
    	Robot.pneumatics.solenoidOff1();
    }
}