package Controlleur;
import model.Client;
import model.Database;

public class ClientControlle {
	private Database db;
	private UtilitaireControleur util;
	public ClientControlle() {
		db = new Database();
		util = new UtilitaireControleur();
		
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
		Client clt = new Client(  0 ,util.quote(nomClient), util.quote(prenomClient), util.quote(ddnClient), util.quote(adresseClient),
				util.quote(villeClient),  util.quote(paysClient),  util.quote(telClient) );
		db.addClient(clt);
	};
}
