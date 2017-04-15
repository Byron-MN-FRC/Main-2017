package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MotorForward extends Command {

    public MotorForward() {
        requires(Robot.motors);
    }

    protected void initialize() {
    	Robot.motors.motorForward();
    }

    protected void execute() {
    	Robot.motors.motorForward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.motors.motorStop();
    }

    protected void interrupted() {
    	Robot.motors.motorStop();
    }
}