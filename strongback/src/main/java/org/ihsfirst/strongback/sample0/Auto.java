package org.ihsfirst.strongback.sample0;

import org.strongback.command.CommandGroup;
import org.strongback.components.Motor;
import org.strongback.drive.MecanumDrive;

public class Auto extends CommandGroup{
	MecanumDrive drive;
	double x;
	double y;
	double rotation;
	double duration;
	Motor motor;
	
	public Auto(MecanumDrive drive,double x,double y, double rotation,double duration, Motor motor) {
		sequentially(new timedDrive(drive, x, y, rotation, duration),
					 new TimedShoot(motor)
					);//runs these two commands sequentially
	}

	
}
