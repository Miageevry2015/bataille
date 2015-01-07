/*package Vues;

import java.awt.Color;

import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;

public class Panneau_Joueur extends JPanel {
	
	
	private Terrain_Jeu terrain;
	
	private Flote flote;
	
	private Controleur controleur;

	private Joueur joueur;
	
	public Panneau_Joueur(Controleur cont, Joueur joueur1) {
		
		controleur = cont;
		joueur = joueur1;
		terrain= new Terrain_Jeu(controleur, joueur);
		flote = new Flote(controleur, joueur);
    	
		this.setLayout(null);	
		this.setBounds(0, 0, 405, 405);
		this.setBackground(Color.cyan);
		
		this.terrain.setBounds(20, 280, 405, 405);
		this.flote.setBounds(15, 30, 420, 230);
		
		this.add(terrain);
		this.add(flote);
		
	}

	public Terrain_Jeu getTerrainJeu(){
		return this.terrain;
	}
	
	public Flote getFlote(){
		return this.flote;
	}
	
	
	
}
*/
