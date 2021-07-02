package model;

public class Planning {
	private String titre;
	private String date;
	private String commentaire;
	
	private String table = "Planning";
	
	

	



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
	
	
	public Planning(String titre, String date, String commentaire) {
		super();
		
		this.titre = titre;
		this.date = date;
		this.commentaire = commentaire;
	}
	
	
	
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " (  titre VARCHAR(50), date VARCHAR(10) , commentaire VARCHAR(100),"
				+ " PRIMARY KEY(titre))" );
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES ( " + this.titre + ", " + this.date +", " + this.commentaire + ")");
	}
	
	public String update(String titre) {
		return("UPDATE " + this.table + " SET   titre = " + this.titre + " , date = " + this.date +" , commentaire = " + this.commentaire +
				 " WHERE titre = " + titre);
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE titre = " +titre );
	}
	@Override
	public String toString() {
		return "Planning [titre=" + titre + ", date=" + date + ", commentaire="
				+ commentaire + ", table=" + table + "]";
	}

}
