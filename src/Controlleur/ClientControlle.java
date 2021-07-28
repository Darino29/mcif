package Controlleur;
import java.util.List;

import model.Client;
import model.Database;
import model.Stock;

public class ClientControlle {
	private Database db;
	private UtilitaireControleur util;
	public ClientControlle() {
		db = new Database();
		util = new UtilitaireControleur();
		
		
	}
	
	
	public void CreateClient( String nomClient, String prenomClient, String ddnClient, String adresseClient,
			String villeClient, String paysClient, String telClient) {
		Client clt = new Client(  0 ,util.quote(nomClient), util.quote(prenomClient), util.quote(ddnClient), util.quote(adresseClient),
				util.quote(villeClient),  util.quote(paysClient),  util.quote(telClient) );
		db.addClient(clt);
	};
	
	public int editClient(String nom,String prenom, String ddn, String adresse, String ville, String phone, String pays, String date, String oldNom, String oldPrenom) {
		try {
			Client clt = new Client(  0 ,util.quote(nom), util.quote(prenom), util.quote(ddn), util.quote(adresse),
					util.quote(ville),  util.quote(pays),  util.quote(phone));
			db.updateClient(clt, util.quote(oldNom), util.quote(oldPrenom));
			return 0;
		}catch(Exception e){
			return 1;
		}
		
	};
	
	public List<Client> searchClient(String mot){
		String motClee = util.quote(mot+"%");
		List<Client> client = db.searchClient(motClee);
		return client;
		
	}
	
	public List<Client> allClient(){
		List<Client> client = db.getAllClient();
		return client;
		
	}
	
	public boolean supprClient(String nomClient, String prenomClient, String ddnClient, String adresseClient,
			String villeClient, String paysClient, String telClient) {
		try {
			Client clt = new Client(  0 ,util.quote(nomClient), util.quote(prenomClient), util.quote(ddnClient), util.quote(adresseClient),
					util.quote(villeClient),  util.quote(paysClient),  util.quote(telClient) );
			db.deleteClient(clt);
			System.out.println("supprimer");
			return true;
			
		}
		catch(Exception e){
			return false;
		}
	}
}
