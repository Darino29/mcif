package model;

import java.util.Date;

public class Client {
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String ddnClient;
	private String adresseClient;
	private String villeClient;
	private String paysClient;
	private String telClient;
	private String table = "Client";
	
	public Client(int idClient, String nomClient, String prenomClient, String ddnClient, String adresseClient,
			String villeClient, String paysClient, String telClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.ddnClient = ddnClient;
		this.adresseClient = adresseClient;
		this.villeClient = villeClient;
		this.paysClient = paysClient;
		this.telClient = telClient;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getDdnClient() {
		return ddnClient;
	}
	public void setDdnClient(String ddnClient) {
		this.ddnClient = ddnClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public String getVilleClient() {
		return villeClient;
	}
	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}
	public String getPaysClient() {
		return paysClient;
	}
	public void setPaysClient(String paysClient) {
		this.paysClient = paysClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + "(nomClient, prenomClient, ddnClient, adresseClient, villeClient, paysClient, telClient)" +" VALUES (" + this.nomClient + ", " + this.prenomClient + ", " + this.ddnClient + ", " + this.adresseClient
				+ ", " + this.villeClient + ", " + this.paysClient + ", " + this.telClient+ ")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idClient INTEGER NOT NULL AUTO_INCREMENT, nomClient VARCHAR(50),  prenomClient VARCHAR(50), ddnClient VARCHAR(50) , adresseClient VARCHAR(50),"
				+ " villeClient VARCHAR(50), paysClient VARCHAR(50), telClient VARCHAR(50), PRIMARY KEY(idClient)) " );
	}
	
	public String update(String nom, String prenom) {
		System.out.println(nom + ","+ prenom +" or "+ this.nomClient + "," + this.prenomClient);
		return("UPDATE " + this.table + " SET nomClient = " + this.nomClient + " , prenomClient = " + this.prenomClient +
				 ", ddnClient = " + this.ddnClient + ", adresseClient = " + this.adresseClient +", villeClient = "+ this.villeClient + ",paysClient = "+ this.paysClient
				 + ", telClient = " + this.telClient + " WHERE nomClient = " + nom + " AND prenomClient = " + prenom  );
	}
	
	public String delete() {
		System.out.println(this.nomClient +" , " + this.prenomClient);
		return("DELETE FROM " + this.table + " WHERE nomClient = " + this.nomClient + " AND prenomClient = " + this.prenomClient );
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", ddnClient=" + ddnClient + ", adresseClient=" + adresseClient + ", villeClient=" + villeClient
				+ ", paysClient=" + paysClient + ", telClient=" + telClient + ", table=" + table +  "]";
	}
	
	
	
}
