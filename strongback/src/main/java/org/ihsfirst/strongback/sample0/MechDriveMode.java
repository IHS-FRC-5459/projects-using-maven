package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.drive.MecanumDrive;

public class MechDriveMode extends Command{
	MecanumDrive drive;
	double x;
	double y;
	double rotation;
	public MechDriveMode(MecanumDrive drive, double x, double y, double rotation) {
		this.drive = drive;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	/*
	 * This is the constructor of the drive command 
	 * contains the necessary data for the drive
	 */
	
	
	@Override
    public boolean execute(){
    	drive.cartesian(x, y, rotation);
    	return false;
    	//this drives the robot
    }
    
    @Override
    public void interrupted() {
    	drive.stop();
    	//if interrupted the drive stops
    }
    
    @Override
    public void end(){
    	drive.stop();
    	//if interrupted the drive stops
    }
}
