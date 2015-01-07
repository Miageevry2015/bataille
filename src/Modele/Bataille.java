package Modele;


import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

public class Bataille extends Observable{

	
	
	
	protected String nom;
	protected ModeJeu modeJeu;
	protected Joueur[] joueurs = new Joueur[2];
	Joueur joueurgagnant;
	protected Grille[] grilles= new Grille[2];
	int nb1=0;
	int nb2=0;
	
    private Random rand = new Random();
	Resultat toucher;
	
    
	public Bataille(Joueur j1, Joueur j2){
		joueurs[0]= j1;
		joueurs[1]= j2;
				
	}
	
	public void PlacementNavireAuto(Joueur j, List<Navire> flote) {	
		
		Orientation  sens = null;
        //On positionne chacun des bateaux aléatoirement
		for (int i =0 ; i<flote.size();i++){
			
    	   //Navire navire=flote.get(i);
			           boolean malplace ;
                       Position placement = null;
                       
                       boolean orien=  rand.nextBoolean(); 
                       
                       if (orien){sens=Orientation.horizontale;}else if(!orien){sens=Orientation.verticale;}
               do
                {
                	
                    placement = new Position(rand.nextInt(10),rand.nextInt(10));
                    
                    malplace = j.getGrille().positionnerNavire(flote.get(i) , placement, sens);
                    
                   
                }while(!malplace);    
     }	
      
	}
	
	// mode demo 
	public void CommenerJeu_modedemo()  {
		
		
		
		while(joueurs[0].getFlote().size()!=0 && joueurs[1].getFlote().size()!=0) {
			
			do  {
				
				System.out.println(this.joueurs[0].getNom()+"  est entrain de jouer");
				Position tire=new Position(rand.nextInt(10), rand.nextInt(10));
				joueurs[0].setMonTir(tire);
				toucher=joueurs[1].getGrille().recevoireTire(joueurs[0].jouer(),joueurs[1]);
				if( toucher == Resultat.touche) {
					nb1++;
					
				}
				
			}while(toucher != Resultat.dans_l_eau && toucher!=null );
			
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		  do  {
				
			  System.out.println(this.joueurs[1].getNom()+"  a jouer");
				Position tire=new Position(rand.nextInt(10), rand.nextInt(10));
				this.joueurs[1].setMonTir(tire);
				  toucher=joueurs[0].getGrille().recevoireTire(joueurs[1].jouer(),joueurs[0]);
				  if( toucher == Resultat.touche) {
					  nb2++;
						System.out.println(this.joueurs[1].getNom()+"  a toucher l'ennemi");
					}
				  
				  
			}while(toucher != Resultat.dans_l_eau && toucher!= null);	
		}
	
		ResultatBataille(joueurs[0], joueurs[1]);
	}
	
	
	public Resultat joueurjoue(Position positionTir, Joueur joueur) {
		
		toucher=joueur.getGrille().recevoireTire(positionTir, joueur);	
		return toucher;
		
		
	}
	
	public int MissionRadar(Position PositionTir, Joueur joueur){
		return joueur.getGrille().MissionRadar(PositionTir, joueur);
	}
	
	//Résultat final de la bataille
	
	public void ResultatBataille(Joueur j1 , Joueur j2){
		
			System.out.println("Joueur ("+j1.getNom()+ ") : Nombre de navires restants " +j1.getFlote().size());
		System.out.println("Joueur ("+j2.getNom()+ ") : Nombre de navires restants " +j2.getFlote().size());
		if(j1.getFlote().size() > j2.getFlote().size()){
			System.out.println(j1.getNom() +" est le gagnant");
			joueurgagnant=j1;
			this.NotifyObserver();
		}
		else{
			System.out.println(j2.getNom() +" est le gagnant");
			joueurgagnant=j2;
			this.NotifyObserver();
		}
		
		
	}
	
	
	
	public Joueur getJoueur1(){
		return this.joueurs[0];
	}
	
	public Joueur getJoueur2(){
		return this.joueurs[1];
	}
	
	public void setModeJeu(ModeJeu modejeu) {
		
		this.modeJeu= modejeu;
	}
	
	 public Joueur getGagnant(){
		return this.joueurgagnant;
	 }
	 

		public void NotifyObserver() {
			
			setChanged();
			notifyObservers();
			
		}
	 
}
