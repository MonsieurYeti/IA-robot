package java.services.impl;

import java.entites.Coordonnees;
import java.entites.Robot;
import java.services.RobotService;

/**
 * @author ggaillard
 *
 */
public class RobotServiceImpl implements RobotService {

	/**
	 * Renvoie les coordonnées du robot passé en paramètre
	 */
	@Override
	public Coordonnees donnerPosition(Robot robot) {
		return robot.getCoordonnees();
	}

	/**
	 * Augmente la position en X du robot de 1
	 */
	@Override
	public void augmenterX(Robot robot) {
		robot.getCoordonnees().setPositionX(robot.getCoordonnees().getPositionX() + 1);
	}

	/**
	 * Diminue la position en X du robot de 1
	 */
	@Override
	public void diminuerX(Robot robot) {
		robot.getCoordonnees().setPositionX(robot.getCoordonnees().getPositionX() - 1);

	}

	/**
	 * Augmente la position en Y du robot de 1
	 */
	@Override
	public void augmenterY(Robot robot) {
		robot.getCoordonnees().setPositionY(robot.getCoordonnees().getPositionY() + 1);
	}

	/**
	 * Diminue la position en Y du robot de 1
	 */
	@Override
	public void diminuerY(Robot robot) {
		robot.getCoordonnees().setPositionY(robot.getCoordonnees().getPositionY() - 1);
	}
}
