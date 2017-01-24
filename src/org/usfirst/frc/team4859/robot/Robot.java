package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Climber;

import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
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
	public static AHRS ahrs;
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initializing subsystems (and gyro)
    	climber = new Climber ();
    	chassis = new Chassis();
    	ahrs = new AHRS(I2C.Port.kMXP);
		oi = new OI();
		
		ahrs.reset();
		
		// Adding autonomous modes
		autonomousChooser = new SendableChooser<CommandGroup>();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
//		autonomousChooser.addObject("Straight (Shooter Down)", new Autonomous());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // Instantiate the command used for the autonomous period
//        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		Chassis.motorChassisFrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisFrontRight.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackLeft.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motorChassisBackRight.changeControlMode(TalonControlMode.PercentVbus);

    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    	
    	ahrs.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        // Putting the gyro values on the Smart Dashboard
        SmartDashboard.putNumber("Yaw (turning)", ahrs.getYaw());

        SmartDashboard.putNumber("Velocity (X)", ahrs.getVelocityX()*3.28084);
        SmartDashboard.putNumber("Velocity (Y)", ahrs.getVelocityY()*3.28084);
        SmartDashboard.putNumber("Velocity (Z)", ahrs.getVelocityZ()*3.28084);
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
        
        // Putting the gyro values on the Smart Dashboard
        SmartDashboard.putNumber("Yaw (turning)", ahrs.getYaw());

        SmartDashboard.putNumber("Velocity (X)", ahrs.getVelocityX()*3.28084);
        SmartDashboard.putNumber("Velocity (Y)", ahrs.getVelocityY()*3.28084);
        SmartDashboard.putNumber("Velocity (Z)", ahrs.getVelocityZ()*3.28084);
        
        SmartDashboard.putNumber("", chassis.motorChassisFrontLeft.);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}