package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;


public class Flote  extends JPanel  {

	
	private dessiner_bateau b1;
	private dessiner_bateau b2;
	private dessiner_bateau b3;
	private dessiner_bateau b4;
	private dessiner_bateau b5;
	
	JPanel zodiac= new JPanel();
	JPanel cuirassé= new JPanel();
	JPanel cuirassé2= new JPanel();
	JPanel soumarin= new JPanel();
	JPanel porteavion= new JPanel();
	
	private Controleur controleur ;
	private Joueur joueur;

	private JButton Vider;
	private JButton Orientation;
	
	private JLabel label;
	
	public Flote(Controleur cont, Joueur j) {
		
		
		
		controleur =cont;
		
		label = new JLabel("Joueur : "+ j.getNom());
		
		label.setBounds(300,90,200,15);
		label.setBackground(Color.red);
		
		
		joueur= j;
		b1= new dessiner_bateau(controleur, joueur);
		joueur.getFlote().get(0).addObserver(b1);
		
		b2= new dessiner_bateau(controleur, joueur);
		joueur.getFlote().get(1).addObserver(b2);
		
		b3= new dessiner_bateau(controleur, joueur);
		joueur.getFlote().get(2).addObserver(b3);
		
		b4= new dessiner_bateau(controleur, joueur);
		joueur.getFlote().get(3).addObserver(b4);
		
		b5= new dessiner_bateau(controleur, joueur);
		joueur.getFlote().get(4).addObserver(b5);
		
		b1.setY(1);
		b1.setnom("Zodiac");
		b2.setY(2);
		b2.setnom("Cuirassé");
		b3.setY(2);
		b3.setnom("Cuirassé2");
		b4.setY(3);
		b4.setnom("soumarin");
		b5.setY(4);
		b5.setnom("porteavion");
		
		this.setBackground(Color.white);
		this.setLayout(null);
		
		this.zodiac.setLayout(null);
		this.zodiac.setBounds(10, 10, 40, 80);
		this.cuirassé.setLayout(null);
		this.cuirassé.setBounds(60, 10, 40, 120);
		this.cuirassé2.setLayout(null);
		this.cuirassé2.setBounds(120, 10, 40, 120);
		this.soumarin.setLayout(null);
		this.soumarin.setBounds(170, 10, 40, 160);
		
		this.porteavion.setBounds(230, 10, 40, 200);
		this.porteavion.setLayout(null);
		
		this.b1.setBounds(0, 0, 40, 120);
		this.b2.setBounds(0,0,40,120);
		this.b3.setBounds(0,0,40,120);
		this.b4.setBounds(0, 0, 40, 160);
		this.b5.setBounds(0, 0, 40, 200);
		
		this.zodiac.add(b1);
		this.cuirassé.add(b2);
		this.cuirassé2.add(b3);
		this.soumarin.add(b4);
		this.porteavion.add(b5);
		
		this.add(zodiac);
		this.add(cuirassé);
		this.add(cuirassé2);
		this.add(soumarin);
		this.add(porteavion);
		
		this.add(label);
		
		
	}


	public void Ajouter_Button(){
		
		
		
		Vider = new JButton ("Vider");
		Orientation = new JButton ("Verticale");

		

		Vider.setBounds(300,120,90,15);	
		Orientation.setBounds(50, 200, 150, 15);
	
		
		Vider.setBorder(BorderFactory.createLineBorder(Color.black));
		Vider.addActionListener(new 
				ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					
					
					
				}
			
		});
		
		
		
		Orientation.addActionListener(new
				ActionListener(){
				public void actionPerformed(ActionEvent ae){
					if(Orientation.getText()=="Horizonale"){
					
						Orientation.setText("Vertivale");
						controleur.setOrientation(Modele.Orientation.verticale);
					}else {
						Orientation.setText("Horizonale");
						controleur.setOrientation(Modele.Orientation.horizontale);
					}
					
				}
				
		});
		
		
		
		this.add(Vider);
		this.add(Orientation);
		
	}
	
	
	public void supprimer_button(){
		
		this.remove(Vider);
		
		this.remove(Orientation);
		
		
	}
	
	
	public void remove_listener(){
		
		this.b1.remove_listener();
		this.b2.remove_listener();
		this.b3.remove_listener();
		this.b4.remove_listener();
		this.b5.remove_listener();
		
		
	}
	
	public void remove_listener(dessiner_bateau b){
		b.remove_listener();
	}
	
	
	public Joueur getJoueur(){
		return this.joueur;
	}
	
	public dessiner_bateau getb1(){
		return this.b1;
	}
	
	public dessiner_bateau getb2(){
		return this.b2;
	}
	public dessiner_bateau getb3(){
		return this.b3;
	}
	public dessiner_bateau getb4(){
		return this.b4;
	}
	public dessiner_bateau getb5(){
		return this.b5;
	}
	
	public JButton getOrientation(){
		return this.Orientation;
	}
	
	
}
