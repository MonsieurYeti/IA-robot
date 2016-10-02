package robot;

import environnement.Environnement;

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

		int departPositionX = 2;
		int departPositionY = 2;
		Orientation orientation = Orientation.N;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot = new Robot(departPositionX, departPositionY, orientation);
			robot.ajouterCaseValideCarte();
		} else {
			System.out.println("Position ou orientation de départ impossible");
			return;
		}

		robot.afficherPosition();

		while (!(robot.positionX == departPositionX && robot.positionY == departPositionY && robot.murTouche)) {

			if (robot.murTouche) {

				if (environnement.testerCaseAGauche(robot)) {
					robot.tournerAGauche();
				}

				if (environnement.testerCaseSuivante(robot)) {
					robot.avancer();
					robot.ajouterCaseValideCarte();
				} else {
					robot.tournerADroite();
				}
				robot.afficherPosition();
			} else {
				if (environnement.testerCaseSuivante(robot)) {
					robot.avancer();
					robot.ajouterCaseValideCarte();
				} else {
					robot.tournerADroite();
					robot.murTouche = true;
				}
				robot.afficherPosition();
			}
		}

		for (int x = 0; x < 12; x++) {
			System.out.println(robot.carte[x][0] + " " + robot.carte[x][1] + " " + robot.carte[x][2] + " "
					+ robot.carte[x][3] + " " + robot.carte[x][4] + " " + robot.carte[x][5] + " " + robot.carte[x][6]
					+ " " + robot.carte[x][7] + " " + robot.carte[x][8] + " " + robot.carte[x][9] + " "
					+ robot.carte[x][10] + " " + robot.carte[x][11]);
		}
	}
}
