package org.ihsfirst.strongback.sample0;
import org.strongback.command.Command;
//import org.strongback.command.Requirable;
import org.strongback.components.Accelerometer;
import org.strongback.components.DistanceSensor;
import org.strongback.components.Gyroscope;
import org.strongback.components.Switch;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DisplayData extends Command{
	private Gyroscope gyro;
	private Accelerometer accel;
	private DistanceSensor forwardSensor;
	private DistanceSensor sideSensor;
	private Switch switch1;
	private boolean solenoid;
	
	public DisplayData(Gyroscope gyro, Accelerometer accel,DistanceSensor forwardSensor, DistanceSensor sideSensor, Switch limitSwitch, boolean Solenoid) {
		//super(accel); TODO look at this durrning testing
		this.accel = accel;
		this.gyro = gyro;
		this.forwardSensor = forwardSensor;
		this.sideSensor = sideSensor;
		this.switch1 = limitSwitch;
		this.solenoid = Solenoid;
	}
	//this constructs the the command with data
	
	
	
	
	@Override
	public boolean execute(){
		
		SmartDashboard.putNumber("Acceleration", accel.getAcceleration());
		SmartDashboard.putNumber("Angle", gyro.getAngle());
		SmartDashboard.putNumber("Side Sensor", distance(sideSensor.getDistanceInInches() + 10.0, gyro));
		SmartDashboard.putNumber("Forward Sensor", distance(forwardSensor.getDistanceInInches() + 10.0, gyro));
		SmartDashboard.putBoolean("Is the solenoid extended:", solenoid);
		//puts data on the screen
		if (switch1.equals(false)) {
			SmartDashboard.putBoolean("switch", false);
		}else{
			SmartDashboard.putBoolean("switch", true);
		}
		//puts the boolean on based on the switch
		return true;
		//Continues to put data on
	}
	
	public double distance(double dis1, Gyroscope gyro){
		double dis = dis1/Math.cos(gyro.getAngle());
		return dis;
		//This returns the distance compensating for the angle of the sensor
	}
}
