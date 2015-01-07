package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ModeJeu;

public class Fenetre_Principale extends JFrame implements ActionListener , Observer{

	private  JButton mode1 =new JButton("Mode Démo");
	private JButton mode2= new JButton("Joueur VS Ordinateur");
	private JButton mode3 = new JButton ("Joueur VS Joueur");
	private JButton quitter = new JButton ("Quitter");
	
	Panneau_Jeu panneau_Jeu;
	
	private JPanel content = new JPanel();
	
	private Mode_Jeu Panelmodejeu;
	
	private Controleur controleur ;
	
	// constructeur 
	
	public Fenetre_Principale(Controleur cont) {
		
		controleur = cont;
		this.setTitle("Bataille Navale");
		this.setBounds(0, 0, 250, 250);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(true);
		
		mode1.setBounds(0, 25,250 , 30);
		mode1.setBackground(Color.yellow);
		mode1.addActionListener(this);
		
		mode2.setBounds(0, 56, 250, 30);
		mode2.setBackground(Color.yellow);
		mode2.addActionListener(this);
		
		mode3.setBounds(0, 87, 250, 30);
		mode3.setBackground(Color.yellow);
		mode3.addActionListener(this);
		
		quitter.setBounds(0, 118, 250, 30);
		quitter.setBackground(Color.yellow);
		quitter.addActionListener(this);
		
		this.content.setLayout(null);
		this.content.setBackground(Color.cyan);
		this.content.add(mode1);
		this.content.add(mode2);
		this.content.add(mode3);
		this.content.add(quitter);
		
		this.setContentPane(content);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource()==quitter) {
		    System.exit(0);
		}else
			
		if(event.getSource()== mode1 ) {
	
			this.controleur.setModeJeu(ModeJeu.ModeDemo);
			controleur.modeDémo();
	
			panneau_Jeu= new Panneau_Jeu(controleur);		
			panneau_Jeu.getPanneaujoueur1().getFlote().remove_listener();
			panneau_Jeu.getPanneaujoueur2().getFlote().remove_listener();
			panneau_Jeu.getPanneaujoueur1().getTerrainJeu().remove_listener();
			panneau_Jeu.getPanneaujoueur2().getTerrainJeu().remove_listener();
			controleur.getBataille().addObserver(this);

			this.setTitle("Mode Démo");
			this.setBounds(0, 0, 950, 750);
			this.changerpanel(panneau_Jeu);
			
		}else
			// mode Un Joueur
			
		if(event.getSource() == mode2) {
	
			this.Panelmodejeu= new Mode_Jeu(this.controleur);
			
			this.controleur.setModeJeu(ModeJeu.ModeUnJoueur);
			this.setLocationRelativeTo(null);
			this.setSize(300, 200);
			this.changerpanel(this.Panelmodejeu);
			
			System.out.println("je suis la");
			/*
			controleur.mode1joueur();
			panneau_Jeu= new Panneau_Jeu(controleur);
			panneau_Jeu.getPanneaujoueur2().getFlote().remove_listener();
			panneau_Jeu.getPanneaujoueur2().getTerrainJeu().remove_listener();
			
			panneau_Jeu.getPanneaujoueur1().getFlote().Ajouter_Button();
			panneau_Jeu.getDebuter().setVisible(false);
			this.setBounds(0, 0, 950, 750);
			this.setTitle("Mode 1 Joueur");
			this.changerpanel(panneau_Jeu);
		    
			this.controleur.getBataille().addObserver(this);
			/*/
		}else
			
			// mode Deux Joueurs
			
		if(event.getSource()==mode3) {
			
			this.Panelmodejeu= new Mode_Jeu(this.controleur);
			this.controleur.setModeJeu(ModeJeu.ModeDeuxJoueurs);
			this.setLocationRelativeTo(null);
			this.setSize(300, 200);
			this.changerpanel(this.Panelmodejeu);
			
			System.out.println("je suis la");
			
			
			/*
			
			
			
			this.setBounds(50, 10, 950, 750);
			this.setTitle("Mode 2 Joueur");
			this.changerpanel(panneau_Jeu);
			
			this.controleur.getBataille().addObserver(this);
		/*/
		}
	}
	
	public void changerpanel(JComponent component) {
		this.setContentPane(component);
	}
	
	
	public JFrame getFrame(){
		return this;
	}
	
	public Mode_Jeu getPanelModeJeu(){
		return this.Panelmodejeu;
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("jeje");
		JOptionPane p= new JOptionPane();
		String nomGagnom= this.controleur.getBataille().getGagnant().getNom();
		
		p.showConfirmDialog(this.getFrame(), nomGagnom+"  est le gagant. ");
		//p.showMessageDialog(this.getFrame(), nomGagnom);
		
	}
	
	
}
