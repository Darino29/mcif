package Controlleur;

import java.awt.Panel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Client;
import model.Database;
import model.Stock;
import model.Utilisateur;
import model.Vente;

public class VenteControlleur {
	
	private Database db;
	private UtilitaireControleur util;
	public VenteControlleur() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
	}
	public List<Vente> allVente(){
		List<Vente> ventes = db.getAllVente();
		return ventes;
	}
	
	public List<Vente> searchVente(String mot){
		String motClee = util.quote(mot+"%");
		List<Vente> vt = db.searchVente(motClee);
		return vt;
		
	}
	
	public String createVente(String produit, String client, String prix, String qte, String stock, Utilisateur vendeur) {
		Stock used = db.useStock(util.quote(stock), util.quote(produit));
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");	 
		String date = currentDateTime.format(formatter);
		
		
		try {
			int quantiter = Integer.parseInt(qte);
			double montant = Double.parseDouble(prix);
			if (used == null) {
				return " stock ou produit introuvable dans le stock";
			}
			else {
				if(used.getQteStock() < quantiter) {
					return "stock insuffisant";
				}
				else {				
					used.setQteStock(used.getQteStock()-quantiter);
					used.setDesc(util.quote(used.getDesc()));
					used.setIdStock(util.quote(stock));
					used.setIdProduit(util.quote(produit));
					db.updateStock(used, used.getIdStock(), used.getIdProduit());
					Vente vt = new Vente(util.quote(client), util.quote(produit), vendeur.getIdUtilisateur(), util.quote(stock), montant, quantiter, util.quote(date));
					db.addVente(vt);
					return "vente confirmer";
				}
			}
		}catch(Exception e) {
			
			return "prix et qte doit etre un chiffre ";
		}
		
		
	}
	public String[] searchProdStock(String stk) {
		
		StockControlleur stkC = new StockControlleur();
		List<Stock> prods =stkC.fullSearchStock(stk);
		List<String> prodName = new ArrayList<String>();
		for (Stock st : prods) {
			prodName.add(st.getIdProduit());
			System.out.println(st.getIdProduit());
		}
		String[] produit = prodName.toArray(new String[0]);
		return produit;
		
	}
	

}
