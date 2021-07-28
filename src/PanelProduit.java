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

import Controlleur.ProduitControlleur;
import Controlleur.StockControlleur;
import model.Produit;
import model.Stock;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelProduit extends JPanel {
	private JTextField searchTxt;
	private JTextField produit;
	private JTextField prix;
	private JTextField description;
	private JTable table;
	private ACC parent;
	private String name = "Stock";
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	DefaultTableModel model;
	final Object[] row = new Object[3];

	/**
	 * Create the panel.
	 */
	public PanelProduit(ACC ppp) {
		parent = ppp;
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		searchTxt = new JTextField();
		searchTxt.setText("id");
		searchTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(searchTxt.getText().equals("id")) {
					searchTxt.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(searchTxt.getText().equals("")) {
					searchTxt.setText("id");
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
				 List<Produit> stock = new ArrayList<>();
				 ProduitControlleur prodC = new ProduitControlleur();
				if(searchTxt.getText().equals("")) {	
					 try {
						 stock = prodC.allProduit();
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
				else {
					try {
						 
						 stock = prodC.searchProduit(searchTxt.getText());
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
					 for (Produit stk : stock) {
						 	System.out.println(stk.toString());
							row[0] = stk.getidProduit();
							row[1] = stk.getPrix();
							row[2] = stk.getDescritpion();
							model.addRow(row) ;
						}
			}
		});
		search.setIcon(new ImageIcon(PanelProduit.class.getResource("/img/icons8-search-24.png")));
		search.setBounds(212, 10, 50, 40);
		add(search);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 62, 772, 4);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ajouter un produit", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 68, 389, 340);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCa = new JLabel("Produit");
		lblCa.setBounds(10, 75, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDernierAchat = new JLabel("Prix");
		lblDernierAchat.setBounds(10, 109, 97, 13);
		panel.add(lblDernierAchat);
		lblDernierAchat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDernierAchat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPays = new JLabel("Description");
		lblPays.setBounds(10, 139, 97, 24);
		panel.add(lblPays);
		lblPays.setHorizontalAlignment(SwingConstants.LEFT);
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		produit = new JTextField();
		produit.setBounds(100, 72, 229, 24);
		panel.add(produit);
		produit.setColumns(10);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(100, 106, 229, 23);
		panel.add(prix);
		
		description = new JTextField();
		description.setHorizontalAlignment(SwingConstants.TRAILING);
		description.setColumns(10);
		description.setBounds(100, 139, 229, 180);
		panel.add(description);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
        if( produit.getText().equals("") || prix.getText().equals("") || description.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
				String prod = produit.getText();
				String qte = prix.getText();
				String descrp = description.getText();
				ProduitControlleur prodC = new ProduitControlleur();
				prodC.CreateProduit( prod, qte, descrp);
				produit.setText("");
				prix.setText("");
				description.setText("");
				JOptionPane.showMessageDialog(null, "Enregistrer");
        }
				
			}
				
				
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(4, 410, 104, 35);
		add(btnNewButton_1);
		
		JButton edite = new JButton("Editer");
		edite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(produit.getText().equals("") || prix.getText().equals("") || description.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					int i=table.getSelectedRow();
					String qte = prix.getText();
					String prod = produit.getText();
					String descrp = description.getText();
					ProduitControlleur prodC = new ProduitControlleur();
					try {
						String oldId = model.getValueAt(i, 0).toString();
						prodC.editProduit(prod, qte, descrp, oldId);
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "selectionner un elements");
					}
					
				}
				
			}
		});
		edite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edite.setBounds(154, 410, 104, 35);
		add(edite);
		
		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					String qte = prix.getText();
					String prod = produit.getText();
					String descrp = description.getText();
					ProduitControlleur prodC = new ProduitControlleur();
					prodC.supprProduit(prod, qte, descrp);
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Supprim�");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selection� l'�lement � supprimer");

				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_1.setBounds(300, 410, 93, 35);
		add(btnNewButton_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 68, 379, 369);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				produit.setText(model.getValueAt(i, 0).toString());
				prix.setText(model.getValueAt(i, 1).toString());
				description.setText(model.getValueAt(i, 2).toString());
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Produit","Prix","Description"};
		
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
				 List<Produit> stock = new ArrayList<>();
				 ProduitControlleur prodC = new ProduitControlleur();
				 stock = prodC.allProduit();
				 for (Produit stk : stock) {
					 	System.out.println(stk.toString());
						row[0] = stk.getidProduit();
						row[1] = stk.getPrix();
						row[2] = stk.getDescritpion();
						model.addRow(row) ;
					}
			}
		});
		btnNewButton.setBounds(685, 29, 85, 21);
		add(btnNewButton);

	}
}
