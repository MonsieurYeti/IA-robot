package robot;

import environnement.Environnement;

/**
 * @author ggaillard
 *
 */
public class Robot {

	public int positionX;
	public int positionY;
	public Orientation orientation;
	public boolean murTouche = false;
	public int compteurBijoux = 0;
	public int compteurElectricite = 0;

	public boolean[][] carte = new boolean[12][12];

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
				carte[x][y] = false;
			}
		}
	}

	/*
	 * M�thodes
	 */

	/**
	 * Affiche la position en X et Y du robot
	 */
	public void afficherPosition() {
		System.out.println("X : " + this.positionX + ", Y : " + this.positionY);
	}

	/**
	 * Ajoute la case courante comme case possible dans la carte
	 */
	public void ajouterCaseValideCarte() {
		this.carte[this.positionX][this.positionY] = true;
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
	}

	/**
	 * Ramasse le bijou pr�sent s'il y en a un
	 * 
	 * @param environnement
	 */
	public void ramasserBijou(Environnement environnement) {
		compteurElectricite++;
		environnement.enleverBijou(this.positionX, this.positionY);
	}

	/**
	 * Ramasse le bijou pr�sent s'il y en a un
	 * 
	 * @param environnement
	 */
	public void aspirerPoussiere(Environnement environnement) {
		compteurElectricite++;
		environnement.aspirerPoussiere(this.positionX, this.positionY);
	}
}
