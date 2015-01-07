package Modele;


import java.util.LinkedList;
import java.util.List;
import java.util.Observable;



public class Navire  extends Observable {
	
	private  String nom;
	private int taille;
	
	private LinkedList<Position> position;
	
	private int nbtouche = 0;
	private Orientation orientation;
	
	
	public Navire(){
		
		this.nom=null;
		this.taille=0;
		this.position=null;
	}
	
	public Navire(String nom1 ,int taille1){
		nom=nom1;
		taille=taille1;
		position= new LinkedList<Position>();
		
	}

	
	public boolean estCoule(){
		
		if(this.getTaille() == this.getNbtouche()) {
			System.out.println(this.getNom()+ " est coulé");
			setChanged();
			notifyObservers();
			return true;
		}
		else
			return false;
	}

	public void touche(){
		this.nbtouche++;
	}
	
	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(Position position1) {
		
			this.position.add(position1);
			setChanged();
			notifyObservers();
	}

	public int getNbtouche() {
		return nbtouche;
	}

	
	public void setOrientation(Orientation sens) {
		
		this.orientation=sens;
		
	}
	
	public Orientation getOrientation() {
		
	return	this.orientation;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	
}
