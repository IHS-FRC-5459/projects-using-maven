package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.components.Motor;

public class Intake extends Command{
	Motor intake;
	
	public Intake(Motor motor) {
		this.intake = motor;
	}//constructor with necessary data
	
	@Override
	public boolean execute() {
		intake.setSpeed(-1);
		return true;
	}//sets the speed to intake
	
}
