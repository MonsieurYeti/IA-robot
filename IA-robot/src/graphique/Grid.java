package graphique;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Grid extends JPanel {

	/**
	 * 
	 */
	
	private Cellule[][] cell = new Cellule[3][3];
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
	    g.fillRect(65, 65, 30, 40);
	    int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
	    int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
	    g.fillPolygon(x2, y2, 8);
	    matrice(g);
	    getCellMatice(1,0);
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
