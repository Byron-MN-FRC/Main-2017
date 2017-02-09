package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelForward extends Command {

    public FlywheelForward() {
        requires(Robot.flywheels);
    }

    protected void initialize() {
    	Robot.flywheels.flywheelForward();
    }

    protected void execute() {
    	Robot.flywheels.flywheelForward();
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