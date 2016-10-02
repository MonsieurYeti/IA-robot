package graphique;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

public class Grid extends JPanel {

	/**
	 * 
	 */
	
	private Cellule[][] cell = new Cellule[3][3];
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;

	//==================================================================
	/**
	 * Definition de l'image du robit
	 */
	ImageRobot imgrobot = new ImageRobot();
	
	//==================================================================
	
	public void paintComponent(Graphics g){
		//Génération matrice
	    matrice(g);
	    //Test sur une cellule donnée
	    getCellMatice(1,0);
	    //Création du robot
	    imgrobot.drawRobot(g, cell[1][1].getPositionAbsolueX(), cell[1][1].getPositionAbsolueY());
	    imgrobot.drawDirt(g, cell[1][0].getPositionAbsolueX(), cell[1][0].getPositionAbsolueY());
	    imgrobot.drawDiamons(g, cell[1][0].getPositionAbsolueX(), cell[1][0].getPositionAbsolueY());
	}
	
	public void matrice(Graphics g){
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				this.cell[i][j]=new Cellule();
				this.cell[i][j].Position(i,j);
				this.cell[i][j].drawCelule(g,i,j,50);
				this.cell[i][j].drawnCentre(g);
				
				//g.drawRect(200+(50*i),300+(50*j) ,50,50);
			}
		}
		//Test validé
		//this.cell[1][2].drawnCentre(g);
	}
	
	public void getCellMatice(int i,int j){
		System.out.println("Position x: "+cell[i][j].getPositionX());
		System.out.println("Position y: "+cell[i][j].getPositionY());
		System.out.println("Saleté ?: "+cell[i][j].getDirt());
		System.out.println("Diamons ?: "+cell[i][j].getDiamons());
	}
	      
}
