package Controlleur;

import model.Database;
import model.Stock;

public class StockControlleur {
	private Database db;
	private UtilitaireControleur util;
	public StockControlleur() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
	}

	
	
	
	public boolean CreateStock(String id , String prod, String qte , String desc ) {
		
		try {
			int quantiter = Integer.parseInt(qte);
			Stock stck = new Stock(util.quote(id),util.quote(prod), quantiter, util.quote(desc) );
			db.addStock(stck);
			return true;
			
		}
		catch(Exception e){
			return false;
		}
		
		
	}

}
