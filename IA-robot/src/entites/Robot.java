package entites;

public class Robot {

	private Coordonnees coordonnees;

	/*
	 * Constructeurs
	 */

	/**
	 * Constructeur vide du robot
	 */
	public Robot() {
	}

	/**
	 * Constructeur avec coordonnees du robot
	 * 
	 * @param x
	 * @param y
	 */
	public Robot(Coordonnees position) {
		this.coordonnees = position;
	}

	/*
	 * Getters et setters
	 */

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

}
