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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PanelVente extends JPanel {
	private JTextField txtNom;
	private JTable table;
	private ACC parent;
	private String name = "Vente";
	
	
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
		
		txtNom = new JTextField();
		txtNom.setText("Client/Produit");
		txtNom.setForeground(Color.GRAY);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNom.setColumns(10);
		txtNom.setBounds(10, 10, 201, 40);
		add(txtNom);
		
		JButton btnNewButton = new JButton("");
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
		scrollPane.setBounds(4, 121, 772, 334);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Produit");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(4, 99, 128, 19);
		add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(134, 99, 128, 19);
		add(lblDate);
		
		JLabel lblVendeur = new JLabel("Vendeur");
		lblVendeur.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendeur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVendeur.setBounds(262, 99, 128, 19);
		add(lblVendeur);
		
		JLabel lblDate_1_1 = new JLabel("Client");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate_1_1.setBounds(390, 99, 128, 19);
		add(lblDate_1_1);
		
		JLabel lblDate_1_1_1 = new JLabel("Paiement");
		lblDate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate_1_1_1.setBounds(520, 99, 128, 19);
		add(lblDate_1_1_1);
		
		JLabel lblDate_1_1_1_1 = new JLabel("Total");
		lblDate_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate_1_1_1_1.setBounds(648, 99, 128, 19);
		add(lblDate_1_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(134, 92, 1, 28);
		add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(Color.WHITE);
		separator_1_1.setBounds(262, 92, 1, 28);
		add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setBackground(Color.WHITE);
		separator_1_2.setBounds(390, 92, 1, 28);
		add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_3.setBackground(Color.WHITE);
		separator_1_3.setBounds(520, 92, 1, 28);
		add(separator_1_3);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setOrientation(SwingConstants.VERTICAL);
		separator_1_4.setBackground(Color.WHITE);
		separator_1_4.setBounds(647, 92, 1, 28);
		add(separator_1_4);
		
		JLabel lblVentesValidees = new JLabel("Ventes validees ");
		lblVentesValidees.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentesValidees.setForeground(Color.GRAY);
		lblVentesValidees.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVentesValidees.setBackground(Color.WHITE);
		lblVentesValidees.setBounds(4, 65, 128, 19);
		add(lblVentesValidees);

	}
	
}
