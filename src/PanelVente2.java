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

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVente2 extends JPanel {
	private JTextField txtNom;
	private JTextField produit;
	private JTextField date;
	private JTextField vendeur;
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
	public PanelVente2() {
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
		lblCa.setBounds(237, 53, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDernierAchat = new JLabel("Date");
		lblDernierAchat.setBounds(237, 87, 62, 13);
		panel.add(lblDernierAchat);
		lblDernierAchat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDernierAchat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPays = new JLabel("Vendeur");
		lblPays.setBounds(237, 119, 97, 13);
		panel.add(lblPays);
		lblPays.setHorizontalAlignment(SwingConstants.LEFT);
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		produit = new JTextField();
		produit.setBounds(321, 50, 229, 24);
		panel.add(produit);
		produit.setColumns(10);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(321, 84, 229, 23);
		panel.add(date);
		
		vendeur = new JTextField();
		vendeur.setColumns(10);
		vendeur.setBounds(321, 116, 229, 24);
		panel.add(vendeur);
		
		client = new JTextField();
		client.setColumns(10);
		client.setBounds(321, 150, 229, 24);
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
				if(produit.getText().equals("") || date.getText().equals("") || vendeur.getText().equals("") || client.getText().equals("") || quantite.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
				String prod = produit.getText();
				String dates = date.getText();
				String vend = vendeur.getText();
				String clt = quantite.getText();
				
				date.setText("");
				produit.setText("");
				quantite.setText("");
				vendeur.setText("");
				JOptionPane.showMessageDialog(null, "Enregistrer");
        }
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(382, 410, 104, 35);
		add(btnNewButton_1);

	}
}
