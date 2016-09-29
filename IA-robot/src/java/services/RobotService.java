package java.services;

import java.entites.Coordonnees;
import java.entites.Robot;

/**
 * @author ggaillard
 *
 */
public interface RobotService {

	public Coordonnees donnerPosition(Robot robot);

	public void augmenterX(Robot robot);

	public void diminuerX(Robot robot);

	public void augmenterY(Robot robot);

	public void diminuerY(Robot robot);

}
