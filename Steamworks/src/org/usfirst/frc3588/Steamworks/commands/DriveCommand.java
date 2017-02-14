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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    Joystick currentJoystick;
    public static int  driveDirection;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	driveDirection = 1;
    	RobotMap.chassisRobotDrive.setMaxOutput(1.0);
    	currentJoystick = Robot.oi.joystick1;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {

    	if(currentJoystick.getPOV() == 270) {
    		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(driveDirection * 0.3, 0, 0, 0);
    	}
    	else if(currentJoystick.getPOV() == 180) {
    		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0, driveDirection * 0.3, 0, 0);
    	}
    	else if(currentJoystick.getPOV() == 90) {
    		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(-driveDirection * 0.3, 0, 0, 0);
    	}
    	else if(currentJoystick.getPOV() == 0) {
    		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0, -driveDirection * 0.3, 0, 0);
    	}    
    	else {
        	RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(-driveDirection * currentJoystick.getX(), driveDirection * currentJoystick.getY(), currentJoystick.getTwist()*.5, 0);
        	if (Robot.oi.joystick1.getThrottle() > 0) {
        		currentJoystick = Robot.oi.joystick2;
        	}
        	else {
        		currentJoystick = Robot.oi.joystick1;
        	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
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
