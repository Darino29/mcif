package Controlleur;

import model.Database;
import model.Utilisateur;

public class UtilisateurControleur {
	
	private Database db;
	private UtilitaireControleur util;
	public UtilisateurControleur() {
		db = new Database();
		util = new UtilitaireControleur();
		
	}
	
	public Boolean createUtilisateur(String nom, String mdp, String confirmMdp , String post){
		if(mdp.equals(confirmMdp) && mdp != "") {
			Utilisateur user = new Utilisateur(0, util.quote(nom), util.quote(mdp), util.quote(post));
			try {
				db.addUtilisateur(user);
				return true;
			}
			catch(Exception e) {
				return false;
			}
			
		}
		else {
			System.out.println(mdp+confirmMdp);
			return false;
		}
	}
}