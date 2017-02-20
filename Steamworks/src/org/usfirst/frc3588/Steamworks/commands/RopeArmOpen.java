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
public class RopeArmOpen extends Command {

	private static final int LEFT_OPEN_POSITION = 497;
	private static final int RIGHT_OPEN_POSITION = -497;
	private static final int L_LOW_END = LEFT_OPEN_POSITION - 15;
	private static final int L_HIGH_END = LEFT_OPEN_POSITION + 15;
	private static final int R_LOW_END = RIGHT_OPEN_POSITION - 15;
	private static final int R_HIGH_END = RIGHT_OPEN_POSITION - 15;
	private static final double LEFT_RETRACT = -1.0;
	private static final double RIGHT_RETRACT = 1.0;
	private static final double LEFT_DEPLOY = 0.5;
	private static final double RIGHT_DEPLOY = -0.5;
	private static final double OFF = 0.0;
	private static boolean done = false;

	private Encoder leftRopeEncoder;
	private Encoder rightRopeEncoder ;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public RopeArmOpen() {

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
		leftRopeEncoder.reset();
		rightRopeEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k1X);
		rightRopeEncoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		int leftCount = leftRopeEncoder.get();
		int rightCount = rightRopeEncoder.get();

		if (leftCount < LEFT_OPEN_POSITION && rightCount > RIGHT_OPEN_POSITION ) {
			RobotMap.climbingLeftSweeper.set(LEFT_DEPLOY);
			RobotMap.climbingLeftSweeper.set(RIGHT_DEPLOY);
		} else if (leftCount >= L_LOW_END && rightCount <= R_LOW_END) {
			done = true;
		} else if (leftCount > L_HIGH_END && rightCount < R_HIGH_END) {
			RobotMap.climbingLeftSweeper.set(LEFT_RETRACT);
			RobotMap.climbingRightSweeper.set(RIGHT_RETRACT);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {

		RobotMap.climbingLeftSweeper.set(OFF);
		RobotMap.climbingRightSweeper.set(OFF);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
