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
import javax.swing.JProgressBar;
import java.awt.SystemColor;

public class Splash extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private static JProgressBar progressBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
					Splash frame = new Splash();
					frame.setUndecorated(true);
					frame.setVisible(true);	
					try {
					for(int x=0;x<=100;x++) {
						Thread.sleep(30);
						Splash.progressBar.setValue(x);
						if(x==100) {
							MICF2 n = new MICF2();
							n.setUndecorated(true);
							n.setVisible(true);
							frame.dispose();
						}
						
						
					}
					
					} catch (Exception e) {
						e.printStackTrace();
				}
			
		};
	

	/**
	 * Create the frame.
	 */
	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Splash.class.getResource("/img/launch.PNG")));
		setBounds(100, 100, 868, 532);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
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

		        Splash.this.setLocation(x - xx, y - xy); 
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/darc.gif"));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(200, 100, 450, 350);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setValue(100);
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBounds(0, 525, 868, 5);
		contentPane.add(progressBar);
		
		JLabel charg = new JLabel("");
		charg.setForeground(Color.DARK_GRAY);
		charg.setBounds(799, 467, 45, 13);
		contentPane.add(charg);
	}
}
