package Controlleur;

public class UtilitaireControleur {

	public UtilitaireControleur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  String quote(String s) {
	    return new StringBuilder()
	        .append('\'')
	        .append(s)
	        .append('\'')
	        .toString();
	}

}
