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

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc3588.Steamworks.GripPipelinePeg;
import org.usfirst.frc3588.Steamworks.Robot;
import org.usfirst.frc3588.Steamworks.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class DrivePegCommand extends Command {
	private final Object imgLock = new Object();
	private int centerX = -1;
	private VisionThread visionThread;
	private int width = -1;
	private boolean targetFound = false;
	private boolean done = false;
	private int count = 0;
	private int contours;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DrivePegCommand() {

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
		System.out.println("Drive Peg Command Initialize");
		visionThread = new VisionThread(Robot.cam1, new GripPipelinePeg(), pipeline -> {
			int leftPosition = Robot.IMG_WIDTH;
			int rightPosition = 0;
			Rect r1 = null;
			for( int i = 0; i < pipeline.filterContoursOutput().size(); i++) {
				r1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(i));
				
				if (r1.x < leftPosition) {
					leftPosition = r1.x;
				}
				if (r1.x + r1.width > rightPosition) {
					rightPosition = r1.x + r1.width;
				}
				
			}		
				synchronized (imgLock) {
					centerX = (leftPosition + rightPosition) / 2;
					contours = pipeline.filterContoursOutput().size();
				}
			});
		visionThread.start();
		System.out.println("finished drive peg initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		int myCenterX = 0;
		Timer.delay(1.0);
		
		synchronized (imgLock) {
			myCenterX = this.centerX;
		}
		System.out.println("center = " + centerX + " width = " + width + "Execute contours is: " + contours);
		if (myCenterX != -1) {
			
			// myCenterX is in screen coordinate. We need to convert it to robot
			// coordinates.
			double direction = (myCenterX - (Robot.IMG_WIDTH / 2));
			System.out.println("direction: " + direction);
			if (direction > 15) {
				RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0.8, 0.0, 0.0, 0.0);
				System.out.println("is right");
				
			} else if (direction < -15) {
				RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(-0.8, 0.0, 0.0, 0.0);
				System.out.println("is left");
				
			} else {
				count++;
				System.out.println("count = " + count);
				if (count > 0) {
					System.out.println("done");
					done = true;
				}
				System.out.println("is middle");
			}
		} else if (targetFound) {
//			count++;
//			System.out.println(count);
//			if (count > 100) {
//				new GearReleaseCommand();
//				RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0.0, 0.5, 0.0, 0.0);
//				Timer.delay(.5);
//				RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0.0, -0.5, 0.0, 0.0);
//				Timer.delay(0.5);
//				new GearCloseCommand();
//				// Here is where we position the gear and release it.
//				System.out.println("WE DID IT");
//				done = true;
			}
//		} else {
//			RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0.0, -0.3, 0.0, 0.0);
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.chassisRobotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
