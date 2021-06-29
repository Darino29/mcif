package model;

public class CommandeProduit {
	private String idCommande;
	private int idClient;
	private String idProduit;
	private String table = "CommandeProduit";
	
	public CommandeProduit(String idCommande, int idclient, String idProduit) {
		super();
		this.idCommande = idCommande;
		this.idClient = idclient;
		this.idProduit = idProduit;
	}

	public String getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdclient() {
		return idClient;
	}

	public void setIdclient(int idclient) {
		this.idClient = idclient;
	}

	public String getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES (" + this.idClient + ", " + this.idCommande + ", " + this.idProduit + ")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idClient INTEGER, idCommande VARCHAR(50),  idProduit VARCHAR(50)"
				+ ", PRIMARY KEY(idClient, idCommande, idProduit), FOREIGN KEY(idClient) REFERENCES Client(idClient), FOREIGN KEY(idProduit) REFERENCES Produits(idProduit))" );
	}
	
	public String update(String idCommande, int idClient, String idProduit) {
		return("UPDATE " + this.table + " SET  idClient = " + this. idClient + " , idCommande = " + this.idCommande + " , idProduit = " + this.idProduit +
				 " WHERE idClient = " + idClient + " AND idproduit = " + idProduit + " AND idCommande = " + idCommande   );
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE idClient = " + this.idClient  + " AND idproduit = " + this.idProduit + " AND idCommande = " + this.idCommande );
	}

	@Override
	public String toString() {
		return "CommandeProduit [idCommande=" + idCommande + ", idClient=" + idClient + ", idProduit=" + idProduit
				+ ", table=" + table + "]";
	}
	 
	

}
