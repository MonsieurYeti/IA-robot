package service;

import java.Coordonnees;
import java.Robot;

public interface RobotService {

	public Coordonnees renvoyerPositionRobot(Robot robot);

	public void augmenterX(Coordonnees robot);

	public void diminuerX(Coordonnees robot);

	public void augmenterY(Coordonnees robot);

	public void diminuerY(Coordonnees robot);

}
