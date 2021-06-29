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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class PanelVente2 extends JPanel {
	private JTextField txtNom;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelVente2() {
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		txtNom = new JTextField();
		txtNom.setText("Produit/Prix/Id");
		txtNom.setForeground(Color.GRAY);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNom.setColumns(10);
		txtNom.setBounds(10, 10, 201, 40);
		add(txtNom);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PanelVente2.class.getResource("/img/icons8-search-24.png")));
		btnNewButton.setBounds(212, 10, 50, 40);
		add(btnNewButton);
		
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
		lblCa.setBounds(10, 53, 80, 13);
		panel.add(lblCa);
		lblCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDernierAchat = new JLabel("Prix");
		lblDernierAchat.setBounds(10, 87, 62, 13);
		panel.add(lblDernierAchat);
		lblDernierAchat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDernierAchat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPays = new JLabel("Description");
		lblPays.setBounds(10, 119, 97, 13);
		panel.add(lblPays);
		lblPays.setHorizontalAlignment(SwingConstants.LEFT);
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBounds(100, 52, 229, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 86, 229, 23);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 118, 229, 180);
		panel.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(4, 410, 104, 35);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(154, 410, 104, 35);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_1.setBounds(300, 410, 93, 35);
		add(btnNewButton_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 68, 379, 369);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
