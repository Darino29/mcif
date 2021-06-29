/**
 * 
 */
package model;
import java.util.Date;

/**
 * @author Kevin
 *
 */
public class Commande {
	private String idCommande;
	private int idClient;
	private String dateCommande;
	private String commentaire;
	private String table = "commande";
	
	public Commande(String idCommande, int idClient, String dateCommande, String commentaire) {
		super();
		this.idCommande = idCommande;
		this.idClient = idClient;
		this.dateCommande = dateCommande;
		this.commentaire = commentaire;
	}
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES (" + this.idCommande + ", " + this.idClient + ", " + this.commentaire + ", " + this.dateCommande + ")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idCommande VARCHAR(50), idClient INTEGER,  dateCommande VARCHAR(50), commentaire VARCHAR(50),"
				+ " PRIMARY KEY(idCommande, idClient), FOREIGN KEY(idClient) REFERENCES Client(idClient))" );
	}
	
	public String update(String id) {
		return("UPDATE " + this.table + " SET  idClient = " + this. idClient + " , idCommande = " + this.idCommande + " , dateCommande = " + this.dateCommande +
				 ", commentaire = " + this.commentaire + " WHERE idClient = " + this.idClient + " AND idCommande = " + id);
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE idCommande = " + this.idCommande + " AND idClient = " + this.idClient);
	}
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", idClient=" + idClient + ", dateCommande=" + dateCommande
				+ ", commentaire=" + commentaire + ", table=" + table + "]";
	}
	
}
