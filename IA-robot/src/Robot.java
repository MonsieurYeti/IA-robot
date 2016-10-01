

/**
 * @author ggaillard
 *
 */
public class Robot {

	private int positionX;
	private int positionY;

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
	public void afficherPosition () {
		System.out.println("X : "+this.positionX+", Y : "+this.positionY);
	}
	
	/**
	 * Avance le robot suivant X du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void avancerX (int nombreDeCases) {
		this.positionX+=nombreDeCases;
	}
	
	/**
	 * Recule le robot suivant X du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void reculerX (int nombreDeCases) {
		this.positionX-=nombreDeCases;
	}
	
	/**
	 * Avance le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void avancerY (int nombreDeCases) {
		this.positionY+=nombreDeCases;
	}
	
	/**
	 * Recule le robot suivant Y du nombre de cases voulu
	 * 
	 * @param nombreDeCases
	 */
	public void reculerY (int nombreDeCases) {
		this.positionY-=nombreDeCases;
	}
	
	/*
	 * Getters et setters
	 */

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
