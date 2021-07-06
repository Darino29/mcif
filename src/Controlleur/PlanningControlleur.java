package Controlleur;

import java.util.List;

import model.Database;
import model.Planning;
import model.Stock;

public class PlanningControlleur {
	private Database db;
	private UtilitaireControleur util;
	public PlanningControlleur() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
	}

	
	
	
	public boolean CreatePlanning( String titre, String date ,String heure, String commentaire) {
		
		try {
			
			Planning plnn = new Planning(util.quote(titre), util.quote(date), util.quote(heure), util.quote(commentaire));
			db.addPlann(plnn);
			System.out.println("Planifier");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
		
	}
	public List<Planning> allPlanning(){
		List<Planning> plann = db.getAllPlann();
		return plann;
		
	}
	
	public boolean editPlann( String titre, String date,String heure, String commentaire ,String oldTitre) {
		try {
			Planning plnn = new Planning(util.quote(titre), util.quote(date), util.quote(heure), util.quote(commentaire) );
			
			db.updatePlanning(plnn, util.quote(oldTitre));;
			System.out.println("planifier");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean supprPlann( String titre, String date ,String heure , String commentaire) {
		try {
			Planning plnn = new Planning(util.quote(titre), util.quote(date), util.quote(heure), util.quote(commentaire));
			
			db.deletePlann(plnn);
			System.out.println("supprimer");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List<Planning> searchPlann(String mot){
		String motClee = util.quote(mot+"%");
		List<Planning> plnn = db.searchPlann(motClee);
		return plnn;
		
	}
}
