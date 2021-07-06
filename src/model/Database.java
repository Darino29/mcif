package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private String dbLocation = "jdbc:mysql://localhost:3306";
	private String user = "root";
	private String mdp = "lelena";
	
	

	public Database() {
		super();

        try (Connection conn = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
             PreparedStatement stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS MICF")) {
        	
            stmt.execute();
            this.dbLocation += "/MICF";
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

	public List<Produit> getAllProd(){
		 List<Produit> produits = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from produits");
		        while (rs.next()) {
		            String id = rs.getString("idProduit");
		            String description = rs.getString("description");
		            Double price = rs.getDouble("prix");
		            produits.add(new Produit(id, price, description));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return produits;	
	}
	
	public List<Produit> searchProd(String mot){
		 List<Produit> produits = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from produits WHERE idProduit LIKE "  + mot);
		        while (rs.next()) {
		            String id = rs.getString("idProduit");
		            String description = rs.getString("description");
		            Double price = rs.getDouble("prix");
		            produits.add(new Produit(id, price, description));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return produits;	
	}
	
	public void addProduit (Produit prod) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(prod.createTable());
		        statement.executeUpdate(prod.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateProduit (Produit prod, String id) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(prod.createTable());
		        statement.executeUpdate(prod.update(id));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteProduit (Produit prod) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(prod.createTable());
	        statement.executeUpdate(prod.delete());
	        connection.close();
	  }
  	 catch (SQLException e) {
	  e.printStackTrace();
    }
		
	}
	
	public List<Client> getAllClient(){
		 List<Client> clients = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Client");
		        while (rs.next()) {
		            int id = rs.getInt("idClient");
		            String nom = rs.getString("nomClient");
		            String prenom  = rs.getString("PrenomClient");
		            String ddn  = rs.getString("ddnClient");
		            String addresse  = rs.getString("adresseClient");
		            String ville  = rs.getString("villeClient");
		            String pays  = rs.getString("paysClient");
		            String tel  = rs.getString("telClient");
		            clients.add(new Client(id, nom, prenom, ddn , addresse, ville, pays, tel));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return clients;	
	}
	
	public List<Client> searchClient(String mot){
		 List<Client> clients = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Client WHERE nomClient LIKE " + mot );
		        while (rs.next()) {
		            int id = rs.getInt("idClient");
		            String nom = rs.getString("nomClient");
		            String prenom  = rs.getString("PrenomClient");
		            String ddn  = rs.getString("ddnClient");
		            String addresse  = rs.getString("adresseClient");
		            String ville  = rs.getString("villeClient");
		            String pays  = rs.getString("paysClient");
		            String tel  = rs.getString("telClient");
		            clients.add(new Client(id, nom, prenom, ddn , addresse, ville, pays, tel));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return clients;	
	}
	
	public void addClient (Client clt) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(clt.createTable());
		        statement.executeUpdate(clt.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateClient (Client clt, String nom, String prenom) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(clt.createTable());
		        statement.executeUpdate(clt.update(nom, prenom));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteClient (Client clt) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(clt.createTable());
	        statement.executeUpdate(clt.delete());
	        connection.close();
	  }
 	 catch (SQLException e) {
	  e.printStackTrace();
   }
		
	}
	
	public List<Commande> getAllCommande(){
		 List<Commande> commandes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Commande");
		        while (rs.next()) {
		            int id = rs.getInt("idClient");
		            String idCommande = rs.getString("idCommande");
		            String date  = rs.getString("dateCommande");
		            String commentaire  = rs.getString("commentaire");
		            commandes.add(new Commande(idCommande, id, date, commentaire));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return commandes ;	
	}
	
	public void addCommande (Commande cmd) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(cmd.createTable());
		        statement.executeUpdate(cmd.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateCommande (Commande cmd, String id) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(cmd.createTable());
		        statement.executeUpdate(cmd.update(id));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteCommande (Commande cmd) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(cmd.createTable());
	        statement.executeUpdate(cmd.delete());
	        connection.close();
	  }
	 catch (SQLException e) {
	  e.printStackTrace();
  }
		
	}

	
	public List<CommandeProduit> getAllCommandeProd(){
		 List<CommandeProduit> commandes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from CommandeProduit");
		        while (rs.next()) {
		            int id = rs.getInt("idClient");
		            String idCommande = rs.getString("idCommande");
		            String idProduit  = rs.getString("idProduit");
		            commandes.add(new CommandeProduit(idCommande, id, idProduit));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return commandes ;	
	}
	
	public void addCommandePro (CommandeProduit cmdPro) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(cmdPro.createTable());
		        statement.executeUpdate(cmdPro.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateCommandePro (CommandeProduit cmdPro, String idCommande, int idClient, String idProduit) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(cmdPro.createTable());
		        statement.executeUpdate(cmdPro.update(idCommande, idClient, idProduit));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteCommandePro (CommandeProduit cmdPro) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(cmdPro.createTable());
	        statement.executeUpdate(cmdPro.delete());
	        connection.close();
	  }
	 catch (SQLException e) {
	  e.printStackTrace();
 }
	}

	public List<Stock> getAllStock(){
		 List<Stock> commandes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Stock");
		        while (rs.next()) {
		            int stockqte = rs.getInt("qteStock");
		            String idStock = rs.getString("idStock");
		            String idProduit  = rs.getString("idProduit");
		            String desc= rs.getString("Description");
		            commandes.add(new Stock(idStock, idProduit, stockqte, desc));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return commandes ;	
	}
	
	public List<Stock> searchStock(String motClee){
		 List<Stock> commandes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("SELECT * from Stock WHERE idStock LIKE " + motClee);
		        while (rs.next()) {
		            int stockqte = rs.getInt("qteStock");
		            String idStock = rs.getString("idStock");
		            String idProduit  = rs.getString("idProduit");
		            String desc= rs.getString("Description");
		            commandes.add(new Stock(idStock, idProduit, stockqte, desc));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return commandes ;	
	}
	
	public Stock useStock(String id, String produit) {
		
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT * from Stock WHERE idStock = " + id + " and idProduit = " + produit);
	        while (rs.next()) {
	            int stockqte = rs.getInt("qteStock");
	            String idStock = rs.getString("idStock");
	            String idProduit  = rs.getString("idProduit");
	            String desc= rs.getString("Description");
	            Stock stock = new Stock(idStock, idProduit, stockqte, desc);
	            return stock;
	        }
	        connection.close();
	        return null;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }

		
	}
	
	public void addStock (Stock stock) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(stock.createTable());
		        statement.executeUpdate(stock.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateStock (Stock stock, String idStock, String idProduit) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(stock.createTable());
		        statement.executeUpdate(stock.update(idStock, idProduit));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteStock (Stock stock) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(stock.createTable());
	        statement.executeUpdate(stock.delete());
	        connection.close();
	  }
	 catch (SQLException e) {
	  e.printStackTrace();
}
	}


	public List<Utilisateur> getAllUtilisateur(){
		 List<Utilisateur> utilisateurs = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Utilisateurs");
		        while (rs.next()) {
		            int id = rs.getInt("idUtilisateur");
		            String nom = rs.getString("nomUtilisateur");
		            String mdp  = rs.getString("mdpUtilisateur");
		            String post  = rs.getString("postUtilisateur");
		            utilisateurs.add(new Utilisateur(id, nom, mdp, post));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return utilisateurs;	
	}
	
	public Utilisateur getUtilisateur(String username, String mdpIn){
		Utilisateur utilisateur = null;
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Utilisateurs Where nomUtilisateur = " + username);
		        while (rs.next()) {
		        	if(rs.getString("mdpUtilisateur").equals(mdpIn)) { 
		            int id = rs.getInt("idUtilisateur");
		            String nom = rs.getString("nomUtilisateur");
		            String mdp  = rs.getString("mdpUtilisateur");
		            String post  = rs.getString("postUtilisateur");
		            utilisateur = new Utilisateur(id, nom, mdp, post);
		        	}
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return utilisateur;	
	}
	
	public void addUtilisateur (Utilisateur util) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(util.createTable());
		        statement.executeUpdate(util.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateUtilisateur (Utilisateur util, int id) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(util.createTable());
		        statement.executeUpdate(util.update(id));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteUtilisateur ( String id) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.executeUpdate(Utilisateur.delete(id));
	        connection.close();
	  }
 	 catch (SQLException e) {
	  e.printStackTrace();
   }
		
	}
	
	public List<Vente> getAllVente(){
		 List<Vente> ventes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Ventes");
		        while (rs.next()) {
		        	int idVente = rs.getInt("idVente");
		            String nomClient = rs.getString("nomClient");
		            String idProduit = rs.getString("idProduit");
		            int idUtilisateur = rs.getInt("idUtilisateur");
		            String idStock  = rs.getString("idStock");
		            Double prixVente  = rs.getDouble("prixVente");
		            int quantiter = rs.getInt("quantiter");
		            String date  = rs.getString("dateVente");
		            ventes.add(new Vente( nomClient, idProduit, idUtilisateur, idStock, prixVente, quantiter, date));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ventes;	
	}
	
	public List<Vente> searchVente(String motClee){
		 List<Vente> ventes = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Ventes WHERE idProduit LIKE " + motClee);
		        while (rs.next()) {
		        	int idVente = rs.getInt("idVente");
		            String nomClient = rs.getString("nomClient");
		            String idProduit = rs.getString("idProduit");
		            int idUtilisateur = rs.getInt("idUtilisateur");
		            String idStock  = rs.getString("idStock");
		            Double prixVente  = rs.getDouble("prixVente");
		            int quantiter = rs.getInt("quantiter");
		            String date  = rs.getString("dateVente");
		            ventes.add(new Vente( nomClient, idProduit, idUtilisateur, idStock, prixVente, quantiter, date));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ventes;	
	}
	
	public void addVente (Vente vt) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(vt.createTable());
		        statement.executeUpdate(vt.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updateVente (Vente vt, int idVente, String idClient, String idProduit, int idUtilisateur, String idStock) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(vt.createTable());
		        statement.executeUpdate(vt.update(idVente, idClient, idProduit, idUtilisateur,idStock));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deleteVente (Vente vt) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(vt.createTable());
	        statement.executeUpdate(vt.delete());
	        connection.close();
	  }
	 catch (SQLException e) {
	  e.printStackTrace();
  }
		
	}

	public List<Planning> getAllPlann(){
		 List<Planning> plannings = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("select * from Planning");
		        while (rs.next()) {
		        	String titre= rs.getString("titre");
		            
		            String date  = rs.getString("date");
		            String heure  = rs.getString("heure");
		            String commentaire= rs.getString("Commentaire");
		            plannings.add(new Planning(titre, date,heure, commentaire));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return plannings ;	
	}
	
	public List<Planning> searchPlann(String motClee){
		 List<Planning> plannings = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("SELECT * from Planning WHERE titre LIKE " + motClee);
		        while (rs.next()) {
		        	String titre= rs.getString("titre");    
		            String date  = rs.getString("date");
		            String heure  = rs.getString("heure");
		            String commentaire= rs.getString("Commentaire");
		            plannings.add(new Planning(titre, date,heure, commentaire));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return plannings ;	
	}
	
	public void addPlann (Planning plann) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(plann.createTable());
		        statement.executeUpdate(plann.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void updatePlanning (Planning plann, String titre) {
		 try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(plann.createTable());
		        statement.executeUpdate(plann.update(titre));
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	public void deletePlann (Planning plann) {
		try {
	        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
	        Statement statement = connection.createStatement();
	        statement.execute(plann.createTable());
	        statement.executeUpdate(plann.delete());
	        connection.close();
	  }
	 catch (SQLException e) {
	  e.printStackTrace();
}
	}
	
	
	public List<DepotRetrait> getAllDR(){
		 List<DepotRetrait> dr = new ArrayList<>();
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(DepotRetrait.createTable());
		        ResultSet rs = statement.executeQuery("select * from comptabiliter");
		        while (rs.next()) {
		        	int id = rs.getInt("id");
		            String type = rs.getString("type");
		            int montant = rs.getInt("montant");
		            String date = rs.getString("date");
		            String commentaire  = rs.getString("commentaire");
		            int totale = rs.getInt("totale");
		            dr.add(new DepotRetrait(type, montant, date, commentaire, totale));
		        }
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return dr;	
	}
	
	public void addDr (DepotRetrait dr) {
		  try {
		        Connection connection = DriverManager.getConnection(this.dbLocation, this.user, this.mdp);
		        Statement statement = connection.createStatement();
		        statement.execute(dr.createTable());
		        statement.executeUpdate(dr.addToDb());
		        connection.close();
		  }
	  	 catch (SQLException e) {
		  e.printStackTrace();
	    }
	}
	
	
}
