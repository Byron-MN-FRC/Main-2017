package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotUpTime extends Command {
	
	private double time;
	
    public PivotUpTime(double time) {
    	requires(Robot.pivot);
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		setTimeout(time);
    	Pivot.mult = 0;
    	Robot.pivot.AngleStop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pivot.AngleUp();
    	
    	if (Robot.pivot.LimitSwitchUp())
    		Robot.pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pivot.AngleStop();
    	//Robot.pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
       	Robot.pivot.AngleStop();
    }
}