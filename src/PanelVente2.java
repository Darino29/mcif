import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
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

import Controlleur.StockControlleur;
import Controlleur.VenteControlleur;
import model.Utilisateur;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVente2 extends JPanel {
	private Utilisateur user;
	private JTextField txtNom;
	private JTextField produit;
	private JTextField client;
	private JTextField prix;
	private JTextField quantite;
	private String name = "vente2";
	private JTextField idStock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelVente2(Utilisateur user) {
		this.user = user;
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		txtNom = new JTextField();
		txtNom.setText("Produit");
		txtNom.setForeground(Color.GRAY);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNom.setColumns(10);
		txtNom.setBounds(10, 10, 201, 40);
		add(txtNom);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PanelVente2.class.getResource("/img/icons8-search-24.png")));
		btnNewButton.setBounds(212, 10, 50, 40);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 62, 772, 4);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ajouter un produit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 68, 772, 340);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCa = new JLabel("Produit");
		lblCa.setBounds(237, 121, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		produit = new JTextField();
		produit.setBounds(321, 117, 229, 24);
		panel.add(produit);
		produit.setColumns(10);
		
		client = new JTextField();
		client.setColumns(10);
		client.setBounds(321, 152, 229, 24);
		panel.add(client);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(321, 184, 229, 24);
		panel.add(prix);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setHorizontalAlignment(SwingConstants.LEFT);
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(237, 153, 97, 13);
		panel.add(lblClient);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrix.setBounds(237, 187, 97, 13);
		panel.add(lblPrix);
		
		quantite = new JTextField();
		quantite.setColumns(10);
		quantite.setBounds(321, 218, 229, 24);
		panel.add(quantite);
		
		JLabel lblTotal = new JLabel("Quantite");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(237, 221, 97, 13);
		panel.add(lblTotal);
		
		idStock = new JTextField();
		idStock.setColumns(10);
		idStock.setBounds(321, 252, 229, 24);
		panel.add(idStock);
		
		JLabel lblIdstock = new JLabel("idStock");
		lblIdstock.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdstock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdstock.setBounds(237, 257, 97, 13);
		panel.add(lblIdstock);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(produit.getText().equals("")  || client.getText().equals("") || quantite.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					String prod = produit.getText();
					String clt = client.getText();
					String prixvente = prix.getText();
					String qte = quantite.getText();
					String stk = idStock.getText();
					VenteControlleur vC = new VenteControlleur ();
					String resultat = vC.createVente(prod, clt, prixvente, qte, stk, user);
					produit.setText("");
					quantite.setText("");
					prix.setText("");
					client.setText("");
					idStock.setText("");
					JOptionPane.showMessageDialog(null, resultat);
        }
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(382, 410, 104, 35);
		add(btnNewButton_1);

	}
}
