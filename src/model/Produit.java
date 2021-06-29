package model;

public class Produit {
	private String idProduit;
	private double prix;
	private String descritpion;
	private String table = "Produits";
	
	public Produit(String idproduit, double prix, String descritpion) {
		super();
		this.idProduit = idproduit;
		this.prix = prix;
		this.descritpion = descritpion;
	}

	public String getidProduit() {
		return idProduit;
	}

	public void setIdproduit(String idproduit) {
		idProduit = idproduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES (" + this.idProduit + "," + this.descritpion + ", " + this.prix + " )");
	}
	
	

	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idProduit VARCHAR(50), description VARCHAR(50),  prix FLOAT, PRIMARY KEY(idProduit)) " );
	}
	
	public String update(String id) {
		return("UPDATE " + this.table + " SET idProduit = " + this.idProduit + " , description = " + this.descritpion + " , prix = " + this.prix + " WHERE idProduit = " + id  );
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE idProduit = " + this.idProduit);
	}
	
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", prix=" + prix + ", descritpion=" + descritpion + ", table="
				+ table + "]";
	}
	
}
