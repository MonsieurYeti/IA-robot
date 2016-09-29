package services.impl;
import entites.Robot;
import services.RobotService;

/**
 * @author ggaillard
 *
 */
public class RobotServiceImpl implements RobotService {

	/**
	 * Renvoie la coordonnée en X du robot passé en paramètre
	 */
	@Override
	public int donnerPositionX(Robot robot) {
		int coordonneeX = robot.getCoordonnees().getPositionX();
		return coordonneeX++;
	}
	
	/**
	 * Renvoie la coordonnée en Y du robot passé en paramètre
	 */
	@Override
	public int donnerPositionY(Robot robot) {
		int coordonneeY = robot.getCoordonnees().getPositionY();
		return coordonneeY++;
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
