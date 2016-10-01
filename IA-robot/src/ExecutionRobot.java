
/**
 * @author ggaillard
 *
 */
public class ExecutionRobot {

	/**
	 * Fonction main pour le robot
	 */
	public static void main(String[] args) {

		// On instancie le robot

		Robot robot = new Robot(3, 3);

		// ---------On peut mettre la suite dans un while(true)---------

		// On affiche la position de d�part
		robot.afficherPosition();

		// On avance de 1 selon X et on affiche la position
		robot.avancerX(1);
		robot.afficherPosition();

		// On avance de 1 selon Y et on affiche la position
		robot.reculerX(1);
		robot.afficherPosition();

		// On recule de 1 selon X et on affiche la position
		robot.avancerY(1);
		robot.afficherPosition();

		// On recule de 1 selon Y et on affiche la position
		robot.reculerY(1);
		robot.afficherPosition();

	}
}
