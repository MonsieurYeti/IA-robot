package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageRobot {
	
	public BufferedImage image;
	private double tailleCellule;
	
	ImageRobot(double taille){
		this.tailleCellule=taille;
	}
	
	public void ImagePanel(String name,double d) throws IOException {
		//irobot.png
		//0.43
		image = ImageIO.read(new File("/Users/remymaillot/Documents/workspace_eclipse/IA-robot/src/graphique/"+name));
		BufferedImage imagnew=scale(image, d);
        ImageIO.write(imagnew, "jpeg", new File("/Users/remymaillot/Documents/workspace_eclipse/IA-robot/src/graphique/petit_"+name+".jpeg"));
        image = ImageIO.read(new File("/Users/remymaillot/Documents/workspace_eclipse/IA-robot/src/graphique/petit_"+name+".jpeg"));
		}
	
	
	
	public static BufferedImage scale(BufferedImage bImage, double d) {
        //int destWidth=(int) (bImage.getWidth() * factor);
		int destWidth=(int) (d);
        int destHeight=(int) (d);
        //créer l'image de destination
        GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
        Graphics2D graphics = bImageNew.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        //dessiner l'image de destination
        graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
        graphics.dispose();
 
        return bImageNew;
    }
	
	public void drawRobot(Graphics g,int x, int y){
		//Chargement image du robot
	    try {
			ImagePanel("irobot.png",tailleCellule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,x,y, null);
		
	  }
	
	public void drawDirt(Graphics g,int x, int y){
		//Chargement image du robot
	    try {
			ImagePanel("saleté.jpeg",tailleCellule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,x,y, null);
	  }
	
	public void drawDiamons(Graphics g,int x, int y){
		//Chargement image du robot
	    try {
			ImagePanel("Diamond.png",tailleCellule/5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image,x,y, null);
	  }
	
	
	public void unDraw(Graphics g,int x, int y,int taille){
		g.setColor(Color.white);
		g.fillRect(x, y, taille, taille);
	  }

}
