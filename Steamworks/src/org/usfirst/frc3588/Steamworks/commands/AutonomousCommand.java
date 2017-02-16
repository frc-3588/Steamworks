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
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommand extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	static private double Kp = 2.0;
	static private double xAxis = 0.0;
	static private double yAxis = -0.5;
	static private double stop = 0.0;
	static private double twist = 0.0;
	private final int MIDDLE_POSITION = 0;
	private final int RIGHT_POSITION = 1;
	private final int LEFT_POSITION = 2;
	private boolean contoursFound;
	private int autoMode = -1;
	private boolean done = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public AutonomousCommand() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		setTimeout(3.0);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		RobotMap.chassisGyro.reset();
		RobotMap.chassisRobotDrive.setMaxOutput(0.5);
		autoMode = (int) SmartDashboard.getNumber("DB/Slider 0", 0.0);
		System.out.println("something went wrong :(" + autoMode + ")");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// double angle = RobotMap.chassisGyro.getAngle();
		// AutonomousCommand.System.out.println(angle);
		// RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(xAxis, yAxis,
		// twist, angle*Kp);
		if (autoMode == MIDDLE_POSITION) {
			CommandGroup aCommandGroup = new MiddlePosition();
			aCommandGroup.start();
			done = true;
			System.out.println("Finished starting MiddlePosition.");
		} else if (autoMode == RIGHT_POSITION) {
			CommandGroup aCommandGroup = new RightPosition();
			aCommandGroup.start();
			done = true;
			System.out.println("Finished starting RightPosition.");
		} else if (autoMode == LEFT_POSITION) {
			CommandGroup aCommandGroup = new LeftPosition();
			aCommandGroup.start();
			done = true;
			System.out.println("Finished starting LeftPosition.");
		} else {
			System.out.println("something went wrong again :(");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(stop, stop, stop, stop);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
