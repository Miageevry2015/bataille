package Controleur;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import Modele.Bataille;
import Modele.EtatPartie;
import Modele.Joueur;
import Modele.ModeJeu;
import Modele.Navire;
import Modele.Orientation;
import Modele.Position;
import Modele.Resultat;
import Vues.Fenetre_Principale;
import Vues.TypeBataille;






public class Controleur {
	
	int nbbateaupositioner=0;
	
	Fenetre_Principale vue;
	
	String NomNavire;
	
	Navire navire;
	
	Position position, positionTir;
	
	Orientation orientation = Orientation.verticale;//a defaut c'est Horizontale

	boolean placementOk=false;
	
	boolean bateauContientposition;
	
	boolean bateauChoisi;
	
	ModeJeu modejeu;
	
	TypeBataille tyepbataille ;
	
	private Joueur joueur ;
	
	private Joueur joueur2;
	
	Joueur joueurAtttaqué;
	
	Bataille bataille;

	EtatPartie etatpartie;
	
	Random ran = new Random();
	
	
	//Constructeur 
	
	public Controleur () {
		vue= new Fenetre_Principale(this);
		setEtatPartie(EtatPartie.Debut);
		
	}
	
	// méthode pour dire que c'est tel ou tel mode
	
	public void setModeJeu( ModeJeu modejeu ) {
		this.modejeu= modejeu;
		
	}
	
	
	public ModeJeu getModeJeu(){
		return modejeu;
	}
	
	// initialiser le mode Démo
	
	public void modeDémo() {
		
		List<Navire> flote2 = new LinkedList<Navire>();
		List<Navire> flote = new LinkedList<Navire>();
		 
		flote.add(new Navire(new String ("Zodiac") , (2) ));
		flote.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote.add(new Navire(new String ("porte avion") , (4)));
		flote.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		flote2.add(new Navire(new String ("Zodiac") , (2) ));
		flote2.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote2.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote2.add(new Navire(new String ("porte avion") , (4)));
		flote2.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		this.setJoueur1(new Joueur("Ordinateur 1",flote));
		this.setJoueur2(new Joueur("Ordinateur 2",flote2));
		
		 bataille = new Bataille(joueur, joueur2);
		 
		 bataille.PlacementNavireAuto(joueur, flote);		
		
		 bataille.PlacementNavireAuto(joueur2, flote2);
		
		 this.setEtatPartie(EtatPartie.EnCoursPlacementBateau);
		 
	
	}
	
	public void mode1joueur(){
		
		this.setModeJeu(ModeJeu.ModeUnJoueur);
		
		List<Navire> flote2 = new LinkedList<Navire>();
		List<Navire> flote = new LinkedList<Navire>();
		 
		
		flote.add(new Navire(new String ("Zodiac") , (2) ));
		flote.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote.add(new Navire(new String ("porte avion") , (4)));
		flote.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		flote2.add(new Navire(new String ("Zodiac") , (2) ));
		flote2.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote2.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote2.add(new Navire(new String ("porte avion") , (4)));
		flote2.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		this.setJoueur1(new Joueur("Omar",flote));
		this.setJoueur2(new Joueur("Ordinateur ",flote2));
		
		bataille = new Bataille(joueur, joueur2);
		
		bataille.PlacementNavireAuto(joueur2, flote2);
		
		this.setEtatPartie(EtatPartie.EnCoursPlacementBateau);
		
	}
	
	public void mode2joueur(){
		

		this.setModeJeu(ModeJeu.ModeDeuxJoueurs);
		
		List<Navire> flote2 = new LinkedList<Navire>();
		List<Navire> flote = new LinkedList<Navire>();
		 
		flote.add(new Navire(new String ("Zodiac") , (2) ));
		flote.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote.add(new Navire(new String ("porte avion") , (4)));
		flote.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		flote2.add(new Navire(new String ("Zodiac") , (2) ));
		flote2.add(new Navire(new String ("cuirasse1 furtif") , (3)));
		flote2.add(new Navire(new String ("cuirasse2 furtif") , (3)));
		flote2.add(new Navire(new String ("porte avion") , (4)));
		flote2.add(new Navire(new String ("sous marin nucleaire") , (5)));
		
		this.setJoueur1(new Joueur("Omar",flote));
		this.setJoueur2(new Joueur("youcef",flote2));
		
		bataille = new Bataille(joueur, joueur2);
		this.setEtatPartie(EtatPartie.EnCoursPlacementBateau);
	}

	
	// lancer le jeu 
	public void commencerAjouer(){
		
		this.setEtatPartie(EtatPartie.EncoursDeJeu);
		System.out.println("le jeu a commencer");
		
		if(this.getModeJeu()== ModeJeu.ModeDemo){
			
			this.Jouer_Mode_Demo();
			System.out.println("***********************************mode Demo");
		}
		
		if( this.getModeJeu()==ModeJeu.ModeUnJoueur){
			
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener();
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getTerrainJeu().remove_listener();
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getTerrainJeu().add_Mouse_Listener();
		}
		
		if( this.getModeJeu()==ModeJeu.ModeDeuxJoueurs){
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener();
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener();		
			this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getTerrainJeu().remove_listener();
			
			
		}
			
	}
	
	public void Jouer_Mode_Demo() {

		bataille.CommenerJeu_modedemo();
		
	}
	
	//lancer le jeu en mode un joueur
	
	public void Jouer_Mode_joueur(Position posTir, Joueur joueur){
		
			Resultat resultatAttaque= Resultat.dans_l_eau;
					
			if(this.joueur2.equals(joueur)){
				
				
				resultatAttaque=bataille.joueurjoue(posTir, this.bataille.getJoueur2());
				
					if(resultatAttaque==Resultat.dans_l_eau ){
						
						this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getMontour().setText("Attendre");
						this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getMontour().setText("Attaqué");
						
						if(this.gettypebataille()==TypeBataille.Radar){
							JOptionPane p= new JOptionPane();
							int d= this.bataille.MissionRadar(posTir, joueur);
							
							int x= (int) p.getValue();
								//p.showMessageDialog(this.getFram(), "cible proche à "+d);
							      p.showConfirmDialog(this.getFram(),"cible proche à "+d +x );
							      /**if(x==1){
							    	  
							      }if(x==0){
							    	  
							      }*/
							
							
						}
						
						if(resultatAttaque==Resultat.dans_l_eau && this.getModeJeu()==ModeJeu.ModeDeuxJoueurs){
							this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getTerrainJeu().remove_listener();
							this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getTerrainJeu().add_Mouse_Listener();
							
							
					}
					
				}
			}
			
			if( this.joueur.equals(joueur)){
				
				
				resultatAttaque=this.bataille.joueurjoue(posTir, this.bataille.getJoueur1());
				if(resultatAttaque==Resultat.dans_l_eau && this.getModeJeu()==ModeJeu.ModeDeuxJoueurs){
					
					if(this.gettypebataille()==TypeBataille.Radar && this.getModeJeu()==ModeJeu.ModeDeuxJoueurs){
						JOptionPane p= new JOptionPane();
						int d= this.bataille.MissionRadar(posTir, joueur);
						
						
						
					}
					
					this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getMontour().setText("Attendre");
					this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getMontour().setText("Attaqué");
					this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getTerrainJeu().remove_listener();
					this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getTerrainJeu().add_Mouse_Listener();
				}
				
				
			}
			
			if( this.getModeJeu()== ModeJeu.ModeUnJoueur && resultatAttaque==Resultat.dans_l_eau){
				 do  {
					 
					 
					 System.out.println(this.joueur2.getNom()+"   a tiré ");
					 
						Position tire=new Position(ran.nextInt(10), ran.nextInt(10));
						
						resultatAttaque=this.bataille.getJoueur1().getGrille().recevoireTire(tire,this.bataille.getJoueur1());
					}while(resultatAttaque != Resultat.dans_l_eau && resultatAttaque == null);	
				 this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getMontour().setText("Attendre");
				 this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getMontour().setText("Attaqué");
					
			}
	
			if(this.bataille.getJoueur1().getFlote().size()==0 || this.bataille.getJoueur2().getFlote().size()==0)
				this.bataille.ResultatBataille(this.joueur, this.joueur2);
		}
	
	

	
	
	
	
	
	// méthode pour savoir qui est le bateau selectioner pour le positioner danzs le mode un ou deux joueur
	
	public void setBateauAPositioner(String Nom, Joueur joueur){
		
		this.NomNavire=Nom;
		if( joueur.equals(this.joueur)){	
			if( NomNavire == "Zodiac" ) navire = this.joueur.getFlote().get(0);
			else if (NomNavire=="Cuirassé") navire = this.joueur.getFlote().get(1);
			else if (NomNavire=="Cuirassé2") navire = this.joueur.getFlote().get(2);
			else if ( NomNavire== "soumarin") navire=  this.joueur.getFlote().get(3);
			else if ( NomNavire== "porteavion") navire =  this.joueur.getFlote().get(4);
			this.bateauChoisi=true;
			
		}else if ( joueur.equals(this.joueur2)){
			if( NomNavire == "Zodiac" ) navire = this.joueur2.getFlote().get(0);
			else if (NomNavire=="Cuirassé") navire = this.joueur2.getFlote().get(1);
			else if (NomNavire=="Cuirassé2") navire = this.joueur2.getFlote().get(2);
			else if ( NomNavire== "soumarin") navire=  this.joueur2.getFlote().get(3);
			else if ( NomNavire== "porteavion") navire =  this.joueur2.getFlote().get(4);
			this.bateauChoisi=true;
		}
		
	}
	
	// méthode pour savoir la position du bateau a placer
	
	public void setPositionDePlacement(Position position){
		this.position= position;
		this.bateauContientposition=true;
		
	}
	
	// méthode pour l'orientation du bateau a positionner 
	
	public void setOrientation(Orientation orien){
		
		this.orientation=orien;
	}
	
	// méthode pour positioner un bateau une fois qu'il a une position est bien on a un bateau
	
	public void positionerBateau(Joueur j){
		
		this.setEtatPartie(EtatPartie.EnCoursPlacementBateau);
		
		if( j.equals(this.joueur)){
			
			placementOk=this.bataille.getJoueur1().getGrille().positionnerNavire(navire, position, orientation);
			// enlever un listener apres positionement a chaque bateau 
			if( placementOk == true){
				
				if( NomNavire == "Zodiac" ) this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb1());
				else if (NomNavire=="Cuirassé")this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb2());
				else if (NomNavire=="Cuirassé2") this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb3());
				else if ( NomNavire== "soumarin")this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb4());
				else if ( NomNavire== "porteavion") this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb5());
				nbbateaupositioner++;
				System.out.println(nbbateaupositioner);
			}
			//
		
		}	
		else {
			if (j.equals(this.joueur2))
			placementOk=this.bataille.getJoueur2().getGrille().positionnerNavire(navire, position, orientation);
			// enlever un listener apres positionement 
			if( placementOk== true){
				
				if( NomNavire == "Zodiac" ) this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb1());
				else if (NomNavire=="Cuirassé")this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb2());
				else if (NomNavire=="Cuirassé2") this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb3());
				else if ( NomNavire== "soumarin")this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb4());
				else if ( NomNavire== "porteavion") this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().remove_listener(this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getb5());
				nbbateaupositioner++;
				System.out.println(nbbateaupositioner);
			}

		}
		if( this.getModeJeu()==ModeJeu.ModeDeuxJoueurs){
			if( nbbateaupositioner==10 ){
			
				this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getMontour().setText("attaqué");
				this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getMontour().setText("Attendre");
				
				this.vue.getPanelModeJeu().getPanneau_Jeu().getDebuter().setVisible(true);		
				this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur2().getFlote().getOrientation().setVisible(false);
		
			}
		}else if(this.getModeJeu()==ModeJeu.ModeUnJoueur){
			if( nbbateaupositioner==5 ){
				/////////////
				this.getFram().getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getMontour().setText("attaqué");
				
				this.vue.getPanelModeJeu().getPanneau_Jeu().getDebuter().setVisible(true);
				this.vue.getPanelModeJeu().getPanneau_Jeu().getPanneaujoueur1().getFlote().getOrientation().setVisible(false);
		
			}
		}

		this.bateauChoisi=false;
		this.bateauContientposition=false;
		this.navire=null;
		this.position=null;
		
	}
	
	// initialiser le mode deux joueur 
	
	

	public Joueur getJoueur1() {
		
		return this.joueur;
	}
	public Joueur getJoueur2() {

		return this.joueur2;
	}
	
	public void setJoueur1(Joueur j1) {
		this.joueur=j1;
				
	}
	public void setJoueur2(Joueur j2) {
		this.joueur2=j2;
				
	}
	
	
	// Enregistrer l'etat de la Partie
	
	public void setEtatPartie( EtatPartie etat){
		this.etatpartie=etat;
		
	}
	
	/// avoir l'etat de la partie 
	
	public EtatPartie getEtatPartie(){
		return this.etatpartie;
	}
	
	// savoir si le bateau a les 
	
	public boolean getEsBateauChoisi(){
		return this.bateauChoisi;
	}
	
	
	
	public boolean getEsBateauCPosition(){
		return this.bateauContientposition;
	}
	
	
	public void SetNewPartie(){
		
		this.setNewControleur();
		
		
	}
	
	
	public Bataille getBataille(){
		return this.bataille;
	}
	
	public void setPositionTir(Joueur joueurAttaqué, Position position){
		this.joueurAtttaqué=joueurAttaqué;
		this.positionTir=position;
	}
	
	public Position getPositionTir(){
		return this.positionTir;
	}
	
	
	
	public void setNewControleur(){

		this.vue.dispose();
		
		Controleur con =  new Controleur();
	}
	
	public Controleur getinstance(){
		return this;
	}
	
	public Fenetre_Principale getFram(){
		return this.vue;
	}
	
	public TypeBataille gettypebataille(){
		return this.tyepbataille;
	}
	
	public void setTypebataille(TypeBataille type){
		this.tyepbataille=type;
	}
	
	
}
