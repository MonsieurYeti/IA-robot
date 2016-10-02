package environnement;

/**
 * @author ggaillard
 *
 */
public class Case {

	public int positionX;
	public int positionY;

	public boolean poussiere;
	public boolean bijou;

	/*
	 * Constructeurs
	 */

	public Case(int x, int y) {
		this.positionX = x;
		this.positionY = y;
		this.poussiere = false;
		this.bijou = false;
	}

	/*
	 * Méthodes
	 */

}
