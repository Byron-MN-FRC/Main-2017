package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
    		if(bacon<-50 || bacon>50){
    		poop = speed;
    		speedBig = poop-(bacon/1200);
    		Robot.chassis.driveLeft(speedBig);
    		Robot.chassis.driveRight(poop);
    	}if(-50<=bacon && 50>=bacon){
    		poop2 = speed/10;
    		speedLittle = poop2-(bacon/10000);
    		Robot.chassis.driveLeft(speedLittle);
    		Robot.chassis.driveRight(poop2);
    	}
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
