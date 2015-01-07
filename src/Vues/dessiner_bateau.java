package Vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.EtatPartie;
import Modele.Joueur;
import Modele.ModeJeu;
import Modele.Navire;
import Modele.Resultat;

public class dessiner_bateau extends JPanel implements MouseListener, Observer  {
	
	int y;
	String nom;
	
	private Controleur controleur;
	private Joueur joueur;
	Resultat resultat;
	
	static int nb;
	
	
	
	public dessiner_bateau(Controleur cont, Joueur j) {
		
		controleur = cont;
		joueur=j;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, getSize().width, getSize().height);
		
		g.drawRect(0, 0, 40, 40);
		g.setColor(Color.cyan);
		
		for(int x=0;x<getY(); x++) {
			
				g.drawRect(x*40, 40, 40, 40);
				g.setColor(Color.cyan);
				
		}
		
		if(this.controleur.getEtatPartie()==EtatPartie.EnCoursPlacementBateau){
			for( int i =0 ; i< this.joueur.getFlote().size(); i++){
				if(!this.joueur.getFlote().isEmpty()){
					for ( int j = 0 ; j< this.joueur.getFlote().get(i).getPosition().size(); j ++){
						g.setColor(Color.gray);
	   		   			g.fillRect(0, 0, getSize().width, getSize().height);
					}
				}
				
			}
			
		}
		
		
		if(this.controleur.getEtatPartie()==EtatPartie.EncoursDeJeu){
			
	   		for(int i1=0; i1<this.joueur.getGrille().gettaillegrille(); i1++) {
	   			for (int j1=0; j1 < this.joueur.getGrille().gettaillegrille(); j1++) {
	   				
	   				//resultat=this.joueur.getGrille().getCases()[i1][j1].getResultat();
	   				
	   					
	   					for(int i=0;i<getY(); i++) {
	   						
	   						g.setColor(Color.red);
	   		   				g.fillRect(0, 0, getSize().width, getSize().height);
	   		   				
	   		   				g.drawRect(0, 0, 40, 40);
	   		   				g.setColor(Color.red);
	   						
	   						g.drawRect(i1*40, 40, 40, 40);
	   						g.setColor(Color.red);
	   						
	   				
	   					
	   					
	   				}
	   					
	   					 
	   				}
	   				
	   			}
	   		
	   			
	   		
		}
		
	}

	public void setY(int y1)  {
		this.y=y1;
	}
	
	public int getY() {
		return y;
	}
	
	
	public void setnom(String nom) {
		this.nom= nom;
	}
	public String getnom() {
		return this.nom;
	}

	
	
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	
	
		if( this.controleur.getEtatPartie()== EtatPartie.EnCoursPlacementBateau || this.controleur.getModeJeu()==ModeJeu.ModeUnJoueur){
			this.controleur.setBateauAPositioner(this.getnom(), this.joueur);
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object a) {
		// TODO Auto-generated method stub
			this.paintComponent(getGraphics());
		
	}
	


	public void remove_listener(){
		this.removeMouseListener(this);
		
	}
	
	public void add_Mouse_Listener(){
		this.addMouseListener(this);
	}
}
