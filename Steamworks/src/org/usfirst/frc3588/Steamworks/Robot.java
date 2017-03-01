// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3588.Steamworks;

import org.usfirst.frc3588.Steamworks.commands.AutonomousCommand;
import org.usfirst.frc3588.Steamworks.subsystems.Chassis;
import org.usfirst.frc3588.Steamworks.subsystems.Climbing;
import org.usfirst.frc3588.Steamworks.subsystems.Gears;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/*public static*/ Command autonomousCommand;
	NetworkTable table;
	GripPipelinePeg pipeline;

	public static OI oi;
	public static CameraServer server;
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	public static UsbCamera cam2;
	public static UsbCamera cam3;

	// private VisionThread visionThread;
	// private double centerX = 0.0;
	// private boolean contoursFound = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static Climbing climbing;
    public static Gears gears;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		RobotMap.init();

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new Chassis();
        climbing = new Climbing();
        gears = new Gears();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.e
		oi = new OI();

		cam2 = CameraServer.getInstance().startAutomaticCapture(0);
		cam3 = CameraServer.getInstance().startAutomaticCapture(1);

		// server = CameraServer.getInstance();
		// server.startAutomaticCapture(new UsbCamera("cam0", 0));
		// server.startAutomaticCapture(new UsbCamera("cam1", 1));

		table = NetworkTable.getTable("GRIP/myContoursReport");
		double[] defaultValue = new double[0];

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		// UsbCamera camera =
		// CameraServer.getInstance().startAutomaticCapture();
		//cam0.setResolution(IMG_WIDTH, IMG_HEIGHT);

		// while(true) {
		// double[] areas = table.getNumberArray("area", defaultValue);
		// System.out.print("areas: ");
		// for (double area : areas) {
		// System.out.print(area + " ");
		// }
		// System.out.println();
		// Timer.delay(1);
		// }
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
