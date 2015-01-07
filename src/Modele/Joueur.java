package Modele;

import java.util.Iterator;
import java.util.List;

public class Joueur {

	protected String nom;

	protected int nbTires=0; //nombre de tirs réalisés
	protected Position monTir;
	
	protected List<Navire> flote;
	protected Grille mer;
	
	static int i=0;
	
	
	
	
	public Joueur(String nom){
		this.nom = nom;
		
		this.mer = new Grille();
	}
	
	public Joueur(String nom, List<Navire> flote){
		this.nom = nom;
		this.flote = flote;
		this.mer = new Grille();
	}
	
	
	//Méthode qui renvoit les coordonnées du tir du joueur
	public Position jouer(){
		this.nbTires++;
		return this.monTir;
	}
	

	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	
	public int getNbTires() {
		return nbTires;
	}



	public List<Navire> getFlote() {
		return flote;
	}

	public void setFlote(List<Navire> flote) {
		this.flote = flote;
	}

	public Position getMonTir() {
		return monTir;
	}

	public void setMonTir(Position monTir) {
		this.monTir = monTir;
	}

	public Grille getGrille() {
		
		return this.mer;
	}
	
	
	
}