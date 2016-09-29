package entites;


/**
 * @author ggaillard
 *
 */
public class Coordonnees {

	private int positionX;
	private int positionY;

	/*
	 * Constructeurs
	 */

	/**
	 * Constructeur simple des coordonnees
	 * 
	 * @param x
	 * @param y
	 */
	public Coordonnees(int x, int y) {
		this.positionX = x;
		this.positionY = y;
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
