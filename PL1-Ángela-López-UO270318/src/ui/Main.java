package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import controller.MainViewController;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * 
 * @author angela uo270318
 *
 */
public class Main extends JFrame {

	// atributos
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public CardLayout card;
	// para poder ver la imagen correctamente en design
	private ImageIcon imageIcon = new ImageIcon(
			Main.class.getResource("/img/background.png"));
	private Image i = (imageIcon.getImage().getScaledInstance(d.width, d.height,
			Image.SCALE_FAST));
	// LOGIN
	private JPanel panelLogin;
	private JLabel lblBackground;
	private JPanel center;
	private JPanel panel;
	private JPanel panelTop;
	private JPanel panelBottom;
	private JButton btnLogin;
	private JButton btnRegister;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelTitle;
	private JLabel lblTitle;
	private JPanel panelCenter;
	private JPanel panelMenu;
	private JLabel lblHelp;
	private JComboBox<String> comboBoxLanguage;
	private JLabel lblIcon;
	private JPanel panelFIll;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblUserError;
	private JLabel lblPass;
	private JTextField txtPass;
	private JLabel lblPassError;

	// GAME
	private JPanel panelGame;
	private JPanel panelBottomGame;
	private JButton btnPlay;
	private JButton btnRetire;
	private JButton btnShop;
	private JButton btnBank;
	private JButton btnCardBalance;
	private JTextArea textAreaMessages;
	private JPanel panelMidGame;
	private JPanel panelTokens;
	private JPanel panelToken5;
	private JLabel lblToken5;
	private JTextField txtToken5;
	private JPanel panelToken10;
	private JLabel lblToken10;
	private JTextField txtToken10;
	private JPanel panelToken20;
	private JLabel lblToken20;
	private JTextField txtToken20;
	private JPanel panelToken50;
	private JLabel lblToken50;
	private JTextField txtToken50;
	private JPanel panelToken100;
	private JLabel lblToken100;
	private JTextField txtToken100;
	private JPanel panelLeftGame;
	private JPanel panelBoard;
	private JPanel panelTopGame;
	private JLabel lblHelpGame;
	private JLabel lblRoulette;
	private JScrollPane panelRightGame;
	private JLabel lblMsg;

	
	// inicializacion
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					new MainViewController(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// constructor principal
	public Main() {
		card = new CardLayout();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				d = new Dimension(e.getComponent().getWidth(),
						e.getComponent().getHeight());
				center.setBounds(0, 0, d.width, d.height);
				lblBackground.setBounds(0, 0, d.width, d.height);
				textAreaMessages.setBounds(0, 0, (d.width/6)/(4/3), d.height);

			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Main.class.getResource("/img/main_icon.png")));
		setTitle("Casino 4 Tréboles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(card);
		contentPane.add(getPanelLogin(), "login");
		contentPane.add(getPanelGame(), "game");
		getRootPane().setDefaultButton(getBtnLogin());
		setMinimumSize(new Dimension(1000, 600));
		setContentPane(contentPane);
		d = this.getBounds().getSize();
		setLocationRelativeTo(null);
	}

	private JPanel getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new JPanel();
			panelLogin.setLayout(null);
			panelLogin.add(getCenter());
			panelLogin.add(getLblBackground());
		}
		return panelLogin;
	}

	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel(new ImageIcon(i));
			lblBackground.setBounds(0, 0, d.width, d.height);
		}
		return lblBackground;
	}

	public JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			center.setBounds(0, 0, 1280, 720); // para ver en design,
			// orientativo
			center.setOpaque(false);
			center.setBackground(Color.LIGHT_GRAY);
			center.setLayout(new GridBagLayout());
			// se podria sacar a un panel propio pero
			center.add(getPanel(), new GridBagConstraints());
		}
		return center;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(5, 5, 722, 400);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanelTop(), BorderLayout.NORTH);
			panel.add(getPanelBottom(), BorderLayout.SOUTH);
			panel.add(getPanelLeft(), BorderLayout.WEST);
			panel.add(getPanelRight(), BorderLayout.EAST);
			panel.add(getPanelCenter(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JPanel getPanelTop() {
		if (panelTop == null) {
			panelTop = new JPanel();
			panelTop.setOpaque(false);
			panelTop.setLayout(new BorderLayout(0, 0));
			panelTop.add(getPanelTitle());
			panelTop.add(getPanelMenu(), BorderLayout.EAST);
			panelTop.add(getPanelFIll(), BorderLayout.WEST);
		}
		return panelTop;
	}

	private JPanel getPanelBottom() {
		if (panelBottom == null) {
			panelBottom = new JPanel();
			panelBottom.setBorder(new EmptyBorder(10, 20, 10, 20));
			panelBottom.setOpaque(false);
			panelBottom.add(getBtnLogin());
			panelBottom.add(getBtnRegister());
		}
		return panelBottom;
	}

	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Inicio");
			btnLogin.setMnemonic('i');
			btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLogin.setBackground(Color.WHITE);
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnLogin;
	}

	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registro");
			btnRegister.setMnemonic('r');
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setBackground(Color.WHITE);
			btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnRegister;
	}

	private JPanel getPanelLeft() {
		if (panelLeft == null) {
			panelLeft = new JPanel();
			panelLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelLeft.setOpaque(false);
		}
		return panelLeft;
	}

	private JPanel getPanelRight() {
		if (panelRight == null) {
			panelRight = new JPanel();
			panelRight.setOpaque(false);
			panelRight.setBorder(new EmptyBorder(20, 20, 20, 20));
		}
		return panelRight;
	}

	private JPanel getPanelTitle() {
		if (panelTitle == null) {
			panelTitle = new JPanel();
			panelTitle.setOpaque(false);
			panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelTitle.add(getLblIcon());
			panelTitle.add(getLblTitle());
		}
		return panelTitle;
	}

	public JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Casino 4 Tréboles");
			lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		}
		return lblTitle;
	}

	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0,
					Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panelCenter.setLayout(gbl_panel);
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
			gbc_lblUser.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblUser.gridx = 0;
			gbc_lblUser.gridy = 0;
			panelCenter.add(getLblUser(), gbc_lblUser);
			GridBagConstraints gbc_txtUser = new GridBagConstraints();
			gbc_txtUser.insets = new Insets(0, 0, 5, 0);
			gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUser.gridx = 2;
			gbc_txtUser.gridy = 0;
			panelCenter.add(getTxtUser(), gbc_txtUser);
			GridBagConstraints gbc_lblUserError = new GridBagConstraints();
			gbc_lblUserError.insets = new Insets(0, 0, 5, 0);
			gbc_lblUserError.gridx = 2;
			gbc_lblUserError.gridy = 1;
			panelCenter.add(getLblUserError(), gbc_lblUserError);
			GridBagConstraints gbc_lblPass = new GridBagConstraints();
			gbc_lblPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPass.insets = new Insets(0, 0, 5, 5);
			gbc_lblPass.gridx = 0;
			gbc_lblPass.gridy = 2;
			panelCenter.add(getLblPass(), gbc_lblPass);
			GridBagConstraints gbc_txtPass = new GridBagConstraints();
			gbc_txtPass.insets = new Insets(0, 0, 5, 0);
			gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPass.gridx = 2;
			gbc_txtPass.gridy = 2;
			panelCenter.add(getTxtPass(), gbc_txtPass);
			GridBagConstraints gbc_lblPassError = new GridBagConstraints();
			gbc_lblPassError.gridx = 2;
			gbc_lblPassError.gridy = 3;
			panelCenter.add(getLblPassError(), gbc_lblPassError);
		}
		return panelCenter;
	}

	private JPanel getPanelMenu() {
		if (panelMenu == null) {
			panelMenu = new JPanel();
			panelMenu.setBorder(new EmptyBorder(32, 10, 0, 10));
			panelMenu.setOpaque(false);
			panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelMenu.add(getComboBoxLanguage());
			panelMenu.add(getLblHelp());
		}
		return panelMenu;
	}

	public JLabel getLblHelp() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.setToolTipText("Pulsa para ver la ayuda");
			lblHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblHelp.setIcon(
					new ImageIcon(Main.class.getResource("/img/help.png")));
		}
		return lblHelp;
	}

	public JComboBox<String> getComboBoxLanguage() {
		if (comboBoxLanguage == null) {
			comboBoxLanguage = new JComboBox<String>();
			comboBoxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBoxLanguage.setMaximumRowCount(2);
			comboBoxLanguage.setModel(new DefaultComboBoxModel<String>(
					new String[] { "ES", "EN" }));
		}
		return comboBoxLanguage;
	}

	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setIcon(
					new ImageIcon(Main.class.getResource("/img/trebol.png")));
		}
		return lblIcon;
	}

	private JPanel getPanelFIll() {
		if (panelFIll == null) {
			panelFIll = new JPanel();
			panelFIll.setOpaque(false);
			panelFIll.setBorder(new EmptyBorder(20, 20, 20, 20));
		}
		return panelFIll;
	}

	public JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario:");
			lblUser.setDisplayedMnemonic('u');
			lblUser.setLabelFor(getTxtUser());
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUser;
	}

	public JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtUser.setColumns(10);
		}
		return txtUser;
	}

	public JLabel getLblUserError() {
		if (lblUserError == null) {
			lblUserError = new JLabel("El usuario no existe");
			lblUserError.setBorder(new EmptyBorder(0, 10, 0, 10));
			lblUserError.setVisible(false);
			lblUserError.setForeground(Color.RED);
			lblUserError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblUserError;
	}

	public JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("Contraseña: ");
			lblPass.setLabelFor(getTxtPass());
			lblPass.setDisplayedMnemonic('c');
			lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPass;
	}

	public JTextField getTxtPass() {
		if (txtPass == null) {
			txtPass = new JPasswordField();
			txtPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPass.setColumns(10);
		}
		return txtPass;
	}

	public JLabel getLblPassError() {
		if (lblPassError == null) {
			lblPassError = new JLabel("La contraseña es incorrecta");
			lblPassError.setBorder(new EmptyBorder(0, 10, 0, 10));
			lblPassError.setVisible(false);
			lblPassError.setForeground(Color.RED);
			lblPassError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblPassError;
	}

	private JPanel getPanelGame() {
		if (panelGame == null) {
			panelGame = new JPanel();
			panelGame.setBackground(Color.WHITE);
			panelGame.setLayout(new BorderLayout(0, 0));
			panelGame.add(getPanelBottomGame(), BorderLayout.SOUTH);
			panelGame.add(getPanelMidGame(), BorderLayout.CENTER);
			panelGame.add(getPanelTopGame(), BorderLayout.NORTH);
			panelGame.add(getPanelRightGame(), BorderLayout.EAST);
		}
		return panelGame;
	}

	private JPanel getPanelBottomGame() {
		if (panelBottomGame == null) {
			panelBottomGame = new JPanel();
			panelBottomGame.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelBottomGame.setOpaque(false);
			panelBottomGame.setLayout(new GridLayout(0, 5, 30, 0));
			panelBottomGame.add(getBtnPlay());
			panelBottomGame.add(getBtnRetire());
			panelBottomGame.add(getBtnShop());
			panelBottomGame.add(getBtnBank());
			panelBottomGame.add(getBtnCardBalance());
		}
		return panelBottomGame;
	}

	public JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("Jugar");
			btnPlay.setMnemonic('j');
			btnPlay.setEnabled(false);
			btnPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnPlay;
	}

	public JButton getBtnRetire() {
		if (btnRetire == null) {
			btnRetire = new JButton("Retirarse");
			btnRetire.setMnemonic('r');
			btnRetire.setEnabled(false);
			btnRetire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnRetire;
	}

	public JButton getBtnShop() {
		if (btnShop == null) {
			btnShop = new JButton("Tienda");
			btnShop.setMnemonic('t');
			btnShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnShop;
	}

	public JButton getBtnBank() {
		if (btnBank == null) {
			btnBank = new JButton("Banco");
			btnBank.setMnemonic('b');
			btnBank.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnBank;
	}

	public JButton getBtnCardBalance() {
		if (btnCardBalance == null) {
			btnCardBalance = new JButton("Devolver saldo");
			btnCardBalance.setMnemonic('d');
			btnCardBalance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnCardBalance;
	}

	public JTextArea getTextAreaMessages() {
		if (textAreaMessages == null) {
			textAreaMessages = new JTextArea();
			textAreaMessages.setFont(new Font("Dialog", Font.PLAIN, 12));
			textAreaMessages.setBackground(Color.WHITE);
			textAreaMessages.setLineWrap(true);
			textAreaMessages.setWrapStyleWord(true);
			textAreaMessages.setEditable(false);
			textAreaMessages.setBorder(new EmptyBorder(10, 10, 10, 10));
			textAreaMessages.setText("¡Bienvenidos al Casino 4 Tréboles!\r\n\r\nVisita la tienda para comprar fichas y poder empezar a jugar.\r\nPulsa el botón jugar para unirte a la mesa.\r\nArrastra las fichas para realizar las apuestas y pulsa la ruleta.");
		}
		return textAreaMessages;
	}

	private JPanel getPanelMidGame() {
		if (panelMidGame == null) {
			panelMidGame = new JPanel();
			panelMidGame.setOpaque(false);
			panelMidGame.setLayout(new BorderLayout(0, 0));
			panelMidGame.add(getPanelTokens(), BorderLayout.SOUTH);
			panelMidGame.add(getPanelLeftGame(), BorderLayout.WEST);
			panelMidGame.add(getPanelBoard(), BorderLayout.CENTER);
		}
		return panelMidGame;
	}

	private JPanel getPanelTokens() {
		if (panelTokens == null) {
			panelTokens = new JPanel();
			panelTokens.setBorder(new EmptyBorder(5, 20, 5, 20));
			panelTokens.setOpaque(false);
			panelTokens.setLayout(new GridLayout(1, 5, 0, 0));
			panelTokens.add(getPanelToken5());
			panelTokens.add(getPanelToken10());
			panelTokens.add(getPanelToken20());
			panelTokens.add(getPanelToken50());
			panelTokens.add(getPanelToken100());
		}
		return panelTokens;
	}

	private JPanel getPanelToken5() {
		if (panelToken5 == null) {
			panelToken5 = new JPanel();
			panelToken5.setOpaque(false);
			panelToken5.setLayout(new BorderLayout(0, 0));
			panelToken5.add(getLblToken5());
			panelToken5.add(getTxtToken5(), BorderLayout.SOUTH);
		}
		return panelToken5;
	}

	public JLabel getLblToken5() {
		if (lblToken5 == null) {
			lblToken5 = new JLabel("");
			lblToken5.setForeground(Color.BLUE);
			lblToken5.setEnabled(false);
			lblToken5.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/fichas/ficha_5_disabled.png")));
			lblToken5.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			lblToken5.setHorizontalAlignment(SwingConstants.CENTER);
			lblToken5.setIcon(new ImageIcon(
					Main.class.getResource("/img/fichas/ficha_5.png")));
			lblToken5.setTransferHandler(new TransferHandler("foreground")); // comun al boton
		}
		return lblToken5;
	}

	public JTextField getTxtToken5() {
		if (txtToken5 == null) {
			txtToken5 = new JTextField();
			txtToken5.setHorizontalAlignment(SwingConstants.CENTER);
			txtToken5.setText("0");
			txtToken5.setName("5");
			txtToken5.setEditable(false);
		}
		return txtToken5;
	}

	private JPanel getPanelToken10() {
		if (panelToken10 == null) {
			panelToken10 = new JPanel();
			panelToken10.setOpaque(false);
			panelToken10.setLayout(new BorderLayout(0, 0));
			panelToken10.add(getLblToken10(), BorderLayout.CENTER);
			panelToken10.add(getTxtToken10(), BorderLayout.SOUTH);
		}
		return panelToken10;
	}

	public JLabel getLblToken10() {
		if (lblToken10 == null) {
			lblToken10 = new JLabel("");
			lblToken10.setForeground(Color.BLUE);
			lblToken10.setEnabled(false);
			lblToken10.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/fichas/ficha_10_disabled.png")));
			lblToken10.setHorizontalAlignment(SwingConstants.CENTER);
			lblToken10.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			lblToken10.setIcon(new ImageIcon(
					Main.class.getResource("/img/fichas/ficha_10.png")));
			lblToken10.setTransferHandler(new TransferHandler("foreground")); // comun al boton
		}
		return lblToken10;
	}

	public JTextField getTxtToken10() {
		if (txtToken10 == null) {
			txtToken10 = new JTextField();
			txtToken10.setText("0");
			txtToken10.setName("10");
			txtToken10.setHorizontalAlignment(SwingConstants.CENTER);
			txtToken10.setEditable(false);
		}
		return txtToken10;
	}

	private JPanel getPanelToken20() {
		if (panelToken20 == null) {
			panelToken20 = new JPanel();
			panelToken20.setOpaque(false);
			panelToken20.setLayout(new BorderLayout(0, 0));
			panelToken20.add(getLblToken20(), BorderLayout.CENTER);
			panelToken20.add(getTxtToken20(), BorderLayout.SOUTH);
		}
		return panelToken20;
	}

	public JLabel getLblToken20() {
		if (lblToken20 == null) {
			lblToken20 = new JLabel("");
			lblToken20.setForeground(Color.BLUE);
			lblToken20.setEnabled(false);
			lblToken20.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/fichas/ficha_20_disabled.png")));
			lblToken20.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			lblToken20.setHorizontalAlignment(SwingConstants.CENTER);
			lblToken20.setIcon(new ImageIcon(
					Main.class.getResource("/img/fichas/ficha_20.png")));
			lblToken20.setTransferHandler(new TransferHandler("foreground")); // comun al boton
		}
		return lblToken20;
	}

	public JTextField getTxtToken20() {
		if (txtToken20 == null) {
			txtToken20 = new JTextField();
			txtToken20.setText("0");
			txtToken20.setName("20");
			txtToken20.setHorizontalAlignment(SwingConstants.CENTER);
			txtToken20.setEditable(false);
		}
		return txtToken20;
	}

	private JPanel getPanelToken50() {
		if (panelToken50 == null) {
			panelToken50 = new JPanel();
			panelToken50.setOpaque(false);
			panelToken50.setLayout(new BorderLayout(0, 0));
			panelToken50.add(getLblToken50(), BorderLayout.CENTER);
			panelToken50.add(getTxtToken50(), BorderLayout.SOUTH);
		}
		return panelToken50;
	}

	public JLabel getLblToken50() {
		if (lblToken50 == null) {
			lblToken50 = new JLabel("");
			lblToken50.setForeground(Color.BLUE);
			lblToken50.setIconTextGap(6);
			lblToken50.setEnabled(false);
			lblToken50.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/fichas/ficha_50_disabled.png")));
			lblToken50.setHorizontalAlignment(SwingConstants.CENTER);
			lblToken50.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			lblToken50.setIcon(new ImageIcon(
					Main.class.getResource("/img/fichas/ficha_50.png")));
			lblToken50.setTransferHandler(new TransferHandler("foreground")); // comun al boton
		}
		return lblToken50;
	}

	public JTextField getTxtToken50() {
		if (txtToken50 == null) {
			txtToken50 = new JTextField();
			txtToken50.setHorizontalAlignment(SwingConstants.CENTER);
			txtToken50.setText("0");
			txtToken50.setName("50");
			txtToken50.setEditable(false);
		}
		return txtToken50;
	}

	private JPanel getPanelToken100() {
		if (panelToken100 == null) {
			panelToken100 = new JPanel();
			panelToken100.setOpaque(false);
			panelToken100.setLayout(new BorderLayout(0, 0));
			panelToken100.add(getLblToken100());
			panelToken100.add(getTxtToken100(), BorderLayout.SOUTH);
		}
		return panelToken100;
	}

	public JLabel getLblToken100() {
		if (lblToken100 == null) {
			lblToken100 = new JLabel("");
			lblToken100.setForeground(Color.BLUE);
			lblToken100.setEnabled(false);
			lblToken100.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/fichas/ficha_100_disabled.png")));
			lblToken100.setHorizontalAlignment(SwingConstants.CENTER);
			lblToken100.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			lblToken100.setIcon(new ImageIcon(
					Main.class.getResource("/img/fichas/ficha_100.png")));
			lblToken100.setTransferHandler(new TransferHandler("foreground")); // comun al boton
		}
		return lblToken100;
	}

	public JTextField getTxtToken100() {
		if (txtToken100 == null) {
			txtToken100 = new JTextField();
			txtToken100.setText("0");
			txtToken100.setName("100");
			txtToken100.setHorizontalAlignment(SwingConstants.CENTER);
			txtToken100.setEditable(false);
		}
		return txtToken100;
	}

	private JPanel getPanelLeftGame() {
		if (panelLeftGame == null) {
			panelLeftGame = new JPanel();
			panelLeftGame.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelLeftGame.setOpaque(false);
			panelLeftGame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelLeftGame.add(getLblRoulette());
		}
		return panelLeftGame;
	}

	public JPanel getPanelBoard() {
		if (panelBoard == null) {
			panelBoard = new BoardPanel();
			panelBoard.setOpaque(false);
		}
		return panelBoard;
	}

	
	private JPanel getPanelTopGame() {
		if (panelTopGame == null) {
			panelTopGame = new JPanel();
			panelTopGame.setOpaque(false);
			panelTopGame.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
			panelTopGame.add(getLblHelpGame());
		}
		return panelTopGame;
	}

	public JLabel getLblHelpGame() {
		if (lblHelpGame == null) {
			lblHelpGame = new JLabel("");
			lblHelpGame.setToolTipText("Pulsa para ver la ayuda");
			lblHelpGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblHelpGame.setIcon(
					new ImageIcon(Main.class.getResource("/img/help.png")));
		}
		return lblHelpGame;
	}

	public JLabel getLblRoulette() {
		if (lblRoulette == null) {
			lblRoulette = new JLabel("");
			lblRoulette.setEnabled(false);
			lblRoulette.setDisabledIcon(new ImageIcon(Main.class.getResource("/img/ruleta_disabled.png")));
			lblRoulette.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblRoulette.setToolTipText("Pulsa para girar la ruleta");
			lblRoulette.setIcon(new ImageIcon(
					Main.class.getResource("/img/ruleta_static.png")));
		}
		return lblRoulette;
	}


	private JScrollPane getPanelRightGame() {
		if (panelRightGame == null) {
			panelRightGame = new JScrollPane();
			panelRightGame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelRightGame.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelRightGame.setOpaque(false);
			//para que no se vea la barra de scroll
			panelRightGame.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
			panelRightGame.setViewportView(getTextAreaMessages());
			panelRightGame.setColumnHeaderView(getLblMsg());
		}
		return panelRightGame;
	}
	public JLabel getLblMsg() {
		if (lblMsg == null) {
			lblMsg = new JLabel("Mensajes");
			lblMsg.setBackground(new Color(255, 255, 255));
			lblMsg.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMsg.setOpaque(true);
			lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblMsg;
	}
}
