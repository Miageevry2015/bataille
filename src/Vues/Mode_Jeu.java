package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ModeJeu;



public class Mode_Jeu extends JPanel 	implements ActionListener{

	
	
	private JLabel label;
	private JButton modebataillenavale,moderadar, modeOpérationArtillerie,modeAlerteRouge, retour;
	
	private Controleur controleur;
	
	private Panneau_Jeu panneau_Jeu; 
	public Mode_Jeu(Controleur con) {
	
	this.controleur=con;
		
	this.setBackground(Color.cyan);
	this.setLayout(null);
	
	label= new JLabel("Choisissez un mode de jeu");
	modebataillenavale= new JButton("Bataille Navale");
	moderadar= new JButton("Radar");
	modeOpérationArtillerie= new JButton("Opération Artillerie");
	modeAlerteRouge= new JButton("Alerte Rouge");
	retour=new JButton("Retour");
	
	this.label.setBounds(20, 5, 300, 20);
	this.modebataillenavale.setBounds(20, 30, 250, 20);
	this.moderadar.setBounds(20, 50, 250, 20);
	this.modeOpérationArtillerie.setBounds(20, 70, 250, 20);
	this.modeAlerteRouge.setBounds(20, 90, 250, 20);
	this.retour.setBounds(20, 110, 250, 15);
	
	
	
	
	this.add(label);
	this.add(modebataillenavale);
	this.add(moderadar);
	this.add(modeOpérationArtillerie);
	this.add(modeAlerteRouge);
	this.add(retour);
	
	
	
	this.retour.addActionListener(this);
	this.modebataillenavale.addActionListener(this);
	this.moderadar.addActionListener(this);
	this.modeOpérationArtillerie.addActionListener(this);
	this.modeAlerteRouge.addActionListener(this);
	
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if( event.getSource()== modebataillenavale){
			if( this.controleur.getModeJeu()== ModeJeu.ModeUnJoueur){
				
				controleur.mode1joueur();
				controleur.setTypebataille(TypeBataille.BatailleNavale);
				
				panneau_Jeu= new Panneau_Jeu(controleur);
				panneau_Jeu.getPanneaujoueur2().getFlote().remove_listener();
				panneau_Jeu.getPanneaujoueur2().getTerrainJeu().remove_listener();
				panneau_Jeu.getPanneaujoueur1().getFlote().Ajouter_Button();
				panneau_Jeu.getDebuter().setVisible(false);
				this.controleur.getBataille().addObserver(this.controleur.getFram());
				this.controleur.getFram().setBounds(0, 0, 950, 750);
				this.controleur.getFram().changerpanel(panneau_Jeu);
				
			}else if (this.controleur.getModeJeu()== ModeJeu.ModeDeuxJoueurs){
				controleur.setTypebataille(TypeBataille.BatailleNavale);
				controleur.mode2joueur();
				panneau_Jeu= new Panneau_Jeu(controleur);
				panneau_Jeu.getPanneaujoueur1().getFlote().Ajouter_Button();
				panneau_Jeu.getPanneaujoueur2().getFlote().Ajouter_Button();
				panneau_Jeu.getDebuter().setVisible(false);
				
				this.controleur.getBataille().addObserver(this.controleur.getFram());
				this.controleur.getFram().setBounds(0, 0, 950, 750);
				this.controleur.getFram().changerpanel(panneau_Jeu);
						
			}
	
			
		}else if (event.getSource()== moderadar){
			

			if( this.controleur.getModeJeu()== ModeJeu.ModeUnJoueur){
				
				controleur.mode1joueur();
				controleur.setTypebataille(TypeBataille.Radar);
				
				panneau_Jeu= new Panneau_Jeu(controleur);
				panneau_Jeu.getPanneaujoueur2().getFlote().remove_listener();
				panneau_Jeu.getPanneaujoueur2().getTerrainJeu().remove_listener();
				panneau_Jeu.getPanneaujoueur1().getFlote().Ajouter_Button();
				panneau_Jeu.getDebuter().setVisible(false);
				this.controleur.getBataille().addObserver(this.controleur.getFram());
				this.controleur.getFram().setBounds(0, 0, 950, 750);
				this.controleur.getFram().changerpanel(panneau_Jeu);
				
			}else if (this.controleur.getModeJeu()== ModeJeu.ModeDeuxJoueurs){
				
				controleur.setTypebataille(TypeBataille.Radar);
				controleur.mode2joueur();
				panneau_Jeu= new Panneau_Jeu(controleur);
				panneau_Jeu.getPanneaujoueur1().getFlote().Ajouter_Button();
				panneau_Jeu.getPanneaujoueur2().getFlote().Ajouter_Button();
				panneau_Jeu.getDebuter().setVisible(false);
				
				this.controleur.getBataille().addObserver(this.controleur.getFram());
				this.controleur.getFram().setBounds(0, 0, 950, 750);
				this.controleur.getFram().changerpanel(panneau_Jeu);
				
				
			}
			
		}else if( event.getSource()== modeOpérationArtillerie){
			
		}else if(event.getSource()== modeAlerteRouge){
			
		}
		
	}
	
	
	public Panneau_Jeu getPanneau_Jeu() {
		if( this.panneau_Jeu==null) System.out.println("je suis null");
		return this.panneau_Jeu;
	}


}
