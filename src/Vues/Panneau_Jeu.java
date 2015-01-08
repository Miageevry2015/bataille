package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;

public class Panneau_Jeu extends JPanel{

	
	
	private Panneau_Joueur panneaujoueur1,panneaujoueur2;

	private Controleur controleur;
	
	private JButton Débuter = new JButton("Débuter");
	
	private JButton Retour = new JButton("Retour");
	
	
	
    public Panneau_Jeu(Controleur cont ) {
    	
    	controleur= cont;
    	panneaujoueur1= new Panneau_Joueur(controleur, controleur.getJoueur1());
    	panneaujoueur2= new Panneau_Joueur(controleur, controleur.getJoueur2());
    	
    	
    	this.setLayout(null);
    	this.setBackground(Color.blue);
    	
    	Débuter.setBounds(380, 5, 160, 15);
    	Débuter.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ae) {
    	    		
    			controleur.commencerAjouer();
    	}});
    	
    	Retour.setBounds(380, 22, 160, 15);
  
    	Retour.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent ac){
    			
    			controleur.SetNewPartie();
    		}
    	});
    	
    
    	
    	panneaujoueur1.setBounds(5, 5, 450, 695);
    	panneaujoueur2.setBounds(470, 5, 450, 695);
     	this.add(Débuter);
    	this.add(Retour);
    	this.add(panneaujoueur1);
    	this.add(panneaujoueur2);
    	
    	
    	
    }
		
	 		public Panneau_Joueur getPanneaujoueur1(){
	 			return this.panneaujoueur1;
	 		}

	 		public Panneau_Joueur getPanneaujoueur2(){
	 			return this.panneaujoueur2;
	 		}
	 			
	 		
	 		public JButton getDebuter(){
	 			return this.Débuter;
	 		}
	 		

	 		public JButton getRetour(){
	 			return this.Retour;
	 		}
	 		
	 		
	 		
	 		
	 		
}
