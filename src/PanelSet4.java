import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSet4 extends JPanel {
	private ACC parent;
	private JTable table;
	DefaultTableModel model;
	final Object[] row = new Object[4];

	/**
	 * Create the panel.
	 */
	public PanelSet4(ACC pp) {
		parent = pp;
		setBackground(Color.LIGHT_GRAY);
		setBounds(0,0,780,455);
		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,10,760,435);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parent.retourMenu();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(21, 22, 118, 27);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 70, 712, 314);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"ID","USERNAME","PASSWORD","POST"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setBounds(0, 310, 710, -307);
		panel_1.add(table);
		
		JButton btnSupp = new JButton("Supprimer");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Supprimé");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selectioné l'utilisateur à supprimer");
				}
			}
		});
		btnSupp.setBounds(629, 394, 105, 31);
		panel.add(btnSupp);
	}
}
