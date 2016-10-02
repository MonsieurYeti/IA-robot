package Robot;

/**
 * @author ggaillard
 *
 */
public class Robot {

	public int positionX;
	public int positionY;

	public boolean[][] carte = new boolean[12][12];

	/*
	 * Constructeurs
	 */

	public Robot(int x, int y) {
		this.positionX = x;
		this.positionY = y;
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
	 * Avance le robot suivant X du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void augmenterX() {
		this.positionX++;
	}

	/**
	 * Recule le robot suivant X du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void diminuerX() {
		this.positionX--;
	}

	/**
	 * Avance le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void augmenterY() {
		this.positionY++;
	}

	/**
	 * Recule le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void diminuerY() {
		this.positionY--;
	}

	/**
	 * Ajoute la case courante comme case possible dans la carte
	 */
	public void ajouterCaseValideCarte() {
		this.carte[this.positionX][this.positionY] = true;
	}

	/**
	 * Ajoute la case courante comme case impossible dans la carte
	 */
	public void ajouterCaseImpossibleCarte(int x, int y) {
		this.carte[x][y] = false;
	}
}
