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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chassisleftFrontMotor;
    public static CANTalon chassisleftRearMotor;
    public static CANTalon chassisrightFrontMotor;
    public static CANTalon chassisrightRearMotor;
    public static RobotDrive chassisRobotDrive;
    public static AnalogGyro chassisGyro;
    public static CANTalon climbingMotor;
    public static DigitalInput climbinglimitSwitch;
    public static DoubleSolenoid gearsSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisleftFrontMotor = new CANTalon(1);
        LiveWindow.addActuator("Chassis", "leftFrontMotor", chassisleftFrontMotor);
        
        chassisleftRearMotor = new CANTalon(0);
        LiveWindow.addActuator("Chassis", "leftRearMotor", chassisleftRearMotor);
        
        chassisrightFrontMotor = new CANTalon(2);
        LiveWindow.addActuator("Chassis", "rightFrontMotor", chassisrightFrontMotor);
        
        chassisrightRearMotor = new CANTalon(3);
        LiveWindow.addActuator("Chassis", "rightRearMotor", chassisrightRearMotor);
        
        chassisRobotDrive = new RobotDrive(chassisleftFrontMotor, chassisleftRearMotor,
              chassisrightFrontMotor, chassisrightRearMotor);
        
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setSensitivity(0.5);
        chassisRobotDrive.setMaxOutput(1.0);
        chassisRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        chassisRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        chassisGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
        climbingMotor = new CANTalon(4);
        LiveWindow.addActuator("Climbing", "Motor", climbingMotor);
        
        climbinglimitSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Climbing", "limitSwitch", climbinglimitSwitch);
        
        gearsSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Gears", "Solenoid", gearsSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
