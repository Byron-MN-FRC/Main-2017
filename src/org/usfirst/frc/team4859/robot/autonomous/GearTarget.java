package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearTarget extends Command {
private double time;
private double speed;
private double poop = 0;
private double poop2 = 0;
private double speedBig = 0;
private double speedLittle = 0;
private double bacon = 0;
    public GearTarget(double inputSpeed, double inputTime) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	time = inputTime;
    	speed = inputSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	bacon = Robot.power;
		poop = speed;
		speedBig = poop+(bacon/600);
		if(speedBig>.2) {
			speedBig = .2;
		}if(speedBig<.1) {
			speedBig = .1;
		}
		SmartDashboard.putNumber("power val", speedBig);
		Robot.chassis.driveLeft(speedBig);
		Robot.chassis.driveRight(poop);
    		}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
