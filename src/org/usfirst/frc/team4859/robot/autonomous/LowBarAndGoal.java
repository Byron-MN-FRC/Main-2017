package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.commands.PivotUp;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAndGoal extends CommandGroup {
	
    public  LowBarAndGoal() {
		Chassis.motorChassisRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisLeft.changeControlMode(TalonControlMode.PercentVbus);
		
    	addSequential(new DriveStop(0));
    	//addParallel(new PivotUp());
    	addSequential(new DriveStraightGyro(0.6, 3));
    	addSequential(new DriveToDistance(0.5, 72));
    	addSequential(new TurnToAngle(0.5, 60));
    	addSequential(new DriveStop(0));
    	Robot.gyro.reset();
    	addSequential(new DriveToDistance(0.5, 50));
    	//addSequential(new DriveStop(0));
    	//addSequential(new TurnToAngle(0.5, 60));
    }
}