package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.components.Motor;

public class TimedShoot extends Command{
	Motor intake;
	int ticks;
	public TimedShoot(Motor motor) {
		this.intake = motor;
	}
	//is constructor for command with necessary data
	@Override
	public boolean execute() {
		if (ticks<= 100) {
			intake.setSpeed(1);	
		}else{
			return true;
		}
		//runs the command for the given time
		return false;
	}
	
}
