package Robot;

import Environnement.Environnement;

/**
 * @author ggaillard
 *
 */
public class Execution {

	/**
	 * Fonction main pour le robot
	 */
	public static void main(String[] args) {

		// On instancie le robot et l'environnement
		Environnement environnement = new Environnement();
		Robot robot;

		int departPositionX = 0;
		int departPositionY = 0;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot = new Robot(departPositionX, departPositionY);
			robot.carte[robot.positionX][robot.positionY]=true;
		} else {
			System.out.println("Position de départ impossible");
			return;
		}

		// ---------On peut mettre la suite dans un while(true)---------

		// On affiche la position de depart
		robot.afficherPosition();

		// On recule de 1 selon X et on affiche la position
		if (environnement.testerCasePossible(robot.positionX - 1, robot.positionY)) {
			robot.diminuerX();
			robot.ajouterCaseValideCarte();
		}
		robot.afficherPosition();

		// On recule de 1 selon Y et on affiche la position
		if (environnement.testerCasePossible(robot.positionX, robot.positionY - 1)) {
			robot.diminuerY();
			robot.ajouterCaseValideCarte();
		}
		robot.afficherPosition();

		// On avance de 1 selon X et on affiche la position
		if (environnement.testerCasePossible(robot.positionX + 1, robot.positionY)) {
			robot.augmenterX();
			robot.ajouterCaseValideCarte();
		}
		robot.afficherPosition();

		// On avance de 1 selon Y et on affiche la position
		if (environnement.testerCasePossible(robot.positionX, robot.positionY + 1)) {
			robot.augmenterY();
			robot.ajouterCaseValideCarte();
		}
		robot.afficherPosition();
	}
}
