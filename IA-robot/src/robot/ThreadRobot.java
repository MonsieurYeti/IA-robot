package robot;

import environnement.Environnement;

public class ThreadRobot implements Runnable {

	Robot robot;
	Environnement environnement;
	int departPositionX;
	int departPositionY;
	Orientation orientation;
	int premierMurX = -10;
	int premierMurY = -10;

	/*
	 * Constructeurs
	 */

	public ThreadRobot(Robot robot, Environnement environnement) {
		this.robot = robot;
		this.environnement = environnement;
		this.departPositionX = robot.positionX;
		this.departPositionY = robot.positionY;
		this.orientation = robot.orientation;
	}

	/*
	 * Thread
	 */
	@Override
	public void run() {
		robot.afficherPosition();

		// compteur pour ne pas s'arrêter de suite lors de la découverte
		int cpt = 0;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot.ajouterCaseActuelleValideCarte();
		} else {
			System.out.println("Position ou orientation de départ impossible");
			return;
		}

		while (!(cpt > 15 && robot.positionX == premierMurX && robot.positionY == premierMurY)) {

			// poussière et bijoux
			if (environnement.testerBijouCase(robot)) {
				robot.ramasserBijou(environnement);
			}

			if (environnement.testerPoussiereCase(robot)) {
				robot.aspirerPoussiere(environnement);
			}

			// déclacements
			if (robot.murTouche) {
				testerAGauche();
				testerCaseSuivante();

				// Compteur pour s'arrêter après la découverte du contour,
				// mettre en commentaire sinon
				cpt++;
			} else {
				testerCaseSuivanteAvantPremierMur();
			}
		}
	}

	private void testerCaseSuivanteAvantPremierMur() {
		if (environnement.testerCaseSuivante(robot)) {
			robot.avancer();
			robot.ajouterCaseActuelleValideCarte();
			robot.afficherPosition();
		} else {
			robot.tournerADroite();
			robot.murTouche = true;
			premierMurX = robot.positionX;
			premierMurY = robot.positionY;
		}
	}

	private void testerCaseSuivante() {
		if (environnement.testerCaseSuivante(robot)) {
			robot.avancer();
			robot.ajouterCaseActuelleValideCarte();
			robot.afficherPosition();
		} else {
			robot.tournerADroite();
		}
	}

	private void testerAGauche() {
		if (environnement.testerCaseAGauche(robot)) {
			robot.tournerAGauche();
		} else {
			switch (robot.orientation) {
			case N:
				robot.ajouterCaseInvalideCarte(robot.positionX - 1, robot.positionY);
				break;
			case E:
				robot.ajouterCaseInvalideCarte(robot.positionX, robot.positionY - 1);
				break;
			case S:
				robot.ajouterCaseInvalideCarte(robot.positionX + 1, robot.positionY);
				break;
			case O:
				robot.ajouterCaseInvalideCarte(robot.positionX, robot.positionY + 1);
				break;
			}
		}
	}
}
