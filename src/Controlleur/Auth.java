package Controlleur;

import model.Database;
import model.Utilisateur;

public class Auth {
	private Database db;
	private UtilitaireControleur util;
	public Auth() {
		super();
		db = new Database();
		util = new UtilitaireControleur();
	}

	public Utilisateur connection (String user, String mdp) {
		Utilisateur currentUser = db.getUtilisateur(util.quote(user), mdp);
		return currentUser;
		
	}

}
