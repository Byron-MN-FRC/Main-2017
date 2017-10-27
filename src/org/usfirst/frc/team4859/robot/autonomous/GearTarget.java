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
    public GearTarget(double inputSpeedOrigin, double inputTime, double inputStraightSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	time = inputTime;
    	poop2 = inputSpeedOrigin;
    	speed = inputStraightSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		speedBig = poop2+(Robot.power/300);
		speedLittle = poop2-(Robot.power/600);
		if(speedBig>.5) {
			speedBig = .5;
		}if(speedBig<-.5) {
			speedBig = -.5;
		}if(speedLittle>.5) {
			speedLittle = .5;
		}if(speedLittle<-.5) {
			speedLittle = -.5;
		}
		SmartDashboard.putNumber("power val", speedBig);
		if(Robot.power <=10 && Robot.power >= 10) {
		speedBig = speed;
		speedLittle = speed;
		SmartDashboard.putBoolean("yeet1", true);
		}else{
			SmartDashboard.putBoolean("yeet1", false);
		}
		Robot.chassis.driveLeft(speedBig/2.0);
		Robot.chassis.driveRight(speedLittle/2.0);
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
