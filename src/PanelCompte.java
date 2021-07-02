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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PanelCompte extends JPanel {
	private JTable table;
	DefaultTableModel model;
	private String name = "compte";
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Create the panel.
	 */
	public PanelCompte() {
		
		setBackground(Color.WHITE);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(4, 40, 772, 4);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 50, 772, 402);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Types","Montant","Date","Commentaire"};
		Object[] row = new Object[0];
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblVentesValidees = new JLabel("Comptabilit\u00E9 /  mensuel");
		lblVentesValidees.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentesValidees.setForeground(Color.GRAY);
		lblVentesValidees.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVentesValidees.setBackground(Color.WHITE);
		lblVentesValidees.setBounds(4, 20, 164, 19);
		add(lblVentesValidees);

	}
	
}
