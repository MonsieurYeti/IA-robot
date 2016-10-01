
/**
 * @author ggaillard
 *
 */
public class Robot {

	public int positionX;
	public int positionY;

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
	public void avancerX() {
		this.positionX++;
	}

	/**
	 * Recule le robot suivant X du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void reculerX() {
		this.positionX--;
	}

	/**
	 * Avance le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void avancerY() {
		this.positionY++;
	}

	/**
	 * Recule le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void reculerY() {
		this.positionY--;
	}

}
