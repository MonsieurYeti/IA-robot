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

		int departPositionX = 0;
		int departPositionY = 1;
		Orientation orientation = Orientation.N;

		int premierMurX = -10;
		int premierMurY = -10;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot = new Robot(departPositionX, departPositionY, orientation);
			robot.ajouterCaseValideCarte();
		} else {
			System.out.println("Position ou orientation de départ impossible");
			return;
		}

		robot.afficherPosition();
		int cpt = 0; //compteur pour ne pas s'arrêter de suite lors de la découverte

		while (!(cpt > 15 && robot.positionX == premierMurX && robot.positionY == premierMurY)) {

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
				cpt++;
			} else {
				if (environnement.testerCaseSuivante(robot)) {
					robot.avancer();
					robot.ajouterCaseValideCarte();
				} else {
					robot.tournerADroite();
					robot.murTouche = true;
					premierMurX = robot.positionX;
					premierMurY = robot.positionY;
				}
				robot.afficherPosition();
			}
		}

		//Affiche la map
		for (int x = 0; x < 12; x++) {
			System.out.println(robot.carte[x][0] + " " + robot.carte[x][1] + " " + robot.carte[x][2] + " "
					+ robot.carte[x][3] + " " + robot.carte[x][4] + " " + robot.carte[x][5] + " " + robot.carte[x][6]
					+ " " + robot.carte[x][7] + " " + robot.carte[x][8] + " " + robot.carte[x][9] + " "
					+ robot.carte[x][10] + " " + robot.carte[x][11]);
		}
	}
}
