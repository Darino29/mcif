package model;

public class Stock {
	private String idStock;
	private String idProduit;
	private int qteStock;
	private int qteMin;
	
	private String table = "Stock";
	
	
	public Stock(String idStock, String idProduit, int qteStock, int qteMin) {
		super();
		this.idStock = idStock;
		this.idProduit = idProduit;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
	}
	public String getIdStock() {
		return idStock;
	}
	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idStock VARCHAR(50), idProduit VARCHAR(50), qteStock INTEGER, Minimum INTEGER,"
				+ " PRIMARY KEY(idStock, idProduit), FOREIGN KEY(idProduit) REFERENCES Produits(idProduit))" );
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES (" + this.idStock + ", " + this.idProduit + ", " + this.qteStock +", " + this.qteMin + ")");
	}
	
	public String update(String idStock, String idProduit ) {
		return("UPDATE " + this.table + " SET  idStock = " + this.idStock+ " , idProduit = " + this.idProduit + " , qteStock = " + this.qteStock +
				 ", Minimum = " + this.qteMin + " WHERE idStock = " + this.idStock + " AND idProduit = " + idProduit);
	}
	
	public String delete() {
		return("DELETE FROM " + this.table + " WHERE idStock = " + this.idStock + " AND idProduit = " + idProduit);
	}
	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", idProduit=" + idProduit + ", qteStock=" + qteStock + ", qteMin="
				+ qteMin + ", table=" + table + "]";
	}

}
