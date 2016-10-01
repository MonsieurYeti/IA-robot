package Graphique;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
 
import javax.swing.AbstractButton; 
import javax.swing.JButton; 
import javax.swing.JMenuItem; 
 
public class ConsoleLog implements ActionListener 
{ 
      public void actionPerformed(ActionEvent e) 
      { 
            String message; 
            SimpleDateFormat sdf; 
            sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
            message=sdf.format(new Date()); 
            message=message + " clic sur le "; 
            if (e.getSource() instanceof JButton) 
            { 
                  message=message+ "bouton "; 
            } 
            if (e.getSource() instanceof JMenuItem) 
            { 
                  message=message+ "menu "; 
            } 
            message=message + ((AbstractButton)e.getSource()).getText(); 
            System.out.println(message); 
      } 
}