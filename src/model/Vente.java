package model;

import java.util.Date;

public class Vente {
	private int idVente;
	private String nomClient;
	private String idProduit;
	private int idUtilisateur;
	private String idStock;
	private double prixVente;
	private int quantiter;
	private String dateVente;
	private String note;
	private String table = "Ventes";
	
	public Vente( String nomClient, String idProduit, int idUtilisateur, String idStock, double prixVente,
			int quantiter, String dateVente) {
		super();
		this.nomClient = nomClient;
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
		this.idStock = idStock;
		this.prixVente = prixVente;
		this.quantiter = quantiter;
		this.dateVente = dateVente;
	}

	public int getIdVente() {
		return idVente;
	}

	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}

	public String getnomClient() {
		return nomClient;
	}

	public void setnomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public int getQuantiter() {
		return quantiter;
	}

	public void setQuantiter(int quantiter) {
		this.quantiter = quantiter;
	}

	public String getDateVente() {
		return dateVente;
	}

	public void setDateVente(String dateVente) {
		this.dateVente = dateVente;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + "(nomClient,  idProduit, idUtilisateur, idStock, prixVente, quantiter, dateVente)" + " VALUES (" + this.nomClient + ", " + this.idProduit + ", " + this.idUtilisateur + ", " + this.idStock
				+ ", " + this.prixVente + ", " + this.quantiter + ", " + this.dateVente  +")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idVente INTEGER NOT NULL AUTO_INCREMENT, nomClient VARCHAR(50),  idProduit VARCHAR(50), idUtilisateur INTEGER , idStock VARCHAR(50),"
				+ " prixVente FLOAT, quantiter INTEGER, dateVente VARCHAR(50), PRIMARY KEY( idVente), "
				+ " FOREIGN KEY(idUtilisateur) REFERENCES Utilisateurs(idUtilisateur), "
				+ " FOREIGN KEY(idStock) REFERENCES Stock(idStock)) " );
	}
	
	public String update(int idVente, String nomClient, String idProduit, int idUtilisateur, String idStock) {
		return("UPDATE " + this.table + " SET  idVente = " + this. idVente+ " , nomClient = " + this.nomClient + " , idProduit  = " + this.idProduit +
				 ", idUtilisateur = " + this.idUtilisateur + ", idStock = " + this.idStock +", prixVente = "+ this.prixVente + ",quantiter = "+ this.quantiter
				 + ", dateVente = " + this.dateVente + ", note = " + this.note + " WHERE nomClient = " + nomClient + " AND idProduit = " + idProduit + " AND idUtilisateur = "
				 + idUtilisateur + " AND idVente = " + idVente + " AND idStock = " + idStock  );
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE nomClient = " + this.nomClient +  " AND idProduit = " + idProduit + " AND idUtilisateur = "
				 + idUtilisateur + " AND idVente = " + idVente + " AND idStock = " + idStock);
	}

	@Override
	public String toString() {
		return "Vente [idVente=" + idVente + ", nomClient=" + nomClient + ", idProduit=" + idProduit + ", idUtilisateur="
				+ idUtilisateur + ", idStock=" + idStock + ", prixVente=" + prixVente + ", quantiter=" + quantiter
				+ ", dateVente=" + dateVente + ", note=" + note + ", table=" + table + "]";
	}
	
	
}
