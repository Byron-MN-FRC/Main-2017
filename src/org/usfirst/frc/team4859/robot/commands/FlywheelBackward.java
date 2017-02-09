package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelBackward extends Command {

    public FlywheelBackward() {
        requires(Robot.flywheels);
    }

    protected void initialize() {
    	Robot.flywheels.flywheelBackward();
    }

    protected void execute() {
    	Robot.flywheels.flywheelBackward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.flywheels.flywheelStop();
    }

    protected void interrupted() {
    	Robot.flywheels.flywheelStop();
    }
}