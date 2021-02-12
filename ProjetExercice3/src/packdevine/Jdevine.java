package packdevine;


public class Jdevine {
	private int atrouver;
	private boolean fini;
	
	public Jdevine() {
		atrouver = (int)(Math.random()*100);
		fini= false;
	}
	
	public String chercher (int nbr) {
		if(fini == false) {
			if(nbr> atrouver)
				return "Trop grand !";
			if(nbr<atrouver)
				return "Trop petit !";
			else {
				fini = true;
				return "Bravo vous avez gagné !";
				}
		}else {
			   return " Fini , veuillez recommencer si vous le souhaitez !";
			}
			
    }

	public int getAtrouver() {
		return atrouver;
	}

	public void setAtrouver(int atrouver) {
		this.atrouver = atrouver;
	}

	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

			   
}
