import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class PanelSet extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSet() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0,0,780,455);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,10,760,435);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Choix de langue");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(136, 106, 501, 38);
		panel.add(btnNewButton);
		
		JButton btnModifierLeMot = new JButton("Modifier le mot de passe");
		btnModifierLeMot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifierLeMot.setBounds(136, 162, 501, 38);
		panel.add(btnModifierLeMot);
		
		JButton btnRemises = new JButton("Remises");
		btnRemises.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRemises.setBounds(136, 220, 501, 38);
		panel.add(btnRemises);
		
		JButton btnPointsDeVente = new JButton("Points de ventes");
		btnPointsDeVente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPointsDeVente.setBounds(136, 276, 501, 38);
		panel.add(btnPointsDeVente);
	}
}
