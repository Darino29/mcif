import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSet extends JPanel {
	private ACC parent;
	private String name = "set";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create the panel.
	 */
	public PanelSet(ACC p) {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0,0,780,455);
		setLayout(null);
		parent = p;
		
		JPanel panel = new JPanel();
		panel.setBounds(10,10,760,435);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("A propos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parent.changerMenu3();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(136, 203, 501, 38);
		panel.add(btnNewButton);
		
		JButton btnModifierLeMot = new JButton("Modifier le mot de passe");
		btnModifierLeMot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parent.changerMenu2();
			}
		});
		btnModifierLeMot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifierLeMot.setBounds(136, 127, 501, 38);
		panel.add(btnModifierLeMot);
	}
}
