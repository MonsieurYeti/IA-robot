package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame; 
import javax.swing.JPanel; 
 
public class Ecran 
extends JFrame 
{
	ConsoleLog lg; 
	private Grid grille = new Grid();
	// création du conteneur intermédiaire 
	private JPanel containeur = new JPanel(); 
	// création boutons 
    private JButton b1=new JButton("Go");
	
     public Ecran() 
     { 
          setTitle("I.A Robotor by Gaillar_Audegon_Maillot"); 
          setBounds(0,0,800,500); 
          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
          setContentPane(grille);
          
          
          // ajout des boutons sur le conteneur intermédiaire 
          containeur.add(b1); 
          
          //containeur.add(grille);
          // ajout du conteneur sur le ContentPane 
          getContentPane().add(containeur); 
          // création d’une instance de la classe chargée 
          // de gérer les événements 
          EcouteurFenetre ef; 
          ef=new EcouteurFenetre(); 
          // comme écouteur d’événement pour la fenêtre 
          addWindowListener(ef); 
          
          JCheckBox chkLog; 
          chkLog=new JCheckBox("log sur console"); 
          // ajout d’un écouteur à la case à cocher 
          chkLog.addActionListener(new ActionListener() 
          { 
               public void actionPerformed(ActionEvent arg0) 
               { 
                    JCheckBox chk; 
                    chk=(JCheckBox)arg0.getSource(); 
                    if (chk.isSelected()) 
                    { 
                    	// ajout d’un écouteur supplémentaire 
                        // aux boutons et menus 
                        lg=new ConsoleLog(); 
                        b1.addActionListener(lg);
                    } 
                    else 
                    { 
                    	// suppression de l’écouteur supplémentaire 
                        // des boutons et menus 
                    	b1.removeActionListener(lg); 
                    } 

               } 
          });
          containeur.add(chkLog);
     } 

} 