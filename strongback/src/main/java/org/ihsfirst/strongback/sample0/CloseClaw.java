package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.components.Solenoid;

public class CloseClaw extends Command{
	Solenoid solenoid;
	boolean isExtended;
	
	public CloseClaw(Solenoid solenoid, boolean isExtended) {
		this.solenoid = solenoid;
		this.isExtended = isExtended;
	}//constructs the necessary data on command
	
	
	@Override
	public boolean execute(){
		if (!isExtended) {
			return true;
		}//if the solenoid is not extended return true.  When it is returned true the execute stops
		solenoid.retract();//this retracts the piston
		return true;		
	}
	
	
}
