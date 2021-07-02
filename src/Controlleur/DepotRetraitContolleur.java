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
	
	public boolean CreateDR(String type , String montant , String commentaire ) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		String date = currentDateTime.format(formatter);
		System.out.println(date);
			try {
				int quantiter = Integer.parseInt(montant);
				DepotRetrait dr = new DepotRetrait(util.quote(type), quantiter, util.quote(date), util.quote(commentaire) );
				db.addDr(dr);
				System.out.println("stocker");
				return true;
				
			}
			catch(Exception e){
				return false;
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
