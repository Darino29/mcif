import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class PanelSet2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelSet2() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0,0,780,455);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,10,760,435);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Changer");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(281, 199, 109, 34);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(208, 101, 249, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 150, 249, 39);
		panel.add(textField_1);
		
		
	}
}
