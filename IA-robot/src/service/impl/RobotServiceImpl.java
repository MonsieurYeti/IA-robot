package service.impl;

import java.Coordonnees;
import java.Robot;

import service.RobotService;

public class RobotServiceImpl implements RobotService {

	public Coordonnees renvoyerPositionRobot(Robot robot) {

		return robot.getCoordonnees();
	}
	
}
