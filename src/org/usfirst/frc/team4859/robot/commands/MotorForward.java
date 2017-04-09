package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MotorForward extends Command {

    public MotorForward() {
        requires(Robot.motorss);
    }

    protected void initialize() {
    	Robot.motorss.motorForward();
    }

    protected void execute() {
    	Robot.motorss.motorForward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.motorss.motorStop();
    }

    protected void interrupted() {
    	Robot.motorss.motorStop();
    }
}