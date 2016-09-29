package services;
import entites.Robot;

/**
 * @author ggaillard
 *
 */
public interface RobotService {

	public int donnerPositionX(Robot robot);

	public int donnerPositionY(Robot robot);

	public void augmenterX(Robot robot);

	public void diminuerX(Robot robot);

	public void augmenterY(Robot robot);

	public void diminuerY(Robot robot);

}
