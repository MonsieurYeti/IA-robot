package Robot;

import Environnement.Environnement;

/**
 * @author ggaillard
 *
 */
public class Execution {

	/**
	 * Fonction main pour le robot
	 */
	public static void main(String[] args) {

		// On instancie le robot et l'environnement
		Environnement environnement = new Environnement();
		Robot robot = new Robot(0, 0);

		// ---------On peut mettre la suite dans un while(true)---------

		// On affiche la position de d�part
		robot.afficherPosition();

		// On recule de 1 selon X et on affiche la position
		if(environnement.testerCasePossible(robot.positionX-1, robot.positionY)){
			robot.reculerX();			
		}
		robot.afficherPosition();

		// On recule de 1 selon Y et on affiche la position
		if(environnement.testerCasePossible(robot.positionX, robot.positionY-1)){
			robot.reculerY();		
		}
		robot.afficherPosition();

		// On avance de 1 selon X et on affiche la position
		if(environnement.testerCasePossible(robot.positionX+1, robot.positionY)){
			robot.avancerX();			
		}
		robot.afficherPosition();

		// On avance de 1 selon Y et on affiche la position
		if(environnement.testerCasePossible(robot.positionX, robot.positionY+1)){
			robot.avancerY();			
		}
		robot.afficherPosition();

	}
}
