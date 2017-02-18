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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

/**
 *
 */
public class RopeArmClose extends Command {
	private static final int HIGH_END = 0 + 10;
	private static final double RETRACT_SPEED = -1.0;
	private static final double OFF = 0.0;
	private static boolean done = false;

	private Encoder leftRopeEncoder;


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public RopeArmClose() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.climbing);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	leftRopeEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k1X);
    	RobotMap.climbingLeftSweeper.set(RETRACT_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int leftCount = leftRopeEncoder.get();

		if (leftCount <= HIGH_END) {
			done = true;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
			return done;
		
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.climbingLeftSweeper.set(OFF);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
