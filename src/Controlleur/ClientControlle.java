package Controlleur;


import model.Client;
import model.Database;

public class ClientControlle {
	private Database db;
	public ClientControlle() {
		db = new Database();
		
	}
	
	public  String quote(String s) {
	    return new StringBuilder()
	        .append('\'')
	        .append(s)
	        .append('\'')
	        .toString();
	}
	
	public void CreateClient( String nomClient, String prenomClient, String ddnClient, String adresseClient,
			String villeClient, String paysClient, String telClient) {
		Client clt = new Client(  0 ,quote(nomClient), quote(prenomClient), quote(ddnClient), quote(adresseClient),
				quote(villeClient),  quote(paysClient),  quote(telClient) );
		db.addClient(clt);
	};
}
