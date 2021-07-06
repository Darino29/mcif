import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controlleur.DepotRetraitContolleur;
import Controlleur.UtilitaireControleur;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCaisse extends JPanel {
	private JTextField txtMnt;
	private JTextField txtCmt;
	private String name = "caisse";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelCaisse() {
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		
		JButton btnNewButton = new JButton("                  Fond de caisse");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(PanelCaisse.class.getResource("/img/icons8-inbox-40.png")));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(0, 0, 384, 43);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("                Encaissement");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon(PanelCaisse.class.getResource("/img/icons8-money-40.png")));
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.setBounds(394, 0, 386, 43);
		add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 384, 4);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(394, 44, 386, 4);
		add(separator_1);
		
		JComboBox txttype = new JComboBox();
		txttype.setFocusable(false);
		txttype.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txttype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txttype.setModel(new DefaultComboBoxModel(new String[] {"Retrait", "Depot"}));
		txttype.setBounds(0, 58, 384, 40);
		add(txttype);
		
		txtMnt = new JTextField();
		txtMnt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMnt.setText(null);
				txtMnt.requestFocus();
				removePlaceholderStyle(txtMnt);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMnt.getText().length() == 0){
					addPlaceholderStyle(txtMnt);
					txtMnt.setText("Montant Retrait / Depot");
				}
			}
		});
		txtMnt.setText("Montant Retrait / Depot");
		txtMnt.setName("");
		txtMnt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMnt.setBounds(0, 104, 384, 40);
		add(txtMnt);
		txtMnt.setColumns(10);
		
		addPlaceholderStyle(txtMnt);
		
		txtCmt = new JTextField();
		txtCmt.setForeground(Color.GRAY);
		txtCmt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCmt.getText().length() == 0){
					addPlaceholderStyle(txtCmt);
					txtCmt.setText("Commentaire");
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				txtCmt.setText(null);
				txtCmt.requestFocus();
				removePlaceholderStyle(txtCmt);
				
			}
		});
		txtCmt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCmt.setText("Commentaire");
		txtCmt.setBounds(0, 152, 384, 40);
		add(txtCmt);
		txtCmt.setColumns(10);
		addPlaceholderStyle(txtCmt);
		
		JButton btnSave = new JButton("Sauvegarder");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtMnt.getText().equals(" ") || txtCmt.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					String  montant = txtMnt.getText();
	                Object typeS = txttype.getSelectedItem();
	                String commentaire = txtCmt.getText();
	                String type = typeS.toString();
	                DepotRetraitContolleur dr = new DepotRetraitContolleur();
	                String result = dr.CreateDR(type, montant, commentaire);
	                JOptionPane.showMessageDialog(null, result);
			}
			}
		});
		btnSave.setForeground(new Color(240, 255, 240));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(255, 140, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(269, 204, 115, 40);
		add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Unite");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(394, 53, 128, 20);
		add(lblNewLabel);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setBackground(Color.WHITE);
		lblQuantite.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantite.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantite.setBounds(521, 53, 128, 20);
		add(lblQuantite);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(652, 53, 128, 20);
		add(lblTotal);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(394, 71, 386, 4);
		add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("2000 rupees");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(394, 83, 128, 25);
		add(lblNewLabel_1);
		
		JLabel rp2000 = new JLabel("0");
		rp2000.setHorizontalAlignment(SwingConstants.CENTER);
		rp2000.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rp2000.setBounds(652, 83, 128, 25);
		add(rp2000);
		
		JLabel rp1000 = new JLabel("0");
		rp1000.setHorizontalAlignment(SwingConstants.CENTER);
		rp1000.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rp1000.setBounds(652, 118, 128, 25);
		add(rp1000);
		

		JLabel rp500 = new JLabel("0");
		rp500.setHorizontalAlignment(SwingConstants.CENTER);
		rp500.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rp500.setBounds(652, 152, 128, 25);
		add(rp500);
		

		JLabel rp200 = new JLabel("0");
		rp200.setHorizontalAlignment(SwingConstants.CENTER);
		rp200.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rp200.setBounds(652, 187, 128, 25);
		add(rp200);
		
		JLabel rp100 = new JLabel("0");
		rp100.setHorizontalAlignment(SwingConstants.CENTER);
		rp100.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rp100.setBounds(652, 222, 128, 25);
		add(rp100);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(400, 145, 375, 3);
		add(separator_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("500 rupees");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1.setBounds(394, 152, 128, 25);
		add(lblNewLabel_1_2_1);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Object valeur = comboBox_1.getSelectedItem();
	             String stringvalue = valeur.toString();
	             UtilitaireControleur utilitaire = new UtilitaireControleur();
	             String total = utilitaire.calculer(2000, stringvalue);
	             rp2000.setText(total);
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1.setBounds(531, 83, 100, 25);
		add(comboBox_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(400, 110, 375, 3);
		add(separator_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("1000 rupees");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(394, 118, 128, 25);
		add(lblNewLabel_1_2);
		
		JComboBox comboBox1000 = new JComboBox();
		comboBox1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Object valeur = comboBox1000.getSelectedItem();
	             String stringvalue = valeur.toString();
	             UtilitaireControleur utilitaire = new UtilitaireControleur();
	             String total = utilitaire.calculer(1000, stringvalue);
	             rp1000.setText(total);
			}
		});
		comboBox1000.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox1000.setBounds(531, 118, 100, 25);
		add(comboBox1000);
		
		
		JComboBox comboBox500 = new JComboBox();
		comboBox500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object valeur = comboBox500.getSelectedItem();
	             String stringvalue = valeur.toString();
	             UtilitaireControleur utilitaire = new UtilitaireControleur();
	             String total = utilitaire.calculer(500, stringvalue);
	             rp500.setText(total);
			}

		});
		comboBox500.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox500.setBounds(531, 155, 100, 25);
		add(comboBox500);
		
		
		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setBounds(400, 182, 375, 3);
		add(separator_3_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("200 rupees");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1_1.setBounds(394, 187, 128, 25);
		add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox200 = new JComboBox();
		comboBox200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object valeur = comboBox200.getSelectedItem();
	             String stringvalue = valeur.toString();
	             UtilitaireControleur utilitaire = new UtilitaireControleur();
	             String total = utilitaire.calculer(200, stringvalue);
	             rp200.setText(total);
			}
		});
		comboBox200.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox200.setBounds(531, 190, 100, 25);
		add(comboBox200);
		
		
		JSeparator separator_3_1_1_1 = new JSeparator();
		separator_3_1_1_1.setBounds(400, 218, 375, 3);
		add(separator_3_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("100 rupees");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1_1_1.setBounds(394, 222, 128, 25);
		add(lblNewLabel_1_2_1_1_1);
		
		JComboBox comboBox100 = new JComboBox();
		comboBox100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Object valeur = comboBox100.getSelectedItem();
	             String stringvalue = valeur.toString();
	             UtilitaireControleur utilitaire = new UtilitaireControleur();
	             String total = utilitaire.calculer(100, stringvalue);
	             rp100.setText(total);
			}
		});
		comboBox100.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox100.setBounds(531, 225, 100, 25);
		add(comboBox100);
		
		
		
		JButton txtTotal = new JButton("                                             Total 0");
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTotal.setBorderPainted(false);
		txtTotal.setBackground(Color.ORANGE);
		txtTotal.setBounds(394, 257, 386, 25);
		add(txtTotal);
		
		JButton btnCalculer = new JButton("Calculer");
		btnCalculer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String total2000 = rp2000.getText();
				String total1000 = rp1000.getText();
				String total500 = rp500.getText();
				String total200 = rp200.getText();
				String total100 = rp100.getText();
				UtilitaireControleur utilitaire = new UtilitaireControleur();
				txtTotal.setText(utilitaire.calculeTotale(total2000, total1000, total500, total200, total100));
			}
		});
		btnCalculer.setForeground(new Color(240, 255, 240));
		btnCalculer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculer.setBorderPainted(false);
		btnCalculer.setBackground(new Color(255, 140, 0));
		btnCalculer.setBounds(665, 281, 115, 40);
		add(btnCalculer);
		

	}
	
public void removePlaceholderStyle(JTextField textfield) {
	Font  font = textfield.getFont();
	font = font.deriveFont(Font.ITALIC);
	textfield.setFont(font);
	textfield.setForeground(Color.gray);
}
public void addPlaceholderStyle(JTextField textfield) {
	Font  font = textfield.getFont();
	font = font.deriveFont(Font.PLAIN);
	textfield.setFont(font);
	textfield.setForeground(Color.gray);
}
}
