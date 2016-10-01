package Graphique;

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
 
public class Ecran 
extends JFrame 
{ 
     public Ecran() 
     { 
          setTitle("I.A Robotor by Gaillar_Audegon_Maillot"); 
          setBounds(0,0,800,500); 
          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
          // création des trois boutons 
          JButton b1; 
          b1=new JButton("Go");
          // création du conteneur intermédiaire 
          JPanel pano; 
          pano=new JPanel(); 
          // ajout des boutons sur le conteneur intermédiaire 
          pano.add(b1); 
          // ajout du conteneur sur le ContentPane 
          getContentPane().add(pano); 
     } 
} 