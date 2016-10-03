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
	int directionRecherche = 0;
	boolean caseARechercher = false;
	boolean parcoursContour = true;

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

		// Compteur pour ne pas s'arrêter de suite lors de la découverte
		int cpt = 0;

		if (environnement.testerCasePossible(departPositionX, departPositionY)) {
			robot.ajouterCaseActuelleValideCarte();
		} else {
			System.out.println("Position ou orientation de départ impossible");
			return;
		}

		while (!threadFini) {

			// On vérifie ce qu'il y a sur la case et on le ramasse s'il y en a
			analyseCase();

			// Découverte du terrain
			if (parcoursContour && !(cpt > 10 && robot.positionX == premierMurX && robot.positionY == premierMurY)) {
				// Découverte de la bordure
				cpt = decouverteBordure(cpt);
			} else {

				coordonneeManquante = robot.testerTerrainComplet();
				parcoursContour = false;

				if (coordonneeManquante != null) {
					System.out.println("Le terrain n'est pas complet, il manque la case X : "
							+ coordonneeManquante.coordonneeX + ", Y : " + coordonneeManquante.coordonneeY);
					completionTerrain(coordonneeManquante);
				} else {
					System.out.println("Le terrain est complet !");
					threadFini = true;

					// On remet à 0 pour recommencer le tour
					// cpt = 0;
					// parcoursContour = true;
					// robot.murTouche = false;
					// premierMurX = -10;
					// premierMurY = -10;
				}
			}
			// Pour le débug
			// afficherCarte();
		}
	}

	/*
	 * ------------------ Méthodes privées ------------------
	 */

	/**
	 * Complète la recherche du terrain avec les cases centrales manquantes
	 */
	private void completionTerrain(Coordonnees coordonneeManquante) {
		while (robot.positionX != coordonneeManquante.coordonneeX
				|| robot.positionY != coordonneeManquante.coordonneeY) {

			switch (directionRecherche) {
			case 0:
				if (robot.positionX != coordonneeManquante.coordonneeX) {
					if (robot.positionX < coordonneeManquante.coordonneeX) {
						robot.orientation = Orientation.E;
					} else {
						robot.orientation = Orientation.O;
					}
					caseARechercher = true;
				}
				// Pour alterner le sens
				directionRecherche = 1;
				break;

			case 1:
				if (robot.positionY != coordonneeManquante.coordonneeY) {
					if (robot.positionY < coordonneeManquante.coordonneeY) {
						robot.orientation = Orientation.S;
					} else {
						robot.orientation = Orientation.N;
					}
					caseARechercher = true;
				}
				// Pour alterner le sens
				directionRecherche = 0;
				break;
			}

			if (environnement.testerCaseSuivante(robot) && caseARechercher) {
				robot.avancer();
				robot.afficherPosition();
				caseARechercher = false;
			}
		}
		robot.ajouterCaseActuelleValideCarte();
	}

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
	 * Analyse la case et récolte bijoux et poussière si besoin
	 */
	private void analyseCase() {
		// poussière et bijoux
		if (environnement.testerBijouCase(robot)) {
			robot.ramasserBijou(environnement);
		}

		if (environnement.testerPoussiereCase(robot)) {
			robot.aspirerPoussiere(environnement);
		}
	}

	/**
	 * Découverte de la bordure du terrain Le compteur sert pour arrêter la
	 * découvert de la bordure
	 * 
	 * @param cpt
	 * @return le compteur à réinjecter
	 */
	private int decouverteBordure(int cpt) {
		// Découverte de la bordure du terrain
		if (robot.murTouche) {
			testerAGauche();
			testerCaseSuivante();

			// Compteur pour s'arrêter après la découverte du contour,
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
	 * Teste la case suivante et avance après la rencontre du premier mur
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
	 * Teste la case à gauche pour la découverte des bords
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
