package robot;

import environnement.Coordonnees;
import environnement.Environnement;

public class Robot {

	public int positionX;
	public int positionY;
	public Orientation orientation;
	public boolean murTouche = false;
	public int compteurBijoux = 0;
	public int compteurElectricite = 0;

	private int tailleTableauX = 12;
	private int tailleTableauY = 12;

	public String[][] carte = new String[tailleTableauX][tailleTableauY];

	/*
	 * Constructeurs
	 */

	public Robot() {
	}

	public Robot(int x, int y, Orientation orientation) {
		this.positionX = x;
		this.positionY = y;
		this.orientation = orientation;

		for (x = 0; x < 12; x++) {
			for (y = 0; y < 12; y++) {
				carte[x][y] = "X";
			}
		}
	}

	/*
	 * Méthodes
	 */

	/**
	 * Affiche la position en X et Y du robot
	 */
	public void afficherPosition() {
		System.out.println("X : " + this.positionX + ", Y : " + this.positionY);
	}

	/**
	 * Teste si la case est dans la carte
	 */
	public boolean testerCasePossibleCarte(int x, int y) {
		if (x >= 0 && x < tailleTableauX && y >= 0 && y < tailleTableauY) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ajoute la case courante comme case possible dans la carte
	 */
	public void ajouterCaseActuelleValideCarte() {
		this.carte[this.positionX][this.positionY] = "1";
	}

	/**
	 * Ajoute la case courante comme case impossible dans la carte
	 * 
	 * @param x
	 * @param y
	 */
	public void ajouterCaseInvalideCarte(int x, int y) {
		if (x >= 0 && x < tailleTableauX && y >= 0 && y < tailleTableauY) {
			this.carte[x][y] = "0";
		}
	}

	/**
	 * Fait tourner l'orientation du robot vers la droite
	 */
	public void tournerADroite() {
		switch (orientation) {
		case N:
			orientation = Orientation.E;
			break;
		case E:
			orientation = Orientation.S;
			break;
		case S:
			orientation = Orientation.O;
			break;
		case O:
			orientation = Orientation.N;
			break;
		default:
			System.out.println("L'orientation du robot est impossible");
			break;
		}
	}

	/**
	 * Fait tourner l'orientation du robot vers la gauche
	 */
	public void tournerAGauche() {
		switch (orientation) {
		case N:
			orientation = Orientation.O;
			break;
		case O:
			orientation = Orientation.S;
			break;
		case S:
			orientation = Orientation.E;
			break;
		case E:
			orientation = Orientation.N;
			break;
		default:
			System.out.println("L'orientation du robot est impossible");
			break;
		}
	}

	/**
	 * Fait avancer le robot d'une case suivant sa position
	 */
	public void avancer() {
		compteurElectricite++;

		switch (orientation) {
		case N:
			this.positionY--;
			break;
		case E:
			this.positionX++;
			break;
		case S:
			this.positionY++;
			break;
		case O:
			this.positionX--;
			break;
		default:
			System.out.println("L'orientation du robot est impossible");
			break;
		}

		// timer pour ralentir
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start) < 500)
			;
	}

	/**
	 * Ramasse le bijou présent s'il y en a un
	 * 
	 * @param environnement
	 */
	public void ramasserBijou(Environnement environnement) {
		compteurElectricite++;
		environnement.enleverBijou(this.positionX, this.positionY);
		System.out.println("Bijou ramassé en " + this.positionX + "  " + this.positionY);
	}

	/**
	 * Ramasse le bijou présent s'il y en a un
	 * 
	 * @param environnement
	 */
	public void aspirerPoussiere(Environnement environnement) {
		compteurElectricite++;
		environnement.aspirerPoussiere(this.positionX, this.positionY);
		System.out.println("Poussiere ramassée en " + this.positionX + "  " + this.positionY);
	}

	/**
	 * Teste si le terrain est découvert complètement
	 * 
	 * @return null si le terrain est complet, la coordonne manquante sinon
	 */
	public Coordonnees testerTerrainComplet() {
		// Pour chaque case
		for (int y = 0; y < tailleTableauY; y++) {
			for (int x = 0; x < tailleTableauX; x++) {
				// On regarde si la case peut être découverte mais ne l'est pas
				if (testerCasePossibleCarte(x, y) && carte[x][y] == "X") {
					if (testerCasePossibleCarte(x + 1, y) && carte[x + 1][y] == "1") {
						if (testerCasePossibleCarte(x - 1, y) && carte[x - 1][y] == "1") {
							if (testerCasePossibleCarte(x, y + 1) && carte[x][y + 1] == "1") {
								if (testerCasePossibleCarte(x, y - 1) && carte[x][y - 1] == "1") {
									return new Coordonnees(x, y);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
