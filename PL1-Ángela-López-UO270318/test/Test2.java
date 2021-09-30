
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Test2 extends JFrame {

	private static final long serialVersionUID = -6183354598641346912L;
	private JPanel contentPane;
	private JPanel panel;
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
					Test2 frame = new Test2();
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
	public Test2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 632, 340);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
			gbc_lblUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblUser.gridx = 0;
			gbc_lblUser.gridy = 0;
			panel.add(getLblUser(), gbc_lblUser);
			GridBagConstraints gbc_txtUser = new GridBagConstraints();
			gbc_txtUser.insets = new Insets(0, 0, 5, 0);
			gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUser.gridx = 2;
			gbc_txtUser.gridy = 0;
			panel.add(getTxtUser(), gbc_txtUser);
			GridBagConstraints gbc_lblUserError = new GridBagConstraints();
			gbc_lblUserError.insets = new Insets(0, 0, 5, 0);
			gbc_lblUserError.gridx = 2;
			gbc_lblUserError.gridy = 1;
			panel.add(getLblUserError(), gbc_lblUserError);
			GridBagConstraints gbc_lblPass = new GridBagConstraints();
			gbc_lblPass.insets = new Insets(0, 0, 5, 5);
			gbc_lblPass.gridx = 0;
			gbc_lblPass.gridy = 2;
			panel.add(getLblPass(), gbc_lblPass);
			GridBagConstraints gbc_txtPass = new GridBagConstraints();
			gbc_txtPass.insets = new Insets(0, 0, 5, 0);
			gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPass.gridx = 2;
			gbc_txtPass.gridy = 2;
			panel.add(getTxtPass(), gbc_txtPass);
			GridBagConstraints gbc_lblPassError = new GridBagConstraints();
			gbc_lblPassError.gridx = 2;
			gbc_lblPassError.gridy = 3;
			panel.add(getLblPassError(), gbc_lblPassError);
		}
		return panel;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario:");
			lblUser.setDisplayedMnemonic('u');
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
			lblUserError.setBorder(new EmptyBorder(5, 10, 5, 10));
			lblUserError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblUserError;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("Contraseña: ");
			lblPass.setDisplayedMnemonic('c');
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
			lblPassError.setBorder(new EmptyBorder(5, 10, 5, 10));
			lblPassError.setFont(new Font("Tahoma", Font.ITALIC, 12));
		}
		return lblPassError;
	}
}
