import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class PanelSet3 extends JPanel {
	private ACC parent;
	private String name = "set3";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelSet3(ACC pp) {
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
		
		JTextPane txtpnLoremIpsumEst = new JTextPane();
		txtpnLoremIpsumEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnLoremIpsumEst.setText("Lorem Ipsum est simplement un texte factice de l'industrie de l'impression et de la composition. Lorem Ipsum est le texte factice standard de l'industrie depuis les ann\u00E9es 1500, lorsqu'un imprimeur inconnu a pris une gal\u00E8re de caract\u00E8res et l'a brouill\u00E9 pour en faire un livre sp\u00E9cimen de caract\u00E8res. Il a surv\u00E9cu non seulement \u00E0 cinq si\u00E8cles, mais aussi au saut dans la composition \u00E9lectronique, restant essentiellement inchang\u00E9. Il a \u00E9t\u00E9 popularis\u00E9 dans les ann\u00E9es 1960 avec la sortie des feuilles Letraset contenant des passages de Lorem Ipsum, et plus r\u00E9cemment avec des logiciels de PAO comme Aldus PageMaker incluant des versions de Lorem Ipsum.");
		txtpnLoremIpsumEst.setBounds(107, 72, 547, 332);
		panel.add(txtpnLoremIpsumEst);
	}
}
