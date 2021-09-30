
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.GridBagLayout;

public class Test extends JFrame {

	private static final long serialVersionUID = -2253954231975013736L;
	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
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
			panelBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelBottom.setOpaque(false);
			panelBottom.add(getBtnLogin());
			panelBottom.add(getBtnRegister());
		}
		return panelBottom;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Inicio");
			btnLogin.setMnemonic('i');
			btnLogin.setBackground(Color.WHITE);
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnLogin;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registro");
			btnRegister.setMnemonic('r');
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
	private JLabel getLblTitle() {
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
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelCenter.setLayout(gbl_panel);
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
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
			panelMenu.add(getComboBox_1());
			panelMenu.add(getLabel_1());
		}
		return panelMenu;
	}
	private JLabel getLabel_1() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.setIcon(new ImageIcon(Test.class.getResource("/img/help2.png")));
		}
		return lblHelp;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBoxLanguage == null) {
			comboBoxLanguage = new JComboBox<String>();
			comboBoxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBoxLanguage.setMaximumRowCount(2);
			comboBoxLanguage.setModel(new DefaultComboBoxModel<String>(new String[] {"ES", "EN"}));
		}
		return comboBoxLanguage;
	}
	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setIcon(new ImageIcon(Test.class.getResource("/img/trebol.png")));
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
	
	
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario:");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUser;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JLabel getLblUserError() {
		if (lblUserError == null) {
			lblUserError = new JLabel("El usuario ya existe");
			lblUserError.setForeground(Color.RED);
			lblUserError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblUserError;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("Contraseña: ");
			lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPass;
	}
	private JTextField getTxtPass() {
		if (txtPass == null) {
			txtPass = new JTextField();
			txtPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPass.setColumns(10);
		}
		return txtPass;
	}
	private JLabel getLblPassError() {
		if (lblPassError == null) {
			lblPassError = new JLabel("La contraseña es incorrecta");
			lblPassError.setForeground(Color.RED);
			lblPassError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblPassError;
	}
}
