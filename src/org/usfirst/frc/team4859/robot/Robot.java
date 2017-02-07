 package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.AutoRightGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoStraightForwardGear;
import org.usfirst.frc.team4859.robot.autonomous.AutoTest;
import org.usfirst.frc.team4859.robot.autonomous.AutoTest2;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	// Creating subsystems
	public static Chassis chassis;
	public static Climber climber;
	public static Preferences prefs;
	public static AHRS ahrs;
	public static OI oi;
	
	//lots of dumb variable creation that could probably be automated
	public static double speed1;
	public static double time1;
	public static double speed2;
	public static double time2;
	public static double speed3;
	public static double time3;
	public static double speed4;
	public static double time4;
	public static double speed5;
	public static double time5;
	public static double speed6;
	public static double time6;
	public static double speed7;
	public static double time7;
	public static double speed8;
	public static double time8;
	public static double speed9;
	public static double time9;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initializing subsystems (and ahrs)
    	climber = new Climber();
    	chassis = new Chassis();
    	prefs = Preferences.getInstance();
    	ahrs = new AHRS(SerialPort.Port.kUSB1);
		oi = new OI();
		
		ahrs.reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	ahrs.reset();
    	
		//lots of dumb variable creation that could probably be automated
    	time1 = Robot.prefs.getDouble("time1", 0);
    	speed1 = Robot.prefs.getDouble("speed1", 0);
    	time2 = Robot.prefs.getDouble("time2", 0);
    	speed2 = Robot.prefs.getDouble("speed2", 0);
    	time3 = Robot.prefs.getDouble("time3", 0);
    	speed3 = Robot.prefs.getDouble("speed3", 0);
    	time4 = Robot.prefs.getDouble("time4", 0);
    	speed4 = Robot.prefs.getDouble("speed4", 0);
    	time5 = Robot.prefs.getDouble("time5", 0);
    	speed5 = Robot.prefs.getDouble("speed5", 0);
    	time6 = Robot.prefs.getDouble("time6", 0);
    	speed6 = Robot.prefs.getDouble("speed6", 0);
    	time7 = Robot.prefs.getDouble("time7", 0);
    	speed7 = Robot.prefs.getDouble("speed7", 0);
    	time8 = Robot.prefs.getDouble("time8", 0);
    	speed8 = Robot.prefs.getDouble("speed8", 0);
    	time9 = Robot.prefs.getDouble("time9", 0);
    	speed9 = Robot.prefs.getDouble("speed9", 0);
    	
		// Adding autonomous modes
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		autonomousChooser.addObject("Test", new AutoTest());
		autonomousChooser.addObject("Straight Forward", new AutoStraightForwardGear());
		autonomousChooser.addObject("Auto Left Gear", new AutoRightGear());
		autonomousChooser.addObject("Test2", new AutoTest2());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
    	
    	Chassis.motorChassisFrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisBackLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisFrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Chassis.motorChassisBackRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	
    	Chassis.motorChassisFrontLeft.configEncoderCodesPerRev(360);
    	Chassis.motorChassisBackLeft.configEncoderCodesPerRev(360);
    	Chassis.motorChassisFrontRight.configEncoderCodesPerRev(360);
    	Chassis.motorChassisBackRight.configEncoderCodesPerRev(360);
    	
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.Speed);
		Chassis.motorChassisFrontRight.changeControlMode(TalonControlMode.Speed);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.Speed);
		Chassis.motorChassisBackRight.changeControlMode(TalonControlMode.Speed);
		
		Chassis.motorChassisFrontLeft.enableControl();
		Chassis.motorChassisFrontRight.enableControl();
		Chassis.motorChassisBackLeft.enableControl();
		Chassis.motorChassisBackRight.enableControl();

    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("angle", ahrs.getYaw());
        
        // Putting the ahrs values on the Smart Dashboard
        SmartDashboard.putNumber("Yaw (turning)", ahrs.getYaw());

        SmartDashboard.putNumber("Velocity (X)", ahrs.getVelocityX()*3.28084);
        SmartDashboard.putNumber("Velocity (Y)", ahrs.getVelocityY()*3.28084);
        SmartDashboard.putNumber("Velocity (Z)", ahrs.getVelocityZ()*3.28084);
        
        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
        SmartDashboard.putNumber("FR", Chassis.motorChassisFrontRight.getSpeed());
        SmartDashboard.putNumber("BL", Chassis.motorChassisBackLeft.getSpeed());
        SmartDashboard.putNumber("BR", Chassis.motorChassisBackRight.getSpeed());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.

        if (autonomousCommand != null) autonomousCommand.cancel();
        
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisFrontRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackRight.changeControlMode(TalonControlMode.PercentVbus);
		
		Chassis.motorChassisFrontLeft.enableControl();
		Chassis.motorChassisFrontRight.enableControl();
		Chassis.motorChassisBackLeft.enableControl();
		Chassis.motorChassisBackRight.enableControl();
		
		ahrs.reset();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("angle", ahrs.getYaw());
        
        // Putting the ahrs values on the Smart Dashboard
        SmartDashboard.putNumber("Yaw (turning)", ahrs.getYaw());

        SmartDashboard.putNumber("Velocity (X)", ahrs.getVelocityX()*3.28084);
        SmartDashboard.putNumber("Velocity (Y)", ahrs.getVelocityY()*3.28084);
        SmartDashboard.putNumber("Velocity (Z)", ahrs.getVelocityZ()*3.28084);
        
        SmartDashboard.putNumber("FL", Chassis.motorChassisFrontLeft.getSpeed());
        SmartDashboard.putNumber("FR", Chassis.motorChassisFrontRight.getSpeed());
        SmartDashboard.putNumber("BL", Chassis.motorChassisBackLeft.getSpeed());
        SmartDashboard.putNumber("BR", Chassis.motorChassisBackRight.getSpeed());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}