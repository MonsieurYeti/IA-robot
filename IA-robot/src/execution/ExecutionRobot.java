package execution;

import entites.Coordonnees;
import entites.Robot;
import services.impl.RobotServiceImpl;

/**
 * @author ggaillard
 *
 */
public class ExecutionRobot {

	/**
	 * Service utilisé pour faire des actions sur le robot
	 */
	public static RobotServiceImpl robotService = new RobotServiceImpl();

	/**
	 * Fonction main pour le robot
	 */
	public static void main(String[] args) {

		// On instancie le robot

		Robot robot = new Robot();
		Coordonnees coordonnees = new Coordonnees(3, 3);
		robot.setCoordonnees(coordonnees);
		
		// ---------On peut mettre la suite dans un while(true)---------

		// On affiche la position de départ
		System.out.println("Position en X : " + robotService.donnerPositionX(robot));
		System.out.println("Position en Y : " + robotService.donnerPositionY(robot));
		System.out.println("");

		// On avance de 1 selon X et on affiche la position
		robotService.augmenterX(robot);
		System.out.println("Position en X : " + robotService.donnerPositionX(robot));
		System.out.println("Position en Y : " + robotService.donnerPositionY(robot));
		System.out.println("");

		// On avance de 1 selon Y et on affiche la position
		robotService.augmenterY(robot);
		System.out.println("Position en X : " + robotService.donnerPositionX(robot));
		System.out.println("Position en Y : " + robotService.donnerPositionY(robot));
		System.out.println("");

		// On recule de 1 selon X et on affiche la position
		robotService.diminuerX(robot);
		System.out.println("Position en X : " + robotService.donnerPositionX(robot));
		System.out.println("Position en Y : " + robotService.donnerPositionY(robot));
		System.out.println("");

		// On recule de 1 selon Y et on affiche la position
		robotService.diminuerY(robot);
		System.out.println("Position en X : " + robotService.donnerPositionX(robot));
		System.out.println("Position en Y : " + robotService.donnerPositionY(robot));

	}
}
