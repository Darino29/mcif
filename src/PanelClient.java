import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import Controlleur.ClientControlle;
import Controlleur.StockControlleur;
import model.Client;
import model.Stock;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
public class PanelClient extends JPanel {
	private JTextField searchTxt;
	private JTextField textNom;
	private JTextField txtPrenom;
	private JTable table;
	private JTextField txtAdresse;
	private JTextField txtVille;
	private JTextField txtPhone;
	private JTextField txtDdn;
	private JComboBox combobox;
	DefaultTableModel model;
	final Object[] row = new Object[7];
	private String name = "client";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelClient() {
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		searchTxt = new JTextField();
		searchTxt.setText("Nom");
		searchTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(searchTxt.getText().equals("Nom")) {
					searchTxt.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(searchTxt.getText().equals("")) {
					searchTxt.setText("Nom");
				}
			}
		});
		searchTxt.setForeground(Color.GRAY);
		searchTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchTxt.setColumns(10);
		searchTxt.setBounds(10, 10, 201, 40);
		add(searchTxt);
		
		JButton search = new JButton("");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.getRowCount() > 0) {
				    for (int i = model.getRowCount() - 1; i > -1; i--) {
				        model.removeRow(i);
				    }
				}
				 List<Client> client = new ArrayList<>();
				 ClientControlle clt = new ClientControlle();
				if(searchTxt.getText().equals("")) {	
					 try {
						 client = clt.allClient();
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
				else {
					try {
						 
						 client = clt.searchClient(searchTxt.getText());
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
					 for (Client cl : client) {
						 	System.out.println(cl.toString());
							row[0] = cl.getNomClient();
							row[1] = cl.getPrenomClient();
							row[2] = cl.getDdnClient();
							row[3] = cl.getAdresseClient();
							row[4] = cl.getVilleClient();
							row[5] = cl.getPaysClient();
							row[6] = cl.getTelClient();
							model.addRow(row) ;
						}
			}
				
		});
		search.setIcon(new ImageIcon(PanelClient.class.getResource("/img/icons8-search-24.png")));
		search.setBounds(212, 10, 50, 40);
		add(search);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 62, 772, 4);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ajouter un client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 68, 371, 340);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCa = new JLabel("Nom");
		lblCa.setBounds(10, 35, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDernierAchat = new JLabel("Prenom");
		lblDernierAchat.setBounds(10, 67, 62, 13);
		panel.add(lblDernierAchat);
		lblDernierAchat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDernierAchat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPays = new JLabel("Date de Naissance");
		lblPays.setBounds(10, 99, 144, 13);
		panel.add(lblPays);
		lblPays.setHorizontalAlignment(SwingConstants.LEFT);
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textNom = new JTextField();
		textNom.setBounds(110, 27, 249, 24);
		panel.add(textNom);
		textNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(110, 60, 249, 23);
		panel.add(txtPrenom);
		
		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(130, 123, 229, 44);
		panel.add(txtAdresse);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(10, 136, 88, 13);
		panel.add(lblAdresse);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVille.setBounds(10, 180, 88, 13);
		panel.add(lblVille);
		
		txtVille = new JTextField();
		txtVille.setColumns(10);
		txtVille.setBounds(130, 177, 229, 23);
		panel.add(txtVille);
		
		JLabel lblPays_1 = new JLabel("Pays");
		lblPays_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPays_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPays_1.setBounds(10, 215, 88, 13);
		panel.add(lblPays_1);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(130, 243, 229, 23);
		panel.add(txtPhone);
		
		JLabel lblPays_1_1 = new JLabel("Phone");
		lblPays_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPays_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPays_1_1.setBounds(10, 248, 88, 13);
		panel.add(lblPays_1_1);
		
		
		String[] choix = {"Afghanistan", "Afrique du Sud", "Akrotiri", "Albanie", "Alg\u00E9rie", "Allemagne", "Andorre", "Angola", "Anguilla", "Antarctique", "Antigua-et-Barbuda", "Arabie saoudite", "Arctic Ocean", "Argentine", "Arm\u00E9nie", "Aruba", "Ashmore and Cartier Islands", "Atlantic Ocean", "Australie", "Autriche", "Azerba\u00EFdjan", "Bahamas", "Bahre\u00EFn", "Bangladesh", "Barbade", "Belau", "Belgique", "Belize", "B\u00E9nin", "Bermudes", "Bhoutan", "Bi\u00E9lorussie", "Birmanie", "Bolivie", "Bosnie-Herz\u00E9govine", "Botswana", "Br\u00E9sil", "Brunei", "Bulgarie", "Burkina Faso", "Burundi", "Cambodge", "Cameroun", "Canada", "Cap-Vert", "Chili", "Chine", "Chypre", "Clipperton Island", "Colombie", "Comores", "Congo", "Coral Sea Islands", "Cor\u00E9e du Nord", "Cor\u00E9e du Sud", "Costa Rica", "C\u00F4te d'Ivoire", "Croatie", "Cuba", "Curacao", "Danemark", "Dhekelia", "Djibouti", "Dominique", "\u00C9gypte", "\u00C9mirats arabes unis", "\u00C9quateur", "\u00C9rythr\u00E9e", "Espagne", "Estonie", "\u00C9tats-Unis", "\u00C9thiopie", "ex-R\u00E9publique yougoslave de Mac\u00E9doine", "Finlande", "France", "Gabon", "Gambie", "Gaza Strip", "G\u00E9orgie", "Ghana", "Gibraltar", "Gr\u00E8ce", "Grenade", "Groenland", "Guam", "Guatemala", "Guernsey", "Guin\u00E9e", "Guin\u00E9e \u00E9quatoriale", "Guin\u00E9e-Bissao", "Guyana", "Ha\u00EFti", "Honduras", "Hong Kong", "Hongrie", "Ile Bouvet", "Ile Christmas", "Ile Norfolk", "Iles Cayman", "Iles Cook", "Iles des Cocos (Keeling)", "Iles Falkland", "Iles F\u00E9ro\u00E9", "Iles Fidji", "Iles G\u00E9orgie du Sud et Sandwich du Sud", "Iles Heard et McDonald", "Iles Marshall", "Iles Pitcairn", "Iles Salomon", "Iles Svalbard et Jan Mayen", "Iles Turks-et-Caicos", "Iles Vierges am\u00E9ricaines", "Iles Vierges britanniques", "Inde", "Indian Ocean", "Indon\u00E9sie", "Iran", "Iraq", "Irlande", "Islande", "Isra\u00EBl", "Italie", "Jama\u00EFque", "Jan Mayen", "Japon", "Jersey", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati", "Kosovo", "Kowe\u00EFt", "Laos", "Lesotho", "Lettonie", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie", "Luxembourg", "Macao", "Madagascar", "Malaisie", "Malawi", "Maldives", "Mali", "Malte", "Man, Isle of", "Mariannes du Nord", "Maroc", "Maurice", "Mauritanie", "Mexique", "Micron\u00E9sie", "Moldavie", "Monaco", "Monde", "Mongolie", "Mont\u00E9n\u00E9gro", "Montserrat", "Mozambique", "Namibie", "Nauru", "Navassa Island", "N\u00E9pal", "Nicaragua", "Niger", "Nigeria", "Niou\u00E9", "Norv\u00E8ge", "Nouvelle-Cal\u00E9donie", "Nouvelle-Z\u00E9lande", "Oman", "Ouganda", "Ouzb\u00E9kistan", "Pacific Ocean", "Pakistan", "Panama", "Papouasie-Nouvelle-Guin\u00E9e", "Paracel Islands", "Paraguay", "Pays-Bas", "P\u00E9rou", "Philippines", "Pologne", "Polyn\u00E9sie fran\u00E7aise", "Porto Rico", "Portugal", "Qatar", "R\u00E9publique centrafricaine", "R\u00E9publique d\u00E9mocratique du Congo", "R\u00E9publique dominicaine", "Roumanie", "Royaume-Uni", "Russie", "Rwanda", "Sahara occidental", "Saint-Barth\u00E9lemy", "Saint-Christophe-et-Ni\u00E9v\u00E8s", "Sainte-H\u00E9l\u00E8ne", "Sainte-Lucie", "Saint-Marin", "Saint-Martin", "Saint-Pierre-et-Miquelon", "Saint-Si\u00E8ge", "Saint-Vincent-et-les-Grenadines", "Salvador", "Samoa", "Samoa am\u00E9ricaines", "Sao Tom\u00E9-et-Principe", "S\u00E9n\u00E9gal", "Serbie", "Seychelles", "Sierra Leone", "Singapour", "Sint Maarten", "Slovaquie", "Slov\u00E9nie", "Somalie", "Soudan", "Soudan du Sud", "Southern Ocean", "Spratly Islands", "Sri Lanka", "Su\u00E8de", "Suisse", "Suriname", "Swaziland", "Syrie", "Tadjikistan", "Ta\u00EFwan", "Tanzanie", "Tchad", "Terres australes fran\u00E7aises", "Territoire britannique de l'Oc\u00E9an Indien", "Tha\u00EFlande", "Timor Oriental", "Togo", "Tok\u00E9laou", "Tonga", "Trinit\u00E9-et-Tobago", "Tunisie", "Turkm\u00E9nistan", "Turquie", "Tuvalu", "Ukraine", "Union europ\u00E9enne", "Uruguay", "Vanuatu", "Venezuela", "Vi\u00EAt Nam", "Wake Island", "Wallis-et-Futuna", "West Bank", "Y\u00E9men", "Zambie", "Zimbabwe"};
	    combobox = new JComboBox(choix);
		combobox.setBounds(130, 210, 229, 21);
		panel.add(combobox);
		
		txtDdn = new JTextField();
		txtDdn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDdn.setText("JJ/MM/AAAA");
		txtDdn.setForeground(Color.GRAY);
		txtDdn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDdn.setColumns(10);
		txtDdn.setBounds(158, 95, 201, 23);
		panel.add(txtDdn);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textNom.getText().equals("") || txtPrenom.getText().equals("") || txtDdn.getText().equals("") || 
						txtAdresse.getText().equals("") || txtVille.getText().equals("") || txtPhone.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else {
	                String Nom = textNom.getText();
	                String Prenom = txtPrenom.getText();
	                String Ddn = txtDdn.getText();
	                String  Adresse = txtAdresse.getText();
	                String Ville = txtVille.getText();
	                String  Phone = txtPhone.getText();
	                Object pays = combobox.getSelectedItem();
	                String date = txtDdn.getText();
	                String paysS = pays.toString();
	                System.out.println(Nom +"    "+ Prenom + " "+ Ddn +" "+ Adresse + " " + Ville + " "+ Phone + " " + pays + " " + date);
	                ClientControlle cC = new ClientControlle();
	                cC.CreateClient( Nom, Prenom, Ddn, Adresse, Ville, paysS, Phone);
	                JOptionPane.showMessageDialog(null, "Enregistrer");
	                textNom.setText("");
	                txtPrenom.setText("");
	                txtDdn.setText("");
	                txtAdresse.setText("");
	                txtVille.setText("");
	                txtPhone.setText("");
				}
	                
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(4, 410, 104, 35);
		add(btnNewButton_1);
		
		JButton edit = new JButton("Editer");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textNom.getText().equals("") || txtPrenom.getText().equals("") || txtDdn.getText().equals("") || 
						txtAdresse.getText().equals("") || txtVille.getText().equals("") || txtPhone.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else {
					int i=table.getSelectedRow();
					 String Nom = textNom.getText();
		             String Prenom = txtPrenom.getText();
		             String Ddn = txtDdn.getText();
		             String  Adresse = txtAdresse.getText();
		             String Ville = txtVille.getText();
		             String  Phone = txtPhone.getText();
		             Object pays = combobox.getSelectedItem();
		             String date = txtDdn.getText();
		             String paysS = pays.toString();
		             ClientControlle cC = new ClientControlle();
		             try {
							String oldNom = model.getValueAt(i, 0).toString();
							String oldPrenom = model.getValueAt(i, 1).toString();
							cC.editClient(Nom, Prenom, Ddn, Adresse, Ville, Phone, paysS, date, oldNom, oldPrenom);
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "selectionner un elements");
						}
			}
		}
		});
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		edit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit.setBounds(142, 410, 104, 35);
		add(edit);
		
		JButton suppr = new JButton("Supprimer");
		suppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					 String Nom = textNom.getText();
		             String Prenom = txtPrenom.getText();
		             String Ddn = txtDdn.getText();
		             String  Adresse = txtAdresse.getText();
		             String Ville = txtVille.getText();
		             String  Phone = txtPhone.getText();
		             Object pays = combobox.getSelectedItem();
		             String date = txtDdn.getText();
		             String paysS = pays.toString();
		             StockControlleur stck = new StockControlleur();
		             ClientControlle cC = new ClientControlle();
		             cC.supprClient(Nom, Prenom, Ddn, Adresse, Ville, paysS, paysS);
					 model.removeRow(i);
					 JOptionPane.showMessageDialog(null, "Supprim�");
					}
				else
					{
					JOptionPane.showMessageDialog(null, "Selection� l'�lement � supprimer");

					}
			}
		});
		suppr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		suppr.setBounds(282, 410, 93, 35);
		add(suppr);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(377, 68, 399, 369);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				textNom.setText(model.getValueAt(i, 0).toString());
				txtPrenom.setText(model.getValueAt(i, 1).toString());
				txtDdn.setText(model.getValueAt(i, 2).toString());
				txtAdresse.setText(model.getValueAt(i, 3).toString());
				txtVille.setText(model.getValueAt(i, 4).toString());
				txtPhone.setText(model.getValueAt(i, 6).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Nom","Prenom","Ddn","Adresse","Ville","Pays","Phone"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.getRowCount() > 0) {
				    for (int i = model.getRowCount() - 1; i > -1; i--) {
				        model.removeRow(i);
				    }
				}
				 List<Client> client = new ArrayList<>();
				 ClientControlle clt = new ClientControlle();
				 client = clt.allClient();
				 for (Client cl : client) {
					 	System.out.println(cl.toString());
						row[0] = cl.getNomClient();
						row[1] = cl.getPrenomClient();
						row[2] = cl.getDdnClient();
						row[3] = cl.getAdresseClient();
						row[4] = cl.getVilleClient();
						row[5] = cl.getPaysClient();
						row[6] = cl.getTelClient();
						model.addRow(row) ;
					}
			}
		});
		btnNewButton.setBounds(685, 29, 85, 21);
		add(btnNewButton);

	}
}
