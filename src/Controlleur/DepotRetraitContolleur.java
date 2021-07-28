package Controlleur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Client;
import model.Database;
import model.DepotRetrait;
import model.Stock;

public class DepotRetraitContolleur {
	private Database db;
	private UtilitaireControleur util;

	public DepotRetraitContolleur() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
		
	}
	
	public String CreateDR(String type , String montant , String commentaire ) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		int totale;
		try {
			int valeur = Integer.parseInt(montant);
			List<DepotRetrait> drs = this.allDR();

			if (drs.isEmpty()) {
				totale = 0;
			}
			else {
				DepotRetrait dr = drs.get(drs.size()-1);
				totale = dr.getTotale(); 
			}
			if ((type.equals("Retrait")) && (valeur > totale) ) {
				return "fond insuffisant";
			}
			else if(type.equals("Retrait")) {
				totale = totale - valeur;
			}
			else {
				totale = totale + valeur;
			}
			
			String date = currentDateTime.format(formatter);
			System.out.println(date);
				try {
					
					DepotRetrait dr = new DepotRetrait(util.quote(type), valeur, util.quote(date), util.quote(commentaire),totale );
					db.addDr(dr);
					System.out.println("stocker");
					return "enregistre";
					
				}
				catch(Exception e){
					return "erreur liaison";
				}
				
			}catch(Exception e){
				return "montant doit etre un nombre";
			}
	}

	public List<DepotRetrait> searchDR(String mot){
		String motClee = util.quote(mot+"%");
		return null;
		
	}
	
	public List<DepotRetrait> allDR(){
		List<DepotRetrait> drs = db.getAllDR();
		return drs;
		
	}

}
