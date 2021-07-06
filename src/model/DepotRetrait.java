package model;

public class DepotRetrait {
	private int id;
	private String type;
	private int montant;
	private String date;
	private String commentaire;
	private int totale;
	


	private String table = "comptabiliter";
	
	
	public DepotRetrait(String type, int montant, String date, String commentaire, int totale) {
		super();
		this.type = type;
		this.montant = montant;
		this.date = date;
		this.commentaire = commentaire;
		this.totale = totale;
	}
	
	public int getTotale() {
		return totale;
	}

	public void setTotale(int totale) {
		this.totale = totale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
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
	
	public static String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + "comptabiliter" + " ( id INTEGER NOT NULL AUTO_INCREMENT , type VARCHAR(50),  montant INTEGER, date VARCHAR(100), commentaire VARCHAR(50), totale INTEGER"
				+ ", PRIMARY KEY (id))" );
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " (type, montant, date, commentaire, totale) VALUES (" + this.type + ", " + this.montant + ", " + this.date +", " + this.commentaire + ", "+ this.totale + ")");
	}


}
	
