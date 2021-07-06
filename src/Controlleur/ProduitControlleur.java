package Controlleur;

import java.util.List;

import model.Database;
import model.Produit;

public class ProduitControlleur {
	private Database db;
	private UtilitaireControleur util;
	public ProduitControlleur() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
	}

	
	
	public boolean CreateProduit(String id ,String qte , String desc ) {
		
		try {
			int quantiter = Integer.parseInt(qte);
			Produit stck = new Produit(util.quote(id), quantiter, util.quote(desc) );
			db.addProduit(stck);
			System.out.println("Produiter");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
		
	}
	public List<Produit> allProduit(){
		List<Produit> Produit = db.getAllProd();
		return Produit;
		
	}
	
	public boolean editProduit(String id , String qte , String desc, String oldId) {
		try {
			int quantiter = Integer.parseInt(qte);
			Produit stck = new Produit(util.quote(id), quantiter, util.quote(desc) );
			System.out.println(oldId+ " === "+id);
			db.updateProduit(stck, util.quote(oldId));;
			System.out.println("Produiter");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean supprProduit(String id , String qte , String desc) {
		try {
			int quantiter = Integer.parseInt(qte);
			Produit stck = new Produit(util.quote(id), quantiter, util.quote(desc) );
			db.deleteProduit(stck);
			System.out.println("supprimer");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List<Produit> searchProduit(String mot){
		String motClee = util.quote(mot+"%");
		List<Produit> Produit = db.searchProd(motClee);
		return Produit;
		
	}

}
