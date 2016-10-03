package robot;

import environnement.Coordonnees;
import environnement.Environnement;

public class ThreadRobot implements Runnable {

	Robot robot;
	Environnement environnement;
	int departPositionX;
	int departPositionY;
	Orientation orientation;
	int premierMurX = -10;
	int premierMurY = -10;
	Coordonnees coordonneeManquante = null;
	
	boolean threadFini = false;

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

		// compteur pour ne pas s'arr�ter de suite lors de la d�couverte
		int cpt = 0;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot.ajouterCaseActuelleValideCarte();
		} else {
			System.out.println("Position ou orientation de d�part impossible");
			return;
		}

		while (!threadFini) {

			analyseCase();

			// D�couverte du terrain
			if (!(cpt > 15 && robot.positionX == premierMurX && robot.positionY == premierMurY)) {
				// D�couverte de la bordure
				cpt = decouverteBordure(cpt);
			} else {
				// Compl�tion du terrain
				coordonneeManquante = robot.testerTerrainComplet();

				if (coordonneeManquante != null) {
					System.out.println("Le terrain n'est pas complet, il manque la case X : "
							+ coordonneeManquante.coordonneeX + ", Y : " + coordonneeManquante.coordonneeY);
					threadFini = true;
				}
			}

			// afficherCarte();
		}
	}

	/*
	 * M�thodes priv�es
	 */

	/**
	 * Affiche la carte dans la console
	 */
	private void afficherCarte() {
		// Affiche la map pour le debug
		for (int y = 0; y < 12; y++) {
			System.out.println(robot.carte[0][y] + " " + robot.carte[1][y] + " " + robot.carte[2][y] + " "
					+ robot.carte[3][y] + " " + robot.carte[4][y] + " " + robot.carte[5][y] + " " + robot.carte[6][y]
					+ " " + robot.carte[7][y] + " " + robot.carte[8][y] + " " + robot.carte[9][y] + " "
					+ robot.carte[10][y] + " " + robot.carte[11][y]);
		}
	}

	/**
	 * Analyse la case et r�colte bijoux et poussi�re si besoin
	 */
	private void analyseCase() {
		// poussi�re et bijoux
		if (environnement.testerBijouCase(robot)) {
			robot.ramasserBijou(environnement);
		}

		if (environnement.testerPoussiereCase(robot)) {
			robot.aspirerPoussiere(environnement);
		}
	}

	/**
	 * D�couverte de la bordure du terrain Le compteur sert pour arr�ter la
	 * d�couvert de la bordure
	 * 
	 * @param cpt
	 * @return le compteur � r�inject�
	 */
	private int decouverteBordure(int cpt) {
		// D�couverte de la bordure du terrain
		if (robot.murTouche) {
			testerAGauche();
			testerCaseSuivante();

			// Compteur pour s'arr�ter apr�s la d�couverte du contour,
			// mettre en commentaire sinon
			cpt++;
		} else {
			testerCaseSuivanteAvantPremierMur();
		}
		return cpt;
	}

	/**
	 * Teste la case suivante et avance avant la rencontre du premier mur
	 */
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

	/**
	 * Teste la case suivante et avance apr�s la rencontre du premier mur
	 */
	private void testerCaseSuivante() {
		if (environnement.testerCaseSuivante(robot)) {
			robot.avancer();
			robot.ajouterCaseActuelleValideCarte();
			robot.afficherPosition();
		} else {
			robot.tournerADroite();
		}
	}

	/**
	 * Teste la case � gauche pour la d�couverte des bords
	 */
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
