/* Created Fri Sep 30 11:19:04 EDT 2016 */
package org.ihsfirst.strongback.sample0;

import org.strongback.*;
import org.strongback.Strongback;
import org.strongback.hardware.*;
import org.strongback.components.*;
import org.strongback.components.ui.*;
import org.strongback.drive.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	public TankDrive drive;
	private static final int FLport = 1;
	private static final int BLport = 2;
	private static final int FRport = 3;
	private static final int BRport = 4;
	private Accelerometer accel;
	private Gyroscope gyro;
	private ADXRS450_Gyro base;
	private DistanceSensor forawardSensor;
	private DistanceSensor sideSensor;
	private Switch limitSwitch;
	private Solenoid solenoid;
	private boolean isExtended = false;
	private MecanumDrive driveM;
	private SwitchReactor reactor;
	private FlightStick joystick1;
	private static Motor shoot;
	/*
	 * this is were you declare the objects and variables that you are using
	 * all can be private because they are not leaving this class
	 * also convention is that everything should be private
	 * they can still be passed to methods
	 * 
	 * All variables can also be initialized
	 */
	
    @Override
    public void robotInit() {
    	Motor shoot = Hardware.Motors.talon(8);
    	Motor FL = Hardware.Motors.talon(FLport);
    	Motor BL = Hardware.Motors.talon(BLport);
    	Motor FR = Hardware.Motors.talon(FRport).invert();	
    	Motor BR = Hardware.Motors.talon(BRport).invert();
    	Motor Right = Motor.compose(FR, BR);
    	Motor Left = Motor.compose(FL, BL);
    	accel = Hardware.Accelerometers.analogAccelerometer(0, 0.18, 0.0/*this value is determined experimentally */);
    	gyro = Hardware.AngleSensors.gyroscope(base);
    	forawardSensor = Hardware.DistanceSensors.analogUltrasonic(0, 3.63);
    	sideSensor = Hardware.DistanceSensors.analogUltrasonic(1, 3.63);
    	limitSwitch = Hardware.Switches.normallyOpen(1);
    	drive = new TankDrive(Left, Right);
    	driveM = new MecanumDrive(FL, BL, FR, BR, gyro);
    	joystick1 = Hardware.HumanInterfaceDevices.logitechAttack3D(0);
    	reactor = Strongback.switchReactor();
    	/*
    	 * this is were all the objects are initialized
    	 * for all objects initialized look at the git book link in the read me
    	 */
    }
    @Override
    public void autonomousInit() {
    	Strongback.start();
    	//this starts the schedule
    }
    
    @Override
    public void autonomousPeriodic(){
    	Strongback.submit(new Auto(driveM, 0.0,0.7,0.0, 10.0,shoot));
    	/*
    	 * This runs a command group
    	 */
    }
    @Override
    public void teleopInit() {
        
    }

    @Override
    public void teleopPeriodic() {
    	Strongback.submit(new MechDriveMode(driveM, joystick1.getRoll().read(), joystick1.getPitch().read(), joystick1.getYaw().read()));
    	Strongback.submit(new DisplayData(gyro, accel, forawardSensor, sideSensor, limitSwitch,isExtended));
    	/*
    	 * This is sumbiting the commands every tick
    	 * this makes sure that these command are always running
    	*/
    	reactor.whileTriggered(joystick1.getThumb(), ()-> Strongback.submit(new Intake(shoot)));
		reactor.whileTriggered(joystick1.getTrigger(),()->Strongback.submit(new Shoot(shoot)));
		reactor.onTriggered(joystick1.getButton(4), ()->Strongback.submit(new OpenClaw(solenoid, isExtended)));
		reactor.onTriggered(joystick1.getButton(5), ()->Strongback.submit(new CloseClaw(solenoid, isExtended)));
		/*
		 * The reactor method as an conditional, after reactor describes the action.
		 * the first argument is the button that is being uses
		 * the second argument is the command supplier, a lambda expression is being used.
		 * the ()-> is kinda pointing to the Strongback.submit()  Note: this function is located 
		 * in a functional interface so it wont work with any old function
		 * Look here for more info on Lambda http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
		*/
		
		
    }

    @Override
    public void disabledInit() {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable();
    }
    
    
   

}
