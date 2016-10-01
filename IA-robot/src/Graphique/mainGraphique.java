package Graphique;

public class mainGraphique { 
	 
    public static void main(String[] args) 

    { 
         // création de la fenêtre 
         Ecran fenetre; 
         fenetre=new Ecran(); 
         // création d’une instance de la classe chargée 
         // de gérer les événements 
         EcouteurFenetre ef; 
         ef=new EcouteurFenetre(); 
         // référencement de cette instance de classe 
         // comme écouteur d’événement pour la fenêtre 
         fenetre.addWindowListener(ef); 
         // affichage de la fenêtre 
         fenetre.setVisible(true); 
    } 
}
