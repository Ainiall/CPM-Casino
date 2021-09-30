package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.Date;
import java.util.Calendar;
/**
 * 
 * @author angela uo270318
 *
 */
public class UserView extends JDialog {

	private static final long serialVersionUID = -4271942294451333511L;
	private final JPanel panelMain = new JPanel();
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JLabel lblBirth;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JTextField txtPass;
	private JLabel lblPass2;
	private JTextField txtPass2;
	private JLabel lblDNI;
	private JTextField txtDNI;
	private JSpinner spinnerBirth;
	private JLabel lblHelp;

	private JPanel panelButtons;
	private JButton btnAccept;
	private JButton btnCancel;
	private JPanel panelTop;

	public UserView() {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setTitle("Casino 4 Tréboles: Usuario");
		setMinimumSize(new Dimension(500,300));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		panelMain.setOpaque(false);
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(0, 2, 0, 0));
		panelMain.add(getLblName());
		panelMain.add(getTxtName());
		panelMain.add(getLblSurname());
		panelMain.add(getTxtSurname());
		panelMain.add(getLblBirth());
		panelMain.add(getSpinnerBirth());
		panelMain.add(getLblUser());
		panelMain.add(getTxtUser());
		panelMain.add(getLblPass());
		panelMain.add(getTxtPass());
		panelMain.add(getLblPass2());
		panelMain.add(getTxtPass2());
		panelMain.add(getLblDNI());
		panelMain.add(getTxtDNI());
		getContentPane().add(getPanelButtons(), BorderLayout.SOUTH);
		getContentPane().add(getPanelTop(), BorderLayout.NORTH);
	}

	public JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre: ");
			lblName.setDisplayedMnemonic('n');
			lblName.setLabelFor(getTxtName());
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblName;
	}

	public JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtName.setColumns(10);
		}
		return txtName;
	}

	public JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Apellidos: ");
			lblSurname.setLabelFor(getTxtSurname());
			lblSurname.setDisplayedMnemonic('p');
			lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblSurname;
	}

	public JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtSurname.setColumns(10);
		}
		return txtSurname;
	}

	public JLabel getLblBirth() {
		if (lblBirth == null) {
			lblBirth = new JLabel("Fecha de nacimiento: ");
			lblBirth.setDisplayedMnemonic('f');
			lblBirth.setLabelFor(getSpinnerBirth());
			lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBirth;
	}

	public JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario: ");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUser;
	}

	public JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setEditable(false);
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtUser.setColumns(10);
		}
		return txtUser;
	}

	public JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("Contraseña: ");
			lblPass.setLabelFor(getTxtPass());
			lblPass.setDisplayedMnemonic('t');
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

	public JLabel getLblPass2() {
		if (lblPass2 == null) {
			lblPass2 = new JLabel("Confirmar contraseña: ");
			lblPass2.setLabelFor(getTxtPass2());
			lblPass2.setDisplayedMnemonic('m');
			lblPass2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPass2;
	}

	public JTextField getTxtPass2() {
		if (txtPass2 == null) {
			txtPass2 = new JPasswordField();
			txtPass2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPass2.setColumns(10);
		}
		return txtPass2;
	}

	public JLabel getLblDNI() {
		if (lblDNI == null) {
			lblDNI = new JLabel("DNI:");
			lblDNI.setLabelFor(getTxtDNI());
			lblDNI.setDisplayedMnemonic('d');
			lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDNI;
	}

	public JTextField getTxtDNI() {
		if (txtDNI == null) {
			txtDNI = new JTextField();
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDNI.setColumns(10);
		}
		return txtDNI;
	}

	private JSpinner getSpinnerBirth() {
		if (spinnerBirth == null) {
			SimpleDateFormat model = new SimpleDateFormat("dd-MM-yyyy");
			spinnerBirth = new JSpinner(new SpinnerDateModel(new Date(1010369987635L), null, new Date(1010629187635L), Calendar.DAY_OF_MONTH));
			spinnerBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerBirth.setEditor(
					new JSpinner.DateEditor(spinnerBirth, model.toPattern()));
		}
		return spinnerBirth;
	}

	public JLabel getLblHelp() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblHelp.setIcon(new ImageIcon(
					UserView.class.getResource("/img/help.png")));
		}
		return lblHelp;
	}

	
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setOpaque(false);
			panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
			panelButtons.add(getBtnAccept());
			panelButtons.add(getBtnCancel());
		}
		return panelButtons;
	}
	public JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("Aceptar");
			btnAccept.setMnemonic('a');
			btnAccept.setBackground(new Color(0, 128, 0));
			btnAccept.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAccept;
	}
	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setMnemonic('c');
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancel;
	}
	private JPanel getPanelTop() {
		if (panelTop == null) {
			panelTop = new JPanel();
			panelTop.setOpaque(false);
			panelTop.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
			panelTop.add(getLblHelp());
		}
		return panelTop;
	}
}
