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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Controlleur.PlanningControlleur;
import Controlleur.UtilisateurControleur;
import Controlleur.UtilitaireControleur;
import model.Planning;
import model.Utilisateur;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSet4 extends JPanel {
	private ACC parent;
	DefaultTableModel model;
	final Object[] row = new Object[4];
	private JTable table;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 61, 703, 329);
		panel.add(scrollPane);
		
		table = new JTable();
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"id","Username","Password","Post"};
		
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
				 List<Utilisateur> user = new ArrayList<>();
				 UtilisateurControleur usr = new UtilisateurControleur();
					
					 try {
						user = usr.allUtilisateur();
						 
					 }catch(Exception e1) {
						 System.out.println("not found");
					 }
					 for (Utilisateur us : user) {
						 	System.out.println(us.toString());
							row[0] = us.getIdUtilisateur();
							row[1] = us.getNomUtilisateur();
							row[2] = us.getMdpUtilisateur();
							row[3] = us.getPostUtilisateur();
							
							
							model.addRow(row) ;
						}
			
				
			
		
			}
		});
		btnNewButton.setBounds(650, 26, 85, 21);
		panel.add(btnNewButton);
	
	}
}
