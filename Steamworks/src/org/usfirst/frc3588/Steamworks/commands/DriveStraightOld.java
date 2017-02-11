// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3588.Steamworks.commands;
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightOld extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_driveTime;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    
    static private double Kp= 2.0;
	static private double xAxis = 0.0;
	static private double yAxis = -0.5;
	static private double stop = 0.0;
	static private double twist = 0.0;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveStraightOld(double driveTime) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_driveTime = driveTime;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(driveTime);
        System.out.println("Done with Drive Straight");        
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	//RobotMap.chassisGyro.reset();
    	RobotMap.chassisRobotDrive.setMaxOutput(0.5);
    	System.out.println("Drive Straight Initialize");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	//double angle = RobotMap.chassisGyro.getAngle();
    	//System.out.println(angle);
    	RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(xAxis, yAxis, twist, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
    	if (isTimedOut()) {
    		return true;
    	}
    	else {
            return false;
    	}
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}
