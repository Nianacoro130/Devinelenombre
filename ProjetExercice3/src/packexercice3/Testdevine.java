package packexercice3;

import java.util.ArrayList;

public class Testdevine {
	private int nombre;
	
	private ArrayList<String> historique;
	
	
	public Testdevine() {
		historique = new ArrayList<>();
		
	}
	
	public int getNombre() {
		return nombre;
	}
	
	public ArrayList<String> getHistorique(){
		return historique;
		
	}
	public void setHistorique(ArrayList<String> historique) {
		this.historique = historique;
	}
	public void addtoHistorique(String resultat) {
		this.historique.add(" Vous avez saisie le nombre : "+nombre+" indication :"+resultat);
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	
	

}
