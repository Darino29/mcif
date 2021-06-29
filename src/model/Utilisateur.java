package model;

public class Utilisateur {
	private int idUtilisateur;
	private String nomUtilisateur;
	private String mdpUtilisateur;
	private String email;
	private String telUtilisateur;
	private String postUtilisateur;
	private String table = "Utilisateurs";
	
	
	public Utilisateur(int idUtilisateur, String nomUtilisateur, String mdpUtilisateur, String email,
			String telUtilisateur, String postUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.mdpUtilisateur = mdpUtilisateur;
		this.email = email;
		this.telUtilisateur = telUtilisateur;
		this.postUtilisateur = postUtilisateur;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}
	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelUtilisateur() {
		return telUtilisateur;
	}
	public void setTelUtilisateur(String telUtilisateur) {
		this.telUtilisateur = telUtilisateur;
	}
	public String getPostUtilisateur() {
		return postUtilisateur;
	}
	public void setPostUtilisateur(String postUtilisateur) {
		this.postUtilisateur = postUtilisateur;
	}
	
	public String addToDb () {
		return("INSERT INTO " + this.table + " VALUES (" + this.idUtilisateur+ ", " + this.nomUtilisateur + ", " + this.mdpUtilisateur + ", " + this.email + ", " + this.telUtilisateur
				+ ", " + this.postUtilisateur + ")");
	}
	
	public String createTable() {
		return ("CREATE TABLE IF NOT EXISTS " + this.table + " ( idUtilisateur INTEGER, nomUtilisateur VARCHAR(50),  mdpUtilisateur VARCHAR(50), email VARCHAR(50) , telUtilisateur VARCHAR(50),"
				+ " postUtilisateur VARCHAR(50), PRIMARY KEY(idUtilisateur)) ");
	}
	
	public String update(int id) {
		return("UPDATE " + this.table + " SET  idUtilisateur = " + this.idUtilisateur + " , nomUtilisateur= " + this.nomUtilisateur + " , mdpUtilisateur = " + this.mdpUtilisateur+
				 ", email = " + this.email + ",postUtilisateur = " + this.postUtilisateur  + " WHERE idUtilisateur = " + id  );
	}
	
	public String delete() {
		return( "DELETE FROM " + this.table + " WHERE idUtilisateur = " + this.idUtilisateur );
	}
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", mdpUtilisateur=" + mdpUtilisateur + ", email=" + email + ", telUtilisateur=" + telUtilisateur
				+ ", postUtilisateur=" + postUtilisateur + ", table=" + table + "]";
	}
		
}
