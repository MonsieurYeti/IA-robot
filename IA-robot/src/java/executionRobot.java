package java;

import java.entites.Robot;
import java.services.RobotService;

/**
 * @author ggaillard
 *
 */
public class executionRobot {

	/**
	 * Service utilisé pour faire des actions sur le robot
	 */
	public static RobotService robotService;

	/**
	 * Fonction main pour le robot
	 */
	public static void main() {

		// On instancie le robot
		Robot robot = new Robot(3, 3);

		// ---------On peut mettre la suite dans un while(true)---------

		// On affiche la position de départ
		System.out.println("Position en X : " + robotService.donnerPosition(robot).getPositionX());
		System.out.println("Position en Y : " + robotService.donnerPosition(robot).getPositionY());

		// On avance de 1 selon X et on affiche la position
		robotService.augmenterX(robot);
		System.out.println("Position en X : " + robotService.donnerPosition(robot).getPositionX());
		System.out.println("Position en Y : " + robotService.donnerPosition(robot).getPositionY());

		// On avance de 1 selon Y et on affiche la position
		robotService.augmenterY(robot);
		System.out.println("Position en X : " + robotService.donnerPosition(robot).getPositionX());
		System.out.println("Position en Y : " + robotService.donnerPosition(robot).getPositionY());

		// On recule de 1 selon X et on affiche la position
		robotService.diminuerX(robot);
		System.out.println("Position en X : " + robotService.donnerPosition(robot).getPositionX());
		System.out.println("Position en Y : " + robotService.donnerPosition(robot).getPositionY());

		// On recule de 1 selon Y et on affiche la position
		robotService.diminuerY(robot);
		System.out.println("Position en X : " + robotService.donnerPosition(robot).getPositionX());
		System.out.println("Position en Y : " + robotService.donnerPosition(robot).getPositionY());

	}
}
