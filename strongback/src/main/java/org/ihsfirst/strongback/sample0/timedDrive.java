package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.drive.MecanumDrive;

public class timedDrive extends Command{
	MecanumDrive drive;
	double x;
	double y;
	double rotation;
	double duration;
	public timedDrive(MecanumDrive drive, double x, double y, double rotation, double duration) {
		super(duration, drive);
		this.drive = drive;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	
	
	@Override
	public boolean execute() {
		drive.cartesian(x, y, rotation);
		return false;
	}
	@Override
	    public void interrupted() {
	        drive.stop();
	    }
	    
	@Override
	public void end() {
		drive.stop();
	}

}
