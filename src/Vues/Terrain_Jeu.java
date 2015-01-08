package Vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.EtatPartie;
import Modele.Joueur;
import Modele.ModeJeu;
import Modele.Position;
import Modele.Resultat;




public class Terrain_Jeu  extends JPanel  implements MouseListener, Observer{

	
	private Controleur controleur;
	
	private Joueur joueur;
	
	private Resultat resultat;
	
	Position positionTir,positionPlacement;
	
	
	public Terrain_Jeu(Controleur cont, Joueur joueur1) {	
		controleur= cont;
		joueur= joueur1;
		joueur.getGrille().addObserver(this);
		positionPlacement=new Position();
		positionTir= new Position();
		this.addMouseListener(this);
	
	}
	
	public void paintComponent(Graphics g ){
		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);
		
		g.drawRect(0, 0, 40, 40);
		g.setColor(Color.black);
		
			for(int x=0;x<10; x++) {
				for(int y=0; y<10 ; y++) {
					g.drawRect(x*40, y*40, 40, 40);
					g.setColor(Color.black);
					
				}
			}
		
			if(this.controleur.getModeJeu()==ModeJeu.ModeDemo){
				for (int i=0 ; i<this.joueur.getFlote().size();i++){
				     
					if(! this.joueur.getFlote().get(i).getPosition().isEmpty()){
			           for (int j =0 ; j<joueur.getFlote().get(i).getPosition().size(); j++){
			        	   g.setColor(Color.green); 
			        	   g.fillRect(  joueur.getFlote().get(i).getPosition().get(j).getX()*40,joueur.getFlote().get(i).getPosition().get(j).getY()*40,40, 40);
			        	   
			        	   
			           }        		   
				
					}
			
				}	
				
			}
	
		if( this.controleur.getModeJeu()==ModeJeu.ModeUnJoueur && this.joueur==this.controleur.getJoueur1() ){
			for (int i=0 ; i<this.joueur.getFlote().size();i++){
			     
				if(! this.joueur.getFlote().get(i).getPosition().isEmpty()){
		           for (int j =0 ; j<joueur.getFlote().get(i).getPosition().size(); j++){
		        	   g.setColor(Color.green); 
		        	   g.fillRect(  joueur.getFlote().get(i).getPosition().get(j).getX()*40,joueur.getFlote().get(i).getPosition().get(j).getY()*40,40, 40);
		        	   
		        	   
		           }        		   
			
				}
		
			}		
			
		}
		
		
		
			
			for(int i = 0 ; i< this.joueur.getGrille().gettaillegrille(); i++){
				for ( int j =0 ; j< this.joueur.getGrille().gettaillegrille(); j++){
					
					if( this.joueur.getGrille().getCases()[i][j].isTouchee() ){
						if(this.joueur.getGrille().getCases()[i][j].isRempli()){
							g.setColor(Color.black);
							g.fillRect(i*40, j*40, 40, 40);
						}else 
							
							
							
							if (!this.joueur.getGrille().getCases()[i][j].isRempli()){
								g.setColor(Color.gray);
								g.fillRect(i*40, j*40, 40, 40);
							}
						 
							else{
								g.setColor(Color.white);
								g.drawRect(i*40, j*40, 40, 40);
							}
						
					}
				}
			}
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
		int x,y;
		if( this.controleur.getEtatPartie()== EtatPartie.EncoursDeJeu){
			
			this.controleur.Jouer_Mode_joueur(new Position(event.getX()/40, event.getY()/40), this.joueur);
			
		}else
		  if( this.controleur.getEtatPartie()== EtatPartie.EnCoursPlacementBateau){
			  System.out.println("mode 3");
			x= event.getX()/40;
			y= event.getY()/40;
			
			this.positionPlacement.setX(x);
			this.positionPlacement.setY(y);
			this.controleur.setPositionDePlacement(this.positionPlacement);
			
			if( this.controleur.getEsBateauChoisi()== true && controleur.getEsBateauCPosition()==true){
				controleur.positionerBateau(this.joueur);
		
			}
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("mousePressed");
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Released");
	}

	
	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		
		this.paintComponent(getGraphics());	
		
	}
	
	public void remove_listener(){
		
		this.removeMouseListener(this);
	}
	
	public void add_Mouse_Listener(){
		this.addMouseListener(this);
	}
	
	public Joueur getJoueur(){
		return this.joueur;
	}
	
	
	
}
