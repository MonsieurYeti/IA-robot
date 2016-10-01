package Environnement;

/**
 * @author ggaillard
 *
 */
public class Environnement {

	public Case[][] cases = new Case[5][3];

	/*
	 * Constructeurs
	 */

	public Environnement() {

		// On cr�e les cases de l'environnement (null : la case n'existe pas)
		cases[0][0] = new Case(0, 0);
		cases[1][0] = new Case(0, 1);
		cases[2][0] = new Case(0, 2);
		cases[3][0] = null;
		cases[4][0] = null;

		cases[0][1] = new Case(1, 0);
		cases[1][1] = new Case(1, 1);
		cases[2][1] = new Case(1, 2);
		cases[3][1] = new Case(1, 3);
		cases[4][1] = new Case(1, 4);

		cases[0][2] = new Case(2, 0);
		cases[1][2] = new Case(2, 1);
		cases[2][2] = new Case(2, 2);
		cases[3][2] = null;
		cases[4][2] = null;
	}

	/*
	 * M�thodes
	 */

	/**
	 * Teste s'il y a de la poussi�re sur la case demand�e
	 * 
	 * @param x
	 * @param y
	 * @return true si il y a de la poussi�re, false sinon
	 */
	public boolean testerPoussiereCase(int x, int y) {
		if (cases[x][y].poussiere) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Teste s'il y a u bijou sur la case demand�e
	 * 
	 * @param x
	 * @param y
	 * @return true si il y a un bijou, false sinon
	 */
	public boolean testerBijouCase(int x, int y) {
		if (cases[x][y].bijou) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Teste si la case demand�e existe
	 * 
	 * @param x
	 * @param y
	 * @return true si la case existe, false sinon
	 */
	public boolean testerCasePossible(int x, int y) {
		if (x < 0 || x > 4 || y < 0 || y > 2) {
			return false;
		} else {
			if (cases[x][y] != null) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Ajoute de la poussi�re � la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public void ajouterPoussiere(int x, int y) {
		cases[x][y].poussiere = true;
	}

	/**
	 * Ajoute un bijou � la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public void ajouterBijou(int x, int y) {
		cases[x][y].bijou = true;
	}
}
