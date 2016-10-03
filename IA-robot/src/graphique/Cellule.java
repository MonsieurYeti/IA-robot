package graphique;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Cellule extends JPanel {

	/**
	 * 
	 */
	protected int positionX;
	protected int positionY;
	protected int positionAbsolueX;
	protected int positionAbsolueY;
	protected boolean diamons;
	protected boolean dirt;
	protected int taille;
	protected int hauteurFenetre;
	protected int largueurFenetre;
	
	private int centreX,centreY;
	
	private static final long serialVersionUID = 2L;
	
	public Cellule (int largueur, int hauteur, int taille){
		this.hauteurFenetre = hauteur;
		this.largueurFenetre=largueur;
		this.taille=taille;
	}

	public void drawCelule(Graphics g,int i, int j){
		
		this.positionAbsolueX=largueurFenetre+(taille*i);
		this.positionAbsolueY=hauteurFenetre+(taille*j);
		g.drawRect(positionAbsolueX,positionAbsolueY,taille,taille);
		this.centreX=largueurFenetre+(taille*i)+taille/2;
		this.centreY=hauteurFenetre+(taille*j)+taille/2;
		
		
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
	
	public int getPositionAbsolueX(){
		return positionAbsolueX;
	}
	
	public int getPositionAbsolueY(){
		return positionAbsolueY;
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
	
	public int getTaille(){
		return taille;
	}
	      
}
