# bataille
package Modele;

import java.util.Observable;


public class Grille extends Observable {
	
	public Case[][] cases;
	private int taillegrille=10;
	private Resultat resultat;
	private boolean positionnementOK=false;
	
	
	
	/*
	 * Constructeur par défaut d'une grille vide
	 */
	
	
	public Grille () {
		this.cases= new Case[10][10];
		for (int i=0; i<10; i++)
			for(int j=0; j<10; j++) {				
				this.cases[i][j]= new Case(); 				
			}
	}
	
	
	public Case[][] getCases(){
		return this.cases;
	}
	
	public void setCases(Case[][] cases){
		this.cases = cases;
	}
	
	
	
	/*
	 * Positionner un navire dans la grille
	 */
	
	
	
	public boolean positionnerNavire(Navire navire, Position position, Orientation orientation){	
		
		// Positionnement Verticale	
		
		if(orientation == Orientation.verticale){			
			//Vérifier si on le navire ne dépasse pas la limite de la grille
			
			if(position.getY() + navire.getTaille()>this.gettaillegrille()){
				System.out.println("Erreur, navire dépasse la limite de la grille verticale");
				return false;
			}
			
			//Vérifier s'il n'y a pas de collision avec un autre navire	
			
			for(int i=0; i < navire.getTaille();i++) {
				if(this.cases[position.getX()][position.getY()+i].isRempli() == true) {
					System.out.println("Erreur, collision Verticale");
					return false;					
				}
			}
			
			//Placer le navire	
			
			for(int i=0; i < navire.getTaille();i++){	
				
				this.cases[position.getX()][position.getY()+i].setNavrie(navire);
				this.cases[position.getX()][position.getY()+i].setRempli(true);	
				this.cases[position.getX()][position.getY()+i].setPosition(new Position(position.getX(),position.getY()+i));
				navire.setPosition(new Position(position.getX(),position.getY()+i));
				navire.setOrientation(orientation);
				
				System.out.println("je suis le "+navire.getNom()+" placé "+orientation+" a la position "+navire.getPosition().get(i).getX()+" et "+navire.getPosition().get(i).getY());
				
			}
			
		}
		//Positionnement Vérticale

		if(orientation == Orientation.horizontale ){	
			
			//vérifier si le navire ne dépasse pas la limite de la grille
			
			if(position.getX() + navire.getTaille()>gettaillegrille()){
				System.out.println("Erreur, le navire dépasse la limite de la grille Horizontale");
				return false;
			}
			
			//Vérifier s'il n y'a pas de collision avec un autre navire	
			
			for(int i=0; i < navire.getTaille();i++) {
				if(this.cases[position.getX()+i][position.getY()].isRempli() == true) {
					System.out.println("Erreur, collision horizontale");
					return false;
				}
			}
			
			// Placer le navire
			
			for(int i=0; i < navire.getTaille();i++){
				
				this.cases[position.getX()+i][position.getY()].setRempli(true);	
				this.cases[position.getX()+i][position.getY()].setNavrie(navire);
				this.cases[position.getX()+i][position.getY()].setPosition(new Position(position.getX()+i,position.getY()));
				navire.setOrientation(orientation);
				navire.setPosition(new Position(position.getX()+i,position.getY()));
				System.out.println("je suis le "+navire.getNom()+" placé "+orientation+" a la position "+navire.getPosition().get(i).getX()+" et "+navire.getPosition().get(i).getY());
			
			}
			
		}
		this.NotifyObserver();
		
		return true;
		
	}
	
	
	public Resultat recevoireTire(Position positiontir ,Joueur joueur){
		
		Case ca =  this.cases[positiontir.getX()][positiontir.getY()];
		
		System.out.println(joueur.getNom()+" a tiré sur la case ");
	 // dabords verifier si ce n est pas deja touché
		if(!ca.isTouchee()) {
			ca.setTouchee(true);
			
		   if(!ca.isRempli()){
			   System.out.println(joueur.getNom()+" a raté son tire");
			   
			   ca.setResultat(Resultat.dans_l_eau);
			   //System.out.println("LA CIBLE LA PLUS PROCHE EST A "+MissionRadar(positiontir, joueur));
			   
			   this.NotifyObserver();
			   return Resultat.dans_l_eau;
			
		   }else
			//trouve quel bateau du joueur a ete touche
			   for(int i=0; i<joueur.getFlote().size();i++){
				   for(int j=0; j<joueur.getFlote().get(i).getPosition().size();j++){
					   
					   if(joueur.getFlote().get(i).getPosition().get(j).getX()==positiontir.getX() && joueur.getFlote().get(i).getPosition().get(j).getY()==positiontir.getY()){
					 
						   joueur.getFlote().get(i).touche();
						   ca.setResultat(Resultat.touche);
						   this.NotifyObserver();
						   
						   if (joueur.getFlote().get(i).estCoule()){
					    
							   joueur.getFlote().remove(joueur.getFlote().get(i));					    	 
							   ca.setResultat(Resultat.coule);					    	
							   return Resultat.coule;
						   }else
							   return Resultat.touche;
					   }
				   }	
			   }
		}
		
		return null;
	}
	
	
	public int MissionRadar(Position positionTir , Joueur joueur){
		
		int resultat =0, cibleproche=0;
		Position positionTir2 =positionTir;
		Case cas= new Case();
		
		for(int i=0; i<this.gettaillegrille();i++){
			for(int j=0; j<this.gettaillegrille();j++){
				
				cas= this.cases[i][j];
				if( cas.isRempli() && !cas.isTouchee() && !cas.getPosition().equals(positionTir2)){
					
					if( resultat ==0 && cibleproche==0){
						resultat = this.CalculeDistance(cas.getPosition(), positionTir2);
					    cibleproche=resultat;
					}else{
						resultat=this.CalculeDistance(cas.getPosition(), positionTir2);
					}
					if( cibleproche > resultat){
						cibleproche = resultat;	
					}
				}
			}
			
		}
		return cibleproche;
	}
	
	public int gettaillegrille() {
		
		return taillegrille;
	}
	
	
	public void NotifyObserver() {
		
		setChanged();
		notifyObservers();
		
	}
	
	public void setPositionementOk(boolean reponse){
		this.positionnementOK= reponse;
	}
	public boolean getEsPositionementOk(){
	
		return this.positionnementOK;
	}
	
	
	
	// méthode pour calculer la distance entre deux positon donnée {
	
	public int CalculeDistance(Position pos1, Position positiontir){
		
		int X = (int) Math.pow((pos1.getX()-positiontir.getX()), 2);
		int Y= (int) Math.pow((pos1.getY()- positiontir.getY()), 2);
		
		int somme= X+Y;
		
		return  (int) Math.sqrt(somme);
		
		
	}
	
	
	
	
	
}

