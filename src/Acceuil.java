import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;



public class Acceuil extends JFrame {
	int xx,xy;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acceuil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\23058\\OneDrive\\Images\\S-Assistant2\\S-Assistant2\\S-Assistant2\\app\\src\\main\\res\\drawable\\launch.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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

		        Acceuil.this.setLocation(x - xx, y - xy); 
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 21, 869, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\10.jpg"));
		lblNewLabel_1.setBounds(0, 0, 869, 242);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(209, 286, 87, 65);
		contentPane.add(panel_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-cash-register-40.png"));
		mntmNewMenuItem.setBackground(new Color(255, 255, 255));
		panel_1.add(mntmNewMenuItem);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(329, 286, 87, 65);
		contentPane.add(panel_1_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-user-40.png"));
		panel_1_1.add(mntmNewMenuItem_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(447, 286, 87, 65);
		contentPane.add(panel_1_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-warehouse-40.png"));
		panel_1_2.add(mntmNewMenuItem_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(564, 286, 87, 65);
		contentPane.add(panel_1_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("");
		mntmNewMenuItem_3.setBackground(Color.WHITE);
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-planner-40.png"));
		panel_1_3.add(mntmNewMenuItem_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(Color.WHITE);
		panel_1_4.setBounds(209, 387, 87, 65);
		contentPane.add(panel_1_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		mntmNewMenuItem_4.setBackground(Color.WHITE);
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-money-40.png"));
		panel_1_4.add(mntmNewMenuItem_4);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(Color.WHITE);
		panel_1_5.setBounds(329, 387, 87, 65);
		contentPane.add(panel_1_5);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
		mntmNewMenuItem_5.setBackground(Color.WHITE);
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-calculator-40.png"));
		panel_1_5.add(mntmNewMenuItem_5);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBackground(Color.WHITE);
		panel_1_6.setBounds(447, 387, 87, 65);
		contentPane.add(panel_1_6);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("");
		mntmNewMenuItem_6.setBackground(Color.WHITE);
		mntmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\23058\\OneDrive\\Bureau\\micf\\icons8-settings-40.png"));
		panel_1_6.add(mntmNewMenuItem_6);
		
		JLabel lblNewLabel = new JLabel("Caisse");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(229, 357, 67, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblClients = new JLabel("Utilisateurs");
		lblClients.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClients.setBounds(329, 361, 87, 16);
		contentPane.add(lblClients);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Calibri", Font.BOLD, 15));
		lblStock.setBounds(468, 361, 66, 16);
		contentPane.add(lblStock);
		
		JLabel lblPlanning = new JLabel("Planning");
		lblPlanning.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPlanning.setBounds(584, 359, 67, 20);
		contentPane.add(lblPlanning);
		
		JLabel lblVentes = new JLabel("Ventes");
		lblVentes.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVentes.setBounds(229, 462, 67, 20);
		contentPane.add(lblVentes);
		
		JLabel lblComptabilite = new JLabel("Comptabilite");
		lblComptabilite.setFont(new Font("Calibri", Font.BOLD, 15));
		lblComptabilite.setBounds(329, 462, 87, 20);
		contentPane.add(lblComptabilite);
		
		JLabel lblSettings = new JLabel("Parametres");
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSettings.setBounds(447, 464, 87, 20);
		contentPane.add(lblSettings);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(0, 0, 869, 20);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblclose = new JLabel("X");
		lblclose.setBounds(839, 0, 30, 20);
		panel_2.add(lblclose);
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
		lblclose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclose.setBackground(Color.WHITE);
	}
}
