package Controlleur;

import java.util.List;

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

	
	
	
	public String CreateStock(String id , String prod, String qte , String desc ) {
		
		try {
			int quantiter = Integer.parseInt(qte);
			Stock stck = new Stock(util.quote(id),util.quote(prod), quantiter, util.quote(desc) );
			db.addStock(stck);
			System.out.println("stocker");
			return "stocker";
			
		}
		catch(Exception e){
			return "erreur id stock ou produit non existant";
		}
		
	}
	public List<Stock> allStock(){
		List<Stock> stock = db.getAllStock();
		return stock;
		
	}
	
	public boolean editStock(String id , String prod, String qte , String desc, String oldId, String oldProd) {
		try {
			int quantiter = Integer.parseInt(qte);
			Stock stck = new Stock(util.quote(id),util.quote(prod), quantiter, util.quote(desc) );
			System.out.println(oldId+ " === "+id);
			db.updateStock(stck, util.quote(oldId), util.quote(oldProd));;
			System.out.println("stocker");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean supprStock(String id , String prod, String qte , String desc) {
		try {
			int quantiter = Integer.parseInt(qte);
			Stock stck = new Stock(util.quote(id),util.quote(prod), quantiter, util.quote(desc) );
			db.deleteStock(stck);
			System.out.println("supprimer");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List<Stock> searchStock(String mot){
		String motClee = util.quote(mot+"%");
		List<Stock> stock = db.searchStock(motClee);
		return stock;
		
	}
	public List<Stock> fullSearchStock(String mot){
		String motClee = util.quote(mot);
		List<Stock> stock = db.searchStock(motClee);
		return stock;
		
	}
}
