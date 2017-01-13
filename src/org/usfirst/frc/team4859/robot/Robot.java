package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoNothing;
import org.usfirst.frc.team4859.robot.autonomous.Autonomous;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Create subsystems
	public static Chassis chassis;
	public static AHRS ahrs;
	public static OI oi;

	public static double start;
	
    Command autonomousCommand;
    SendableChooser autonomousChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initialize subsystems
    	chassis = new Chassis();
		oi = new OI();
		ahrs = new AHRS(SerialPort.Port.kUSB);
		
		// Add autonomous modes
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		autonomousChooser.addObject("Straight (Shooter Down)", new Autonomous());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // Instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		Chassis.motor1.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motor2.changeControlMode(TalonControlMode.PercentVbus);

//		gyro.reset();
    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//if (launcher.limitDown.get()) start = launcher.motorLauncherAngle.getPosition();
		
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.

        if (autonomousCommand != null) autonomousCommand.cancel();
        
		Chassis.motor1.changeControlMode(TalonControlMode.PercentVbus);
		Chassis.motor2.changeControlMode(TalonControlMode.PercentVbus);
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
         SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
         SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
         SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
         
         SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
         SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
         
         SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
         SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
         SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX()*39.370);
         SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY()*39.370);
         
         SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
         SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
         SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
         SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
         SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
         SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
         SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
         SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
         SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
         SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
         
         
    	
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}