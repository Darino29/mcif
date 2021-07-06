import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Result;

import Controlleur.UtilisateurControleur;
import model.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSet2 extends JPanel {
	private JTextField ancMdp;
	private JTextField newMdp;
	private ACC parent;
	private Utilisateur user;
	private String name = "set2";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelSet2(ACC s,Utilisateur user) {
		this.user = user;
		parent = s;
		setBackground(Color.LIGHT_GRAY);
		setBounds(0,0,780,455);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,10,760,435);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Changer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ancMdp.getText().equals("") || newMdp.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Completer les cases vides");
				}
				else
				{
					String anc = ancMdp.getText();
					String nouv = newMdp.getText();
					UtilisateurControleur usr = new UtilisateurControleur();
					String result = usr.changeMdp(nouv, anc, user);
					ancMdp.setText("");
					newMdp.setText("");
					JOptionPane.showMessageDialog(null, result);
				}
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(290, 245, 109, 34);
		panel.add(btnNewButton);
		
		ancMdp = new JTextField();
		ancMdp.setBounds(222, 119, 249, 39);
		panel.add(ancMdp);
		ancMdp.setColumns(10);
		
		newMdp = new JTextField();
		newMdp.setColumns(10);
		newMdp.setBounds(222, 199, 249, 39);
		panel.add(newMdp);
		
		JLabel lblNewLabel = new JLabel("Ancien mot de passe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(222, 88, 146, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe");
		lblNouveauMotDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNouveauMotDe.setBounds(222, 168, 146, 21);
		panel.add(lblNouveauMotDe);
		
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
		btnNewButton_1.setBounds(22, 33, 118, 27);
		panel.add(btnNewButton_1);
		
		
	}
}
