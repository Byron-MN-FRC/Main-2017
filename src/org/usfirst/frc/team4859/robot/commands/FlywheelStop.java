package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelStop extends Command {

    public FlywheelStop() {
        requires(Robot.flywheels);
    }

    protected void initialize() {
    	Robot.flywheels.flywheelStop();
    }

    protected void execute() {
    	Robot.flywheels.flywheelStop();
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