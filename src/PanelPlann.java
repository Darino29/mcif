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



import Controlleur.PlanningControlleur;
import Controlleur.StockControlleur;
import model.Planning;
import model.Stock;

import javax.swing.border.EtchedBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelPlann extends JPanel {
	private JTextField searchTxt;
	private JTextField titre;
	private JTextField commentaire;
	private JTable table;
	private JTextField date;
	DefaultTableModel model;
	private String name = "PanelPlann";
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	final Object[] row = new Object[4];
	private JTextField heure;
	/**
	 * Create the panel.
	 */
	public PanelPlann() {
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		searchTxt = new JTextField();
		searchTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(searchTxt.getText().equals("Titre")) {
					searchTxt.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(searchTxt.getText().equals("")) {
					searchTxt.setText("Titre");
				}
			}
		});
		searchTxt.setText("Titre");
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
				 List<Planning> plann = new ArrayList<>();
				 PlanningControlleur plnn = new PlanningControlleur();
				if(searchTxt.getText().equals("")) {	
					 try {
						 plann = plnn.allPlanning();
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
				else {
					try {
						 
						 plann = plnn.searchPlann(searchTxt.getText());
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
				}
					 for (Planning pln : plann) {
						 	System.out.println(pln.toString());
							row[0] = pln.getTitre();
							row[1] = pln.getDate();
							row[2] = pln.getCommentaire();
							row[3] = pln.getHeure();
							
							model.addRow(row) ;
						}
			
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelPlann.class.getResource("/img/icons8-search-24.png")));
		btnNewButton.setBounds(212, 10, 50, 40);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 62, 772, 4);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ajouter une T\u00E2che", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 68, 389, 340);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCa = new JLabel("Titre");
		lblCa.setBounds(10, 53, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDernierAchat = new JLabel("Date");
		lblDernierAchat.setBounds(10, 87, 62, 13);
		panel.add(lblDernierAchat);
		lblDernierAchat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDernierAchat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPays = new JLabel("Commentaire");
		lblPays.setBounds(10, 151, 116, 13);
		panel.add(lblPays);
		lblPays.setHorizontalAlignment(SwingConstants.LEFT);
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		titre = new JTextField();
		titre.setBounds(110, 50, 229, 24);
		panel.add(titre);
		titre.setColumns(10);
		
		commentaire = new JTextField();
		commentaire.setColumns(10);
		commentaire.setBounds(110, 148, 229, 151);
		panel.add(commentaire);
		
		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setBounds(110, 83, 229, 24);
		panel.add(date);
		date.setText("jj-mm-aaaa");
		date.setForeground(Color.GRAY);
		date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date.setColumns(10);
		
		heure = new JTextField();
		heure.setText("hh : mm");
		heure.setHorizontalAlignment(SwingConstants.CENTER);
		heure.setForeground(Color.GRAY);
		heure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		heure.setColumns(10);
		heure.setBounds(110, 117, 229, 24);
		panel.add(heure);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeure.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeure.setBounds(10, 121, 62, 13);
		panel.add(lblHeure);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(titre.getText().equals("") || date.getText().equals("")|| heure.getText().equals("") || commentaire.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
				String titres = titre.getText();
				String dates = date.getText();
				String heures = heure.getText();
				String coms = commentaire.getText();
				PlanningControlleur plnn = new PlanningControlleur();
				plnn.CreatePlanning(titres, dates,heures,coms);
				
				titre.setText("");
				date.setText("");
				heure.setText("");
				commentaire.setText("");
				
				JOptionPane.showMessageDialog(null, "Enregistrer");
        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(4, 410, 104, 35);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titre.getText().equals("") || date.getText().equals("")| heure.getText().equals("") || commentaire.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					int i=table.getSelectedRow();
					String titres = titre.getText();
					String dates = date.getText();
					String heures = heure.getText();
					String coms = commentaire.getText();
					PlanningControlleur plnn = new PlanningControlleur();					
					try {
						String oldTitre= model.getValueAt(i, 0).toString();
						
						plnn.editPlann(titres, dates,heures, coms,oldTitre);
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "selectionner un element");
					}
					
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(154, 410, 104, 35);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					
					String titres = titre.getText();
					String dates = date.getText();
					String heures = heure.getText();
					String coms = commentaire.getText();
					PlanningControlleur plnn = new PlanningControlleur();
					plnn.supprPlann(titres, dates,heures,coms);
					
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Supprimé");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selectioné l'élement a supprimer");

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
				titre.setText(model.getValueAt(i, 0).toString());
				date.setText(model.getValueAt(i, 1).toString());
				heure.setText(model.getValueAt(i, 2).toString());
				commentaire.setText(model.getValueAt(i, 3).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Titre","Date","Heure","Commentaire"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fonction refreshh
			}
			
		});
		btnNewButton_2.setBounds(691, 29, 85, 21);
		add(btnNewButton_2);

	}
}
