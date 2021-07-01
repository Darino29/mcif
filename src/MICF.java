import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlleur.UtilisateurControleur;

import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPasswordField;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MICF extends JFrame {

	private JPanel contentPane;
	private JTextField nomTxt;
	private JTextField mdpTxt;
	private JTextField confirmMdpTxt;
	private JComboBox comboBox ;
	int xx,xy;


	/**
	 * Create the frame.
	 */
	public MICF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MICF.class.getResource("/img/launch.PNG")));
		setBounds(100, 100, 868, 532);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();

		        xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();

		        int y = arg0.getYOnScreen();

		        MICF.this.setLocation(x - xx, y - xy); 
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 320, 550);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MICF.class.getResource("/img/6.jpg")));
		panel.add(lblNewLabel_3);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(414, 114, 249, 39);
		contentPane.add(nomTxt);
		nomTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom = nomTxt.getText();
				String mdp = mdpTxt.getText();
				String confirmMdp =confirmMdpTxt.getText();
				Object postO = comboBox.getSelectedItem();
				String post = postO.toString();
				UtilisateurControleur control = new UtilisateurControleur();
				Boolean result = control.createUtilisateur(nom, mdp, confirmMdp, post);
				System.out.println(result);
				
			}
		});
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setBounds(466, 388, 162, 39);
		contentPane.add(btnNewButton);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(414, 157, 249, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(414, 83, 77, 21);
		contentPane.add(lblNewLabel);
		

		mdpTxt = new JTextField();
		mdpTxt.setColumns(10);
		mdpTxt.setBounds(414, 194, 249, 39);
		contentPane.add(mdpTxt);
    
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(414, 163, 77, 21);
		contentPane.add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(414, 237, 249, 2);
		contentPane.add(separator_1);
		
		confirmMdpTxt = new JTextField();
		confirmMdpTxt.setColumns(10);
		confirmMdpTxt.setBounds(414, 268, 249, 39);
		contentPane.add(confirmMdpTxt);
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setBounds(414, 237, 139, 21);
		contentPane.add(lblConfirmPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(414, 311, 249, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("Minerals Creative Furnitures");
		lblNewLabel_1.setBackground(new Color(222, 184, 135));
		lblNewLabel_1.setFont(new Font("Calisto MT", Font.BOLD, 16));
		lblNewLabel_1.setBounds(462, 10, 257, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblclose = new JLabel("X");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Etes vous sure de vouloir quitter ? ", "Confirmation", JOptionPane.YES_NO_OPTION)== 0) {
					System.exit(0);
				}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			lblclose.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblclose.setForeground(Color.WHITE);
		}
		});
		lblclose.setForeground(Color.RED);
		lblclose.setBackground(Color.WHITE);
		lblclose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclose.setBounds(839, 0, 25, 21);
		contentPane.add(lblclose);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Vendeur"}));
		comboBox.setBounds(414, 317, 111, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Have an account?Sign Up ");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MICF2 m = new MICF2();
				m.setVisible(true);
				m.setUndecorated(true);
				dispose();
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(414, 445, 249, 21);
		contentPane.add(lblNewLabel_2);
	}
}
