package java;

public class Robot {

	private Coordonnees coordonnees;

	/*
	 * Constructeurs
	 */

	public Robot(int x, int y) {
		this.coordonnees.setPositionX(x);
		this.coordonnees.setPositionY(y);
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
