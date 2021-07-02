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
	
	public String calculer(int billet, String nombre) {
		int nbr = Integer.parseInt(nombre);
		int billetotal =  nbr * billet;
	    return Integer.toString(billetotal);
	}
	
	public String calculeTotale(String total2000, String total1000, String total500, String total200, String total100) {
		
		int to2000 = Integer.parseInt(total2000);
		int to1000 = Integer.parseInt(total1000);
		int to500 = Integer.parseInt(total500);
		int to200 = Integer.parseInt(total200);
		int to100 = Integer.parseInt(total100);
		return Integer.toString(to2000 + to1000 + to500 + to200 + to100);
	}
}
