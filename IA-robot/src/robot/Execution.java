package robot;

import environnement.Environnement;

/**
 * @author ggaillard
 *
 */
public class Execution {

	public static void main(String[] args) {

		// On instancie le robot et l'environnement
		int departPositionX = 0;
		int departPositionY = 1;
		Orientation orientation = Orientation.N;

		Environnement environnement = new Environnement();
		Robot robot = new Robot(departPositionX, departPositionY, orientation);

		// Création des threads
		Thread threadRobot = new Thread(
				new ThreadRobot(robot, environnement, departPositionX, departPositionY, orientation));

		// Démarrage des threads
		threadRobot.start();

		// Tant que les threads sont en cours on attend
		while (threadRobot.isAlive())
			;

		// Affiche la map
		for (int x = 0; x < 12; x++) {
			System.out.println(robot.carte[x][0] + " " + robot.carte[x][1] + " " + robot.carte[x][2] + " "
					+ robot.carte[x][3] + " " + robot.carte[x][4] + " " + robot.carte[x][5] + " " + robot.carte[x][6]
					+ " " + robot.carte[x][7] + " " + robot.carte[x][8] + " " + robot.carte[x][9] + " "
					+ robot.carte[x][10] + " " + robot.carte[x][11]);
		}
	}
}
