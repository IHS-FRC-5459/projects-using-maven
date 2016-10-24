package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.components.Solenoid;

public class OpenClaw extends Command{
	Solenoid solenoid;
	boolean isExtended;
	public OpenClaw(Solenoid solenoid, boolean isExtended) {
		this.solenoid = solenoid;
		this.isExtended = isExtended;
	}
	/*
	 * This is the constructor for the open claw command
	 */
	
	@Override
	public boolean execute(){
		if (isExtended) {
			return true;
		}//if the solenoid is extended return true.  When it is returned true the execute stops
		solenoid.extend();// this extends the piston 
		return true;
	}
}
