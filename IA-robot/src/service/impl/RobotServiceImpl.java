package service.impl;

import java.Coordonnees;
import java.Robot;

import service.RobotService;

public class RobotServiceImpl implements RobotService {

	@Override
	public Coordonnees renvoyerPositionRobot(Robot robot) {
		return robot.getCoordonnees();
	}

	@Override
	public void augmenterX(Coordonnees coordonnees) {
		coordonnees.setPositionX(coordonnees.getPositionX()+1);
	}

	@Override
	public void diminuerX(Coordonnees coordonnees) {
		coordonnees.setPositionX(coordonnees.getPositionX()-1);

	}

	@Override
	public void augmenterY(Coordonnees coordonnees) {
		coordonnees.setPositionY(coordonnees.getPositionY()+1);
	}

	@Override
	public void diminuerY(Coordonnees coordonnees) {
		coordonnees.setPositionY(coordonnees.getPositionY()-1);
	}
}
