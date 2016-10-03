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
	public int tailleCellule;
	public ImageRobot imgrobot; 
	private int cpt =0;
	
	public Grid(int taille,int refresh){
		this.cpt=refresh;
		this.tailleCellule=taille;
		imgrobot = new ImageRobot(tailleCellule);
	}

	//==================================================================
	/**
	 * Definition de l'image du robot
	 */
	
	
	
	//==================================================================
	
	public void paintComponent(Graphics g){
		//Génération matrice
	    matrice(g);
	    System.out.println(tailleCellule);
	    //Test sur une cellule donnée
	    getCellMatice(1,0);
	    //Création du robot
	    imgrobot.drawRobot(g, cell[1][1].getPositionAbsolueX(), cell[1][1].getPositionAbsolueY());
	    
	    
	    
	    //Test
	    addDiamons(g,2,0);
	    addDirt(g,1,0);
	    getCellMatice(1,0);
	    getCellMatice(2,0);
	    removeAll(g,1,0);
	    getCellMatice(1,0);
	    
	    if(cpt<100){
	    	moveRobot(g,cpt);
	    	long start = System.currentTimeMillis();
	    	while ((System.currentTimeMillis() - start) < 50);
	    	cpt++;	    	
	    } else {
	    	moveRobot(g,100);
	    }

  	  
	    
	}
	
	public void matrice(Graphics g){
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				//Nouvelle instance d'une celule
				this.cell[i][j]=new Cellule(this.getWidth()/8,(this.getHeight()-tailleCellule)/2,tailleCellule);
				//Definit la position
				this.cell[i][j].Position(i,j);
				//La dessine 
				this.cell[i][j].drawCelule(g,i,j);
				//Affiche le centre de la cell au cas ou...
				this.cell[i][j].drawnCentre(g);
			}
		}
	}
	
	public void getCellMatice(int i,int j){
		System.out.println("Position x: "+cell[i][j].getPositionX());
		System.out.println("Position y: "+cell[i][j].getPositionY());
		System.out.println("Saleté ?: "+cell[i][j].getDirt());
		System.out.println("Diamons ?: "+cell[i][j].getDiamons());
	}
	
	public void addDiamons(Graphics g,int x,int y){
		imgrobot.drawDiamons(g, cell[x][y].getPositionAbsolueX(), cell[x][y].getPositionAbsolueY());
	    cell[x][y].setDiamons(true);
	}
	public void addDirt(Graphics g,int x,int y){
		imgrobot.drawDirt(g, cell[x][y].getPositionAbsolueX(), cell[x][y].getPositionAbsolueY());
	    cell[x][y].setDiamons(true);
	}
	
	public void removeAll(Graphics g,int x,int y){
		imgrobot.unDraw(g,cell[x][y].getPositionAbsolueX(), cell[x][y].getPositionAbsolueY(),cell[x][y].getTaille());
	    cell[x][y].setDiamons(false);
	    cell[x][y].setDirt(false);
	}
	
	public void moveRobot(Graphics g,int i){
		
		imgrobot.drawRobot(g, cell[0][0].getPositionAbsolueX()+i, cell[0][0].getPositionAbsolueY());
		
	}
	      
}
