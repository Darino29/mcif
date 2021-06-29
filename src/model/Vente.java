package model;

import java.util.Date;

public class Vente {
	private String idVente;
	private int idClient;
	private String idProduit;
	private int idUtilisateur;
	private String idStock;
	private double prixVente;
	private int quantiter;
	private String dateVente;
	private String note;
	private String table = "Ventes";
	
	public Vente(String idVente, int idClient, String idProduit, int idUtilisateur, String idStock, double prixVente,
			int quantiter, String dateVente, String note) {
		super();
		this.idVente = idVente;
		this.idClient = idClient;
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
		this.idStock = idStock;
		this.prixVente = prixVente;
		this.quantiter = quantiter;
		this.dateVente = dateVente;
		this.note = note;
	}

	public String getIdVente() {
		return idVente;
	}

	public void setIdVente(String idVente) {
		this.idVente = idVente;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
		return("INSERT INTO " + this.table + " VALUES (" + this.idVente + ", " + this.idClient + ", " + this.idProduit + ", " + this.idUtilisateur + ", " + this.idStock
				+ ", " + this.prixVente + ", " + this.quantiter + ", " + this.dateVente +  ", " + this.note  +")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idVente VARCHAR(50), idClient INTEGER,  idProduit VARCHAR(50), idUtilisateur INTEGER , idStock VARCHAR(50),"
				+ " prixVente FLOAT, quantiter INTEGER, dateVente VARCHAR(50), note VARCHAR(50), PRIMARY KEY(idClient, idVente, idProduit, idUtilisateur, idStock), "
				+ "FOREIGN KEY(idProduit) REFERENCES Produits(idProduit), FOREIGN KEY(idClient) REFERENCES Client(idCLient), FOREIGN KEY(idUtilisateur) REFERENCES Utilisateurs(idUtilisateur), "
				+ " FOREIGN KEY(idStock) REFERENCES Stock(idStock)) " );
	}
	
	public String update(String idVente, int idClient, String idProduit, int idUtilisateur, String idStock) {
		return("UPDATE " + this.table + " SET  idVente = " + this. idVente+ " , idClient = " + this.idClient + " , idProduit  = " + this.idProduit +
				 ", idUtilisateur = " + this.idUtilisateur + ", idStock = " + this.idStock +", prixVente = "+ this.prixVente + ",quantiter = "+ this.quantiter
				 + ", dateVente = " + this.dateVente + ", note = " + this.note + " WHERE idClient = " + idClient + " AND idProduit = " + idProduit + " AND idUtilisateur = "
				 + idUtilisateur + " AND idVente = " + idVente + " AND idStock = " + idStock  );
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE idClient = " + this.idClient +  " AND idProduit = " + idProduit + " AND idUtilisateur = "
				 + idUtilisateur + " AND idVente = " + idVente + " AND idStock = " + idStock);
	}

	@Override
	public String toString() {
		return "Vente [idVente=" + idVente + ", idClient=" + idClient + ", idProduit=" + idProduit + ", idUtilisateur="
				+ idUtilisateur + ", idStock=" + idStock + ", prixVente=" + prixVente + ", quantiter=" + quantiter
				+ ", dateVente=" + dateVente + ", note=" + note + ", table=" + table + "]";
	}
	
	
}
