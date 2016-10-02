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

	public ThreadRobot(Robot robot, Environnement environnement, int departPositionX, int departPositionY,
			Orientation orientation) {
		this.robot = robot;
		this.environnement = environnement;
		this.departPositionX = departPositionX;
		this.departPositionY = departPositionY;
		this.orientation = orientation;
	}

	/*
	 * Thread
	 */
	@Override
	public void run() {
		robot.afficherPosition();

		// compteur pour ne pas s'arr�ter de suite lors de la d�couverte
		int cpt = 0;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot.ajouterCaseActuelleValideCarte();
		} else {
			System.out.println("Position ou orientation de d�part impossible");
			return;
		}

		while (!(cpt > 15 && robot.positionX == premierMurX && robot.positionY == premierMurY)) {

			// poussi�re et bijoux
			if (environnement.testerBijouCase(robot)) {
				robot.ramasserBijou(environnement);
			}

			if (environnement.testerPoussiereCase(robot)) {
				robot.aspirerPoussiere(environnement);
			}

			// d�clacements
			if (robot.murTouche) {

				if (environnement.testerCaseAGauche(robot)) {
					robot.tournerAGauche();
				}

				if (environnement.testerCaseSuivante(robot)) {
					robot.avancer();
					robot.ajouterCaseActuelleValideCarte();

					// timer pour ralentir
					long start = System.currentTimeMillis();
					while ((System.currentTimeMillis() - start) < 500)
						;
					robot.afficherPosition();
				} else {
					robot.tournerADroite();
				}
				
				// Compteur pour s'arr�ter apr�s la d�couverte du contour,
				// mettre en commentaire sinon
				// cpt++;

			} else {
				if (environnement.testerCaseSuivante(robot)) {
					robot.avancer();
					robot.ajouterCaseActuelleValideCarte();

					// timer pour ralentir
					long start = System.currentTimeMillis();
					while ((System.currentTimeMillis() - start) < 500)
						;
					robot.afficherPosition();
				} else {
					robot.tournerADroite();
					robot.murTouche = true;
					premierMurX = robot.positionX;
					premierMurY = robot.positionY;
				}
			}
		}
	}
}
