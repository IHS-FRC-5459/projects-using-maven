package org.ihsfirst.strongback.sample0;

import org.strongback.command.Command;
import org.strongback.components.Motor;

public class Shoot extends Command{
	Motor intake;
	public Shoot(Motor motor) {
		this.intake = motor;
	}
	//is constructor for command with necessary data
	@Override
	public boolean execute() {
		intake.setSpeed(1);
		return true;//sets the speed to shoot the ball
	}
	
	
}
