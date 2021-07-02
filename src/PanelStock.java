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

public class PanelStock extends JPanel {
	private JTextField searchTxt;
	private JTextField produit;
	private JTextField quantite;
	private JTextField description;
	private JTable table;
	private String name = "Stock";
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	DefaultTableModel model;
	private JTextField id;
	final Object[] row = new Object[4];

	/**
	 * Create the panel.
	 */
	public PanelStock() {
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
				 List<Stock> stock = new ArrayList<>();
				 StockControlleur stck = new StockControlleur();
				if(searchTxt.getText().equals("")) {	
					 try {
						 stock = stck.allStock();
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
				else {
					try {
						 
						 stock = stck.searchStock(searchTxt.getText());
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
					 for (Stock stk : stock) {
						 	System.out.println(stk.toString());
							row[0] = stk.getIdStock();
							row[1] = stk.getIdProduit();
							row[2] = stk.getQteStock();
							row[3] = stk.getDesc();
							model.addRow(row) ;
						}
			}
		});
		search.setIcon(new ImageIcon(PanelStock.class.getResource("/img/icons8-search-24.png")));
		search.setBounds(212, 10, 50, 40);
		add(search);
		
		JButton btnCreer = new JButton("Imprimer");
		btnCreer.setForeground(new Color(240, 255, 240));
		btnCreer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreer.setBorderPainted(false);
		btnCreer.setBackground(new Color(255, 140, 0));
		btnCreer.setBounds(603, 9, 167, 40);
		add(btnCreer);
		
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
		
		JLabel lblDernierAchat = new JLabel("Quantite");
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
		
		quantite = new JTextField();
		quantite.setColumns(10);
		quantite.setBounds(100, 106, 229, 23);
		panel.add(quantite);
		
		description = new JTextField();
		description.setHorizontalAlignment(SwingConstants.TRAILING);
		description.setColumns(10);
		description.setBounds(100, 139, 229, 180);
		panel.add(description);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(100, 38, 229, 24);
		panel.add(id);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 43, 80, 13);
		panel.add(lblId);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
        if(id.getText().equals("") || produit.getText().equals("") || quantite.getText().equals("") || description.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
				String prod = produit.getText();
				String idStock = id.getText();
				String qte = quantite.getText();
				String descrp = description.getText();
				StockControlleur stck = new StockControlleur();
				stck.CreateStock(idStock, prod, qte, descrp);
				id.setText("");
				produit.setText("");
				quantite.setText("");
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
				if(id.getText().equals("") || produit.getText().equals("") || quantite.getText().equals("") || description.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					int i=table.getSelectedRow();
					String idStock = id.getText();
					String qte = quantite.getText();
					String prod = produit.getText();
					String descrp = description.getText();
					StockControlleur stck = new StockControlleur();
					try {
						String oldStock = model.getValueAt(i, 1).toString();
						String oldId = model.getValueAt(i, 0).toString();
						stck.editStock(idStock, prod, qte, descrp, oldId, oldStock);
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
					String idStock = id.getText();
					String qte = quantite.getText();
					String prod = produit.getText();
					String descrp = description.getText();
					StockControlleur stck = new StockControlleur();
					stck.supprStock(idStock, prod, qte, descrp);
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
				id.setText(model.getValueAt(i, 0).toString());
				produit.setText(model.getValueAt(i, 1).toString());
				quantite.setText(model.getValueAt(i, 2).toString());
				description.setText(model.getValueAt(i, 3).toString());
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID","Produit","Prix","Description"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

	}
}
