import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.AbstractListModel;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFocusable(false);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Retrait", "Depot"}));
		comboBox.setBounds(0, 58, 384, 40);
		add(comboBox);
		
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
		
		JLabel lblNewLabel_1_1 = new JLabel("0");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(652, 83, 128, 25);
		add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
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
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1_1.setBounds(531, 118, 100, 25);
		add(comboBox_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(652, 118, 128, 25);
		add(lblNewLabel_1_1_1);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(400, 145, 375, 3);
		add(separator_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("500 rupees");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1.setBounds(394, 152, 128, 25);
		add(lblNewLabel_1_2_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1_1_1.setBounds(531, 155, 100, 25);
		add(comboBox_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(652, 152, 128, 25);
		add(lblNewLabel_1_1_1_1);
		
		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setBounds(400, 182, 375, 3);
		add(separator_3_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("200 rupees");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1_1.setBounds(394, 187, 128, 25);
		add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1_1_1_1.setBounds(531, 190, 100, 25);
		add(comboBox_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(652, 187, 128, 25);
		add(lblNewLabel_1_1_1_1_1);
		
		JSeparator separator_3_1_1_1 = new JSeparator();
		separator_3_1_1_1.setBounds(400, 218, 375, 3);
		add(separator_3_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("100 rupees");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_2_1_1_1.setBounds(394, 222, 128, 25);
		add(lblNewLabel_1_2_1_1_1);
		
		JComboBox comboBox_1_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1_1_1_1_1.setBounds(531, 225, 100, 25);
		add(comboBox_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(652, 222, 128, 25);
		add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnNewButton_2 = new JButton("                                             Total 0");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(394, 257, 386, 25);
		add(btnNewButton_2);
		
		JButton btnCalculer = new JButton("Calculer");
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
