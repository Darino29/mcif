import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Utilisateur;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Window.Type;



public class ACC extends JFrame {
	int xx,xy;
	private PanelCaisse panelCaisse;
	private PanelPlann panelPlann;
	private PanelVente panelVente;
	private PanelVente2 panelVente2;
	private PanelCompte panelCompte;
	private PanelClient panelClient;
	private PanelStock panelStock;
	private PanelSet panelSet;
	private PanelSet2 panelSet2;
	private PanelSet3 panelSet3;
	private PanelSet4 panelSet4;
	private JPanel contentPane;
	private static Utilisateur user;
	
	

	/**
	 * Create the frame.
	 */
	public ACC(Utilisateur userI) {
		user = userI;
		setForeground(SystemColor.controlDkShadow);
		setBackground(SystemColor.controlDkShadow);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\23058\\OneDrive\\Images\\S-Assistant2\\S-Assistant2\\S-Assistant2\\app\\src\\main\\res\\drawable\\launch.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 518);
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

		        ACC.this.setLocation(x - xx, y - xy); 
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCaisse = new PanelCaisse();
		panelClient = new PanelClient();
		panelStock = new PanelStock();
		panelPlann = new PanelPlann();
		panelVente = new PanelVente(this);
		panelVente2 = new PanelVente2();
		panelCompte = new PanelCompte();
		panelSet = new PanelSet(this);
		panelSet2 = new PanelSet2(this);
		panelSet3 = new PanelSet3(this);
		panelSet4 = new PanelSet4(this);
		
		JPanel panel0 = new JPanel();
		panel0.setBounds(67, 21, 808, 506);
		panel0.setBackground(SystemColor.controlDkShadow);
		contentPane.add(panel0);
		panel0.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez vous deconnecter ?") == 0) {
				MICF2 dec = new MICF2();
				dec.setUndecorated(true);
				dec.setVisible(true);
				ACC.this.dispose();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color(112,128,144));
			}
		});
		panel.setBounds(733, 10, 57, 40);
		panel0.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-sign-out-30.png")));
		panel.add(lblNewLabel_2);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBackground(SystemColor.scrollbar);
		paneMainContent.setBounds(0, 51, 780, 455);
		panel0.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		paneMainContent.add(panelCaisse);
		paneMainContent.add(panelClient);
		paneMainContent.add(panelStock);
		paneMainContent.add(panelPlann);
		paneMainContent.add(panelVente);
		paneMainContent.add(panelVente2);
		paneMainContent.add(panelCompte);
		paneMainContent.add(panelSet);
		paneMainContent.add(panelSet2);
		paneMainContent.add(panelSet3);
		paneMainContent.add(panelSet4);
		
		menuClicked(panelCaisse);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 21, 67, 506);
		panelMenu.setBackground(new Color(255, 255, 255));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelC = new JPanel();
		panelC.addMouseListener(new PanelButtonMouseAdapter(panelC)
				{
					@Override
					public void mouseClicked(MouseEvent e) {
						menuClicked(panelCaisse);
					}
				}	
		);
		panelC.setBounds(0, 0, 67, 69);
		panelMenu.add(panelC);
		
		JLabel lblNewLabel_1 = new JLabel("Caisse");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelC.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-cash-register-40.png")));
		panelC.add(lblNewLabel);
		
		JPanel panelCl = new JPanel();
		panelCl.addMouseListener(new PanelButtonMouseAdapter(panelCl)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelClient);
			}
		}			
		);
		panelCl.setBounds(0, 71, 67, 69);
		panelMenu.add(panelCl);
		
		JLabel lblNewLabel_3 = new JLabel("Clients");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelCl.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-user-40.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelCl.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 67, 1);
		panelMenu.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 140, 67, 1);
		panelMenu.add(separator_1);
		
		JPanel panelSt = new JPanel();
		panelSt.addMouseListener(new PanelButtonMouseAdapter(panelSt){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelStock);
			}
		});
		panelSt.setBounds(0, 141, 67, 69);
		panelMenu.add(panelSt);
		
		JLabel lblNewLabel_1_2 = new JLabel("Stock");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelSt.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-warehouse-40.png")));
		panelSt.add(lblNewLabel_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 211, 67, 1);
		panelMenu.add(separator_2);
		
		JPanel panelPl = new JPanel();
		panelPl.addMouseListener(new PanelButtonMouseAdapter(panelPl){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPlann);
			}
		});
		panelPl.setBounds(0, 211, 67, 69);
		panelMenu.add(panelPl);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Planning");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelPl.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-planner-40.png")));
		panelPl.add(lblNewLabel_4_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 280, 67, 1);
		panelMenu.add(separator_3);
		
		JPanel panelV = new JPanel();
		panelV.addMouseListener(new PanelButtonMouseAdapter(panelV){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelVente);
			}
		});
		panelV.setBounds(0, 281, 67, 69);
		panelMenu.add(panelV);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Ventes");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelV.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-money-40.png")));
		panelV.add(lblNewLabel_4_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 351, 67, 1);
		panelMenu.add(separator_4);
		
		JPanel panelCom = new JPanel();
		panelCom.addMouseListener(new PanelButtonMouseAdapter(panelCom){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCompte);
			}
		});
		panelCom.setBounds(0, 352, 67, 69);
		panelMenu.add(panelCom);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Comptabilite");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelCom.add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-calculator-40.png")));
		panelCom.add(lblNewLabel_4_2_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 422, 67, 1);
		panelMenu.add(separator_5);
		
		JPanel panelPar = new JPanel();
		panelPar.addMouseListener(new PanelButtonMouseAdapter(panelPar){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSet);
			}
		});
		panelPar.setBounds(0, 422, 67, 84);
		panelMenu.add(panelPar);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Parametre");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelPar.add(lblNewLabel_1_2_2_1_1);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("");
		lblNewLabel_4_2_1_2.setIcon(new ImageIcon(ACC.class.getResource("/img/icons8-settings-40.png")));
		panelPar.add(lblNewLabel_4_2_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 875, 20);
		panel_2.setBackground(SystemColor.activeCaptionBorder);
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
		lblclose.setForeground(Color.WHITE);
		lblclose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclose.setBackground(Color.WHITE);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panelMenu;
		public PanelButtonMouseAdapter(JPanel panelMenu) {
			this.panelMenu = panelMenu;
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panelMenu.setBackground(new Color(112,128,144));
		}
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panelMenu.setBackground(SystemColor.controlDkShadow);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panelMenu.setBackground(new Color(255, 255, 255));
		}
		
	}	
 public void menuClicked(JPanel panel) {
	 if((panel.getClass()== PanelCompte.class) && (user.getPostUtilisateur().equals("Admin"))) {
		 panelCompte.load();
	 }
	 if((panel.getClass() == PanelSet.class || panel.getClass() == PanelCompte.class) && (user.getPostUtilisateur().equals("Vendeur")) ) {
		 JOptionPane.showMessageDialog(null, "Admin only");
	 }
	 else {
		 panelCaisse.setVisible(false);
		 panelClient.setVisible(false);
		 panelStock.setVisible(false);
		 panelPlann.setVisible(false);
		 panelVente.setVisible(false);
		 panelVente2.setVisible(false);
		 panelCompte.setVisible(false);
		 panelSet.setVisible(false);
		 panelSet2.setVisible(false);
		 panelSet3.setVisible(false);
     panelSet4.setVisible(false);
		 
		 panel.setVisible(true);
	 }

 }
	 
 public  void changerMenu(){
	
	 panelCaisse.setVisible(false);
	 panelClient.setVisible(false);
	 panelStock.setVisible(false);
	 panelPlann.setVisible(false);
	 panelVente.setVisible(false);
	 panelCompte.setVisible(false);
	 panelSet.setVisible(false);
	 panelSet3.setVisible(false);
	 panelSet2.setVisible(false);
	 panelSet4.setVisible(false);
	 
	 panelVente2.setVisible(true);
	 
     
     
 }
 
 public  void changerMenu2(){
		
	 panelCaisse.setVisible(false);
	 panelClient.setVisible(false);
	 panelStock.setVisible(false);
	 panelPlann.setVisible(false);
	 panelVente.setVisible(false);
	 panelVente2.setVisible(false);
	 panelCompte.setVisible(false);
	 panelSet.setVisible(false);
	 panelSet3.setVisible(false);
	 panelSet4.setVisible(false);
	 
	 panelSet2.setVisible(true);
	 
     
     
 }
 public  void changerMenu3(){
		
	 panelCaisse.setVisible(false);
	 panelClient.setVisible(false);
	 panelStock.setVisible(false);
	 panelPlann.setVisible(false);
	 panelVente.setVisible(false);
	 panelVente2.setVisible(false);
	 panelCompte.setVisible(false);
	 panelSet.setVisible(false);
	 panelSet2.setVisible(false);
	 panelSet4.setVisible(false);
	 
	 panelSet3.setVisible(true);
	 
     
     
 }
 public  void changerMenu4(){
		
	 panelCaisse.setVisible(false);
	 panelClient.setVisible(false);
	 panelStock.setVisible(false);
	 panelPlann.setVisible(false);
	 panelVente.setVisible(false);
	 panelVente2.setVisible(false);
	 panelCompte.setVisible(false);
	 panelSet.setVisible(false);
	 panelSet2.setVisible(false);
	 panelSet3.setVisible(false);
	 panelSet4.setVisible(true);
	 
     
     
 }
 public  void retourMenu(){
		
	 panelCaisse.setVisible(false);
	 panelClient.setVisible(false);
	 panelStock.setVisible(false);
	 panelPlann.setVisible(false);
	 panelVente.setVisible(false);
	 panelVente2.setVisible(false);
	 panelCompte.setVisible(false);
	 panelSet2.setVisible(false);
	 panelSet3.setVisible(false);
	 
	 panelSet.setVisible(true);
	 
 }
     
 }
 
