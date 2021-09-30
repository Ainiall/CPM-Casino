package ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
/**
 * 
 * @author angela uo270318
 *
 */
public class CardView extends JDialog {

	private static final long serialVersionUID = -3281859600940830776L;
	private JPanel contentPane;
	private JPanel panelBank;
	private JLabel lblTipoDeTarjeta;
	private JComboBox<String> comboBoxCard;
	private JLabel lblNmeroDeTarjeta;
	private JTextField txtCardNumber;
	private JLabel lblCcvi;
	private JTextField txtCardCCVI;
	private JLabel lblFechaDeCaducidad;
	private JComboBox<String> comboBoxMonth;
	private JComboBox<String> comboBoxYear;
	private JPanel panelButtons;
	private JButton btnCancel;
	private JButton btnAccept;
	private JLabel lblMoney;
	private JTextField txtMoney;
	private JPanel panel;

	
	public CardView() {
		setModal(true);
		setTitle("Casino 4 Tréboles: Tarjeta");
		setBounds(0, 0, 500, 300);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelBank(), BorderLayout.CENTER);
		contentPane.add(getPanelButtons(), BorderLayout.SOUTH);
	}

	private JPanel getPanelBank() {
		if (panelBank == null) {
			panelBank = new JPanel();
			panelBank.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelBank.setOpaque(false);
			panelBank.setBounds(10, 74, 368, 335);
			panelBank.setLayout(new GridLayout(0, 2, 0, 0));
			panelBank.add(getLblTipoDeTarjeta());
			panelBank.add(getComboBoxCard());
			panelBank.add(getLblNmeroDeTarjeta());
			panelBank.add(getTxtCardNumber());
			panelBank.add(getLblCcvi());
			panelBank.add(getTxtCardCCVI());
			panelBank.add(getLblFechaDeCaducidad());
			panelBank.add(getPanel());
			panelBank.add(getLblMoney());
			panelBank.add(getTxtMoney());
		}
		return panelBank;
	}

	public JLabel getLblTipoDeTarjeta() {
		if (lblTipoDeTarjeta == null) {
			lblTipoDeTarjeta = new JLabel("Tipo de Tarjeta: ");
			lblTipoDeTarjeta.setLabelFor(getComboBoxCard());
			lblTipoDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblTipoDeTarjeta;
	}

	private JComboBox<String> getComboBoxCard() {
		if (comboBoxCard == null) {
			comboBoxCard = new JComboBox<String>();
			comboBoxCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxCard.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Visa", "MasterCard", "American Express" }));
		}
		return comboBoxCard;
	}

	public JLabel getLblNmeroDeTarjeta() {
		if (lblNmeroDeTarjeta == null) {
			lblNmeroDeTarjeta = new JLabel("Número de Tarjeta: ");
			lblNmeroDeTarjeta.setLabelFor(getTxtCardNumber());
			lblNmeroDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNmeroDeTarjeta;
	}

	public JTextField getTxtCardNumber() {
		if (txtCardNumber == null) {
			txtCardNumber = new JTextField();
			txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCardNumber.setColumns(10);
		}
		return txtCardNumber;
	}

	public JLabel getLblCcvi() {
		if (lblCcvi == null) {
			lblCcvi = new JLabel("CCVI: ");
			lblCcvi.setLabelFor(getTxtCardCCVI());
			lblCcvi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblCcvi;
	}

	public JTextField getTxtCardCCVI() {
		if (txtCardCCVI == null) {
			txtCardCCVI = new JTextField();
			txtCardCCVI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCardCCVI.setColumns(10);
		}
		return txtCardCCVI;
	}

	public JLabel getLblFechaDeCaducidad() {
		if (lblFechaDeCaducidad == null) {
			lblFechaDeCaducidad = new JLabel("Fecha de caducidad:");
			lblFechaDeCaducidad.setLabelFor(getComboBoxYear());
			lblFechaDeCaducidad.setDisplayedMnemonic('f');
			lblFechaDeCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblFechaDeCaducidad;
	}

	private JComboBox<String> getComboBoxMonth() {
		if (comboBoxMonth == null) {
			comboBoxMonth = new JComboBox<String>();
			comboBoxMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxMonth.setModel(
					new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4",
							"5", "6", "7", "8", "9", "10", "11", "12" }));
		}
		return comboBoxMonth;
	}

	private JComboBox<String> getComboBoxYear() {
		if (comboBoxYear == null) {
			comboBoxYear = new JComboBox<String>();
			comboBoxYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxYear.setModel(new DefaultComboBoxModel<String>(
					new String[] { "20", "21", "22", "23", "24", "25", "26",
							"27", "28", "29", "30", "31", "32", "33", "34",
							"35", "36", "37", "38", "39", "40" }));
		}
		return comboBoxYear;
	}
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelButtons.add(getBtnAccept());
			panelButtons.add(getBtnCancel());
		}
		return panelButtons;
	}
	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancel;
	}
	public JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("Aceptar");
			btnAccept.setBackground(new Color(0, 128, 0));
			btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAccept;
	}
	public JLabel getLblMoney() {
		if (lblMoney == null) {
			lblMoney = new JLabel("Transferir:");
			lblMoney.setDisplayedMnemonic('r');
			lblMoney.setLabelFor(getTxtMoney());
			lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblMoney;
	}
	public JTextField getTxtMoney() {
		if (txtMoney == null) {
			txtMoney = new JTextField();
			txtMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtMoney.setColumns(10);
		}
		return txtMoney;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getComboBoxMonth());
			panel.add(getComboBoxYear());
		}
		return panel;
	}
}
