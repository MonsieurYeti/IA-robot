package robot;

import environnement.Environnement;
import environnement.ThreadEnvironnement;

/**
 * @author ggaillard
 *
 */
public class Execution {

	public static void main(String[] args) {

		// On instancie le robot et l'environnement
		int departPositionX = 0;
		int departPositionY = 2;
		Orientation orientation = Orientation.N;

		Environnement environnement = new Environnement();
		Robot robot = new Robot(departPositionX, departPositionY, orientation);
		// Le timer est dans la méthode "avancer" du robot, en millisecondes

		// Création des threads
		Thread threadRobot = new Thread(new ThreadRobot(robot, environnement));
		Thread threadEnvironnement = new Thread(new ThreadEnvironnement(environnement));

		// Démarrage des threads
		threadRobot.start();
		// threadEnvironnement.start();

		// Tant que les threads sont en cours on attend
		while (threadRobot.isAlive())
			;

		// Affiche la map
		for (int y = 0; y < 12; y++) {
			System.out.println(robot.carte[0][y] + " " + robot.carte[1][y] + " " + robot.carte[2][y] + " "
					+ robot.carte[3][y] + " " + robot.carte[4][y] + " " + robot.carte[5][y] + " " + robot.carte[6][y]
					+ " " + robot.carte[7][y] + " " + robot.carte[8][y] + " " + robot.carte[9][y] + " "
					+ robot.carte[10][y] + " " + robot.carte[11][y]);
		}
	}
}
