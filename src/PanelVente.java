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
import javax.swing.table.DefaultTableModel;

import Controlleur.ClientControlle;
import Controlleur.VenteControlleur;
import model.Client;
import model.Vente;

import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class PanelVente extends JPanel {
	private JTextField searchTxt;
	private JTable table;
	private ACC parent;
	private String name = "Vente";
	DefaultTableModel model;
	final Object[] row = new Object[7];
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Create the panel.
	 */
	public PanelVente(ACC par) {
		parent = par;
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		searchTxt = new JTextField();
		searchTxt.setText("Produit");
		searchTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(searchTxt.getText().equals("Produit")) {
					searchTxt.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(searchTxt.getText().equals("")) {
					searchTxt.setText("");
				}
			}
		});
		searchTxt.setForeground(Color.GRAY);
		searchTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchTxt.setColumns(10);
		searchTxt.setBounds(10, 10, 201, 40);
		add(searchTxt);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.getRowCount() > 0) {
				    for (int i = model.getRowCount() - 1; i > -1; i--) {
				        model.removeRow(i);
				    }
				}
				 List<Vente> ventes = new ArrayList<>();
				 VenteControlleur vC = new VenteControlleur();
				if(searchTxt.getText().equals("")) {	
					 try {
						 ventes = vC.allVente();
						 
					 }catch(Exception e1) {
						 JOptionPane.showMessageDialog(null, "base de donner introuvable");
					 }
				}
				else {
					try {
						 
						 ventes = vC.searchVente(searchTxt.getText());
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
					 for (Vente vt : ventes) {
						 	
							row[0] = vt.getIdProduit();
							row[1] = vt.getDateVente();
							row[2] = vt.getIdUtilisateur();
							row[3] = vt.getnomClient();
							row[4] =vt.getPrixVente();
							row[5] = vt.getQuantiter();
							row[6] = vt.getIdStock();
							model.addRow(row) ;
						}
			}

		});
		btnNewButton.setIcon(new ImageIcon(PanelVente.class.getResource("/img/icons8-search-24.png")));
		btnNewButton.setBounds(212, 10, 50, 40);
		add(btnNewButton);
		
		JButton btnCreer = new JButton("Nouvelle Vente  +");
		btnCreer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				parent.changerMenu();
			}
			
		});
		btnCreer.setForeground(new Color(240, 255, 240));
		btnCreer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreer.setBorderPainted(false);
		btnCreer.setBackground(new Color(255, 140, 0));
		btnCreer.setBounds(603, 9, 167, 40);
		add(btnCreer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 85, 772, 4);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 99, 772, 356);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Produit","Date","Vendeur","Client","Prix","Quantite","idStock"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblVentesValidees = new JLabel("Ventes validees ");
		lblVentesValidees.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentesValidees.setForeground(Color.GRAY);
		lblVentesValidees.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVentesValidees.setBackground(Color.WHITE);
		lblVentesValidees.setBounds(4, 65, 128, 19);
		add(lblVentesValidees);
		
		JButton btnNewButton_1 = new JButton("refresh");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.getRowCount() > 0) {
				    for (int i = model.getRowCount() - 1; i > -1; i--) {
				        model.removeRow(i);
				    }
				}
				 List<Vente> ventes = new ArrayList<>();
				 VenteControlleur vC = new VenteControlleur();
				 ventes = vC.allVente();
				 for (Vente vt : ventes) {
					 	
						row[0] = vt.getIdProduit();
						row[1] = vt.getDateVente();
						row[2] = vt.getIdUtilisateur();
						row[3] = vt.getnomClient();
						row[4] =vt.getPrixVente();
						row[5] = vt.getQuantiter();
						row[6] = vt.getIdStock();
						model.addRow(row) ;
					}
				
			}
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(379, 19, 89, 23);
		add(btnNewButton_1);

	}
	
}
