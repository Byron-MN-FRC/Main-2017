//package org.usfirst.frc.team4859.robot.autonomous;
//
//import org.usfirst.frc.team4859.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
//public class AutoTest extends CommandGroup {
//	
//    public  AutoTest() {
//    	addSequential(new DriveStraightGyro(Robot.speed1, Robot.time1));
//    	addSequential(new DriveStop(0.1));
//    	addSequential(new TurnToAngle(Robot.speed2, Robot.time2));
//    	addSequential(new DriveStop(0));
//    	addSequential(new DriveStraightGyro(Robot.speed3, Robot.time3));
////    	addSequential(new DriveStop(0.5));
////    	addSequential(new StrafeRight(Robot.speed4, Robot.time4));
//    }
//}