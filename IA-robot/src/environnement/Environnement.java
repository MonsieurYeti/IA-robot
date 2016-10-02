package environnement;

import robot.Robot;

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

		// On crée les cases de l'environnement (null : la case n'existe pas)
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
	 * Méthodes
	 */

	/**
	 * Teste s'il y a de la poussière sur la case demandée
	 * 
	 * @param x
	 * @param y
	 * @return true si il y a de la poussière, false sinon
	 */
	public boolean testerPoussiereCase(Robot robot) {
		if (cases[robot.positionX][robot.positionY].poussiere) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Teste s'il y a u bijou sur la case demandée
	 * 
	 * @param x
	 * @param y
	 * @return true si il y a un bijou, false sinon
	 */
	public boolean testerBijouCase(Robot robot) {
		if (cases[robot.positionX][robot.positionY].bijou) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Teste si la case demandée existe
	 * 
	 * @param robot
	 * @return true si la case existe, false sinon
	 */
	public boolean testerCaseSuivante(Robot robot) {
		switch (robot.orientation) {
		case N:
			return testerCasePossible(robot.positionX, robot.positionY - 1);
		case E:
			return testerCasePossible(robot.positionX + 1, robot.positionY);
		case S:
			return testerCasePossible(robot.positionX, robot.positionY + 1);
		case O:
			return testerCasePossible(robot.positionX - 1, robot.positionY);
		default:
			System.out.println("testerCasSuivante ne va pas");
			return false;
		}
	}

	/**
	 * Teste si la case demandée existe
	 * 
	 * @param robot
	 * @return true si la case existe, false sinon
	 */
	public boolean testerCaseADroite(Robot robot) {
		switch (robot.orientation) {
		case N:
			return testerCasePossible(robot.positionX + 1, robot.positionY);
		case E:
			return testerCasePossible(robot.positionX, robot.positionY + 1);
		case S:
			return testerCasePossible(robot.positionX - 1, robot.positionY);
		case O:
			return testerCasePossible(robot.positionX, robot.positionY - 1);
		default:
			System.out.println("testerCasSuivante ne va pas");
			return false;
		}
	}

	/**
	 * Teste si la case demandée existe
	 * 
	 * @param robot
	 * @return true si la case existe, false sinon
	 */
	public boolean testerCaseAGauche(Robot robot) {
		switch (robot.orientation) {
		case N:
			return testerCasePossible(robot.positionX - 1, robot.positionY);
		case E:
			return testerCasePossible(robot.positionX, robot.positionY - 1);
		case S:
			return testerCasePossible(robot.positionX + 1, robot.positionY);
		case O:
			return testerCasePossible(robot.positionX, robot.positionY + 1);
		default:
			System.out.println("testerCasSuivante ne va pas");
			return false;
		}
	}

	/**
	 * Ajoute de la poussière à la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public synchronized void ajouterPoussiere(int x, int y) {
		cases[x][y].poussiere = true;
	}
	
	/**
	 * Enlève la poussière à la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public synchronized void aspirerPoussiere(int x, int y) {
		cases[x][y].poussiere = false;
	}

	/**
	 * Ajoute un bijou à la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public synchronized void ajouterBijou(int x, int y) {
		cases[x][y].bijou = true;
	}
	
	/**
	 * Enlève un bijou à la case voulue
	 * 
	 * @param x
	 * @param y
	 */
	public synchronized void enleverBijou(int x, int y) {
		cases[x][y].bijou = false;
	}

	/**
	 * Teste si la case passée en paramètre est possible
	 * 
	 * @param x
	 * @param y
	 * @return true si la case demandée est possible, false sinon
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
}
