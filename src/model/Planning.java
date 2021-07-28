package model;

public class Planning {
	private String titre;
	private String date;
	private String heure;
	
	private String commentaire;
	
	private String table = "Planning";
	
	
	public String getHeure() {
		return heure;
	}




	public void setHeure(String heure) {
		this.heure = heure;
	}
	



	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getCommentaire() {
		return commentaire;
	}




	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	public Planning(String titre, String date, String commentaire, String heure) {
		super();
		
		this.titre = titre;
		this.date = date;
		this.heure = heure;
		this.commentaire = commentaire;
	}
	
	
	
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " (  titre VARCHAR(50), date VARCHAR(10) , heure VARCHAR(50), commentaire VARCHAR(100),"
				+ " PRIMARY KEY(titre))" );
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES ( " + this.titre + ", " + this.date +"," + this.heure +", " + this.commentaire + ")");
	}
	
	public String update(String titre) {
		return("UPDATE " + this.table + " SET   titre = " + this.titre + " , date = " + this.date +", heure =" + this.heure +", commentaire = " + this.commentaire +
				 " WHERE titre = " + titre);
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE titre = " +titre );
	}
	@Override
	public String toString() {
		return "Planning [titre=" + titre + ", date=" + date + ", heure=" + heure + ", commentaire="
				+ commentaire + ", table=" + table + "]";
	}

}
