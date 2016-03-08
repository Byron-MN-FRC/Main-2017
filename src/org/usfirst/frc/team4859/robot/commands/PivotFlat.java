package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotFlat extends Command {
	
    public PivotFlat() {
    	requires(Robot.pivot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Pivot.mult = 0;
    	Robot.pivot.AngleStop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pivot.AngleFlat();
    	
    	if (Robot.pivot.LimitSwitchUp())
    		Robot.pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
    	
       	if (Robot.pivot.motorLauncherAngle.getOutputCurrent() >= 40) {
       		Robot.pivot.AngleStop();
       		Robot.pivot.motorLauncherAngle.setPosition(RobotMap.flatPosition);
       	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.pivot.LimitSwitchUp();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pivot.AngleStop();
    	Robot.pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
       	Robot.pivot.AngleStop();
    }
}