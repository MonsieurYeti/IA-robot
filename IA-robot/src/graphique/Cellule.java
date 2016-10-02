package graphique;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Cellule extends JPanel {

	/**
	 * 
	 */
	private int positionX;
	private int positionY;
	private boolean diamons;
	private boolean dirt;
	
	private int centreX,centreY;
	
	private static final long serialVersionUID = 2L;

	public void drawCelule(Graphics g,int i, int j, int taille){
		g.drawRect(200+(50*i),300+(50*j) ,taille,taille);
		this.centreX=200+(50*i)+taille/2;
		this.centreY=300+(50*j)+taille/2;
	}
	
	public void drawnCentre(Graphics g){
		g.drawRect(centreX,centreY ,2,2);
	}
	
	/**
	 * position de la cellule sur la grille
	 * @param p
	 */
	public void setPositionX(int p){
		this.positionX=p;
	}
	public void setPositionY(int p){
		this.positionY=p;
	}
	
	public void Position(int x, int y){
		setPositionX(x);setPositionY(y);
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public void setDiamons(boolean d){
		this.diamons=d;
	}
	
	public void setDirt(boolean d){
		this.dirt=d;
	}
	
	public boolean getDiamons(){
		return diamons;
	}
	
	public boolean getDirt(){
		return dirt;
	}
	
	      
}
