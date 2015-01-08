package Vues;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;

public class Panneau_Joueur extends JPanel {
	
	
	private Terrain_Jeu terrain;
	
	private Flote flote;
	
	private Controleur controleur;

	private Joueur joueur;
	
	private JLabel montour = new JLabel("coucou");
	
	public Panneau_Joueur(Controleur cont, Joueur j) {
		
		controleur = cont;
		joueur = j;
		terrain= new Terrain_Jeu(controleur, j);
		flote = new Flote(controleur, j);
    	
		this.setLayout(null);	
		this.setBounds(0, 0, 405, 405);
		this.setBackground(Color.cyan);
		
		this.terrain.setBounds(20, 280, 405, 405);
		this.flote.setBounds(15, 30, 420, 230);
		
		montour.setBackground(Color.yellow);
		montour.setBounds(300,90,200,15);
	    	
		
	   	this.add(montour);
		this.add(terrain);
		this.add(flote);
		
	}

	public Terrain_Jeu getTerrainJeu(){
		return this.terrain;
	}
	
	public Flote getFlote(){
		return this.flote;
	}
	
	public JLabel getMontour(){
			return this.montour;
		}
		
	
}
