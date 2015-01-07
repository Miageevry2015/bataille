package Modele;


public class Case {
	
	private Position position; //la position de la case
	private boolean rempli = false; //savoir si la case est rempli ou pas
	private boolean touchee = false;  //savoir si un bout de navire a été touché à cette case
	private Navire Bateau;
	
	private Resultat resultat;
	
	public Case(){
		
		this.setRempli(false);
	}
	
	public Case(Position position){
		this.position = position;
		this.setRempli(true);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean rempli) {
		this.rempli = rempli;
		
	}

	public boolean isTouchee() {
		return touchee;
	}

	public void setTouchee(boolean touchee) {
		this.touchee = touchee;
	}
	
	public Navire getNavire() {
		return this.Bateau;
	}
	
	public void setNavrie(Navire bateau) {
		this.Bateau=bateau;
	}
	
	public void setResultat( Resultat result) {
		this.resultat=result;
	}
	
	public Resultat getResultat() {
		return this.resultat;
	}
	
}