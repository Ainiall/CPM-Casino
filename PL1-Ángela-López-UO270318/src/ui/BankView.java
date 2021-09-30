package ui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
/**
 * 
 * @author angela uo270318
 *
 */
public class BankView extends JDialog{

	private static final long serialVersionUID = -4197969368882568582L;
	private JPanel contentPane;
	private JPanel panelBottom;
	private JButton btnAccept;
	private JButton btnCancel;
	private JPanel panelCenter;
	private JPanel panelTop;
	private JLabel lblGift;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JLabel lblTokens;
	private JTextField txtTokens;
	private JLabel lbl5;
	private JSpinner spinner5;
	private JLabel lbl10;
	private JSpinner spinner10;
	private JLabel lbl20;
	private JSpinner spinner20;
	private JLabel lbl50;
	private JSpinner spinner50;
	private JLabel lbl100;
	private JSpinner spinner100;
	private JLabel lblHelp;
	private JLabel lblAddMoney;
	private JLabel lblPresent1;
	private JLabel lblPresent2;

	public BankView() {
		setModal(true);
		setTitle("Casino 4 Tréboles: Banco");
		setBounds(0, 0, 800, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelTop(), BorderLayout.NORTH);
		contentPane.add(getPanelBottom(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanelBottom() {
		if (panelBottom == null) {
			panelBottom = new JPanel();
			panelBottom.setOpaque(false);
			panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
			panelBottom.add(getBtnAccept());
			panelBottom.add(getBtnCancel());
		}
		return panelBottom;
	}
	public JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("Aceptar");
			btnAccept.setBackground(new Color(0, 128, 0));
			btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAccept.setMnemonic('a');
		}
		return btnAccept;
	}
	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancel.setMnemonic('c');
		}
		return btnCancel;
	}
	private JPanel getPanel_1() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setOpaque(false);
			panelCenter.setLayout(null);
			panelCenter.add(getLblBalance());
			panelCenter.add(getTxtBalance());
			panelCenter.add(getLblTokens());
			panelCenter.add(getTxtTokens());
			panelCenter.add(getLbl5());
			panelCenter.add(getSpinner5());
			panelCenter.add(getLbl10());
			panelCenter.add(getSpinner10());
			panelCenter.add(getLbl20());
			panelCenter.add(getSpinner20());
			panelCenter.add(getLbl50());
			panelCenter.add(getSpinner50());
			panelCenter.add(getLbl100());
			panelCenter.add(getSpinner100());
			panelCenter.add(getLblHelp());
			panelCenter.add(getLblAddMoney());
		}
		return panelCenter;
	}
	public JPanel getPanelTop() {
		if (panelTop == null) {
			panelTop = new JPanel();
			panelTop.setOpaque(false);
			panelTop.add(getLblPresent1());
			panelTop.add(getLblGift());
			panelTop.add(getLblPresent2());
		}
		return panelTop;
	}
	public JLabel getLblGift() {
		if (lblGift == null) {
			lblGift = new JLabel("¡100€ de regalo por registrarte en nuestro casino!");
			lblGift.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblGift;
	}
	public JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("Saldo: ");
			lblBalance.setLabelFor(getTxtBalance());
			lblBalance.setDisplayedMnemonic('s');
			lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBalance.setBounds(10, 11, 141, 39);
		}
		return lblBalance;
	}
	public JTextField getTxtBalance() {
		if (txtBalance == null) {
			txtBalance = new JTextField();
			txtBalance.setEditable(false);
			txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtBalance.setBounds(161, 11, 256, 39);
			txtBalance.setColumns(10);
		}
		return txtBalance;
	}
	public JLabel getLblTokens() {
		if (lblTokens == null) {
			lblTokens = new JLabel("Fichas: ");
			lblTokens.setDisplayedMnemonic('f');
			lblTokens.setLabelFor(getTxtTokens());
			lblTokens.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTokens.setBounds(10, 61, 141, 39);
		}
		return lblTokens;
	}
	public JTextField getTxtTokens() {
		if (txtTokens == null) {
			txtTokens = new JTextField();
			txtTokens.setEditable(false);
			txtTokens.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTokens.setColumns(10);
			txtTokens.setBounds(161, 61, 256, 39);
		}
		return txtTokens;
	}
	private JLabel getLbl5() {
		if (lbl5 == null) {
			lbl5 = new JLabel("");
			lbl5.setIcon(new ImageIcon(BankView.class.getResource("/img/fichas/ficha_5.png")));
			lbl5.setBounds(14, 127, 141, 125);
		}
		return lbl5;
	}
	@SuppressWarnings("deprecation")
	public JSpinner getSpinner5() {
		if (spinner5 == null) {
			spinner5 = new JSpinner();
			spinner5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner5.setName("5");
			spinner5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner5.setBounds(25, 282, 125, 39);
		}
		return spinner5;
	}
	private JLabel getLbl10() {
		if (lbl10 == null) {
			lbl10 = new JLabel("");
			lbl10.setIcon(new ImageIcon(BankView.class.getResource("/img/fichas/ficha_10.png")));
			lbl10.setBounds(169, 127, 141, 125);
		}
		return lbl10;
	}
	@SuppressWarnings("deprecation")
	public JSpinner getSpinner10() {
		if (spinner10 == null) {
			spinner10 = new JSpinner();
			spinner10.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner10.setName("10");
			spinner10.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner10.setBounds(176, 282, 125, 39);
		}
		return spinner10;
	}
	private JLabel getLbl20() {
		if (lbl20 == null) {
			lbl20 = new JLabel("");
			lbl20.setIcon(new ImageIcon(BankView.class.getResource("/img/fichas/ficha_20.png")));
			lbl20.setBounds(324, 127, 141, 125);
		}
		return lbl20;
	}
	@SuppressWarnings("deprecation")
	public JSpinner getSpinner20() {
		if (spinner20 == null) {
			spinner20 = new JSpinner();
			spinner20.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner20.setName("20");
			spinner20.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner20.setBounds(327, 282, 125, 39);
		}
		return spinner20;
	}
	private JLabel getLbl50() {
		if (lbl50 == null) {
			lbl50 = new JLabel("");
			lbl50.setIcon(new ImageIcon(BankView.class.getResource("/img/fichas/ficha_50.png")));
			lbl50.setBounds(479, 127, 141, 125);
		}
		return lbl50;
	}
	@SuppressWarnings("deprecation")
	public JSpinner getSpinner50() {
		if (spinner50 == null) {
			spinner50 = new JSpinner();
			spinner50.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner50.setName("50");
			spinner50.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner50.setBounds(478, 282, 125, 39);
		}
		return spinner50;
	}
	private JLabel getLbl100() {
		if (lbl100 == null) {
			lbl100 = new JLabel("");
			lbl100.setIcon(new ImageIcon(BankView.class.getResource("/img/fichas/ficha_100.png")));
			lbl100.setBounds(634, 127, 141, 125);
		}
		return lbl100;
	}
	@SuppressWarnings("deprecation")
	public JSpinner getSpinner100() {
		if (spinner100 == null) {
			spinner100 = new JSpinner();
			spinner100.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinner100.setName("100");
			spinner100.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner100.setBounds(629, 282, 125, 39);
		}
		return spinner100;
	}
	public JLabel getLblHelp() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.setToolTipText("Pulsa para ver la ayuda");
			lblHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblHelp.setIcon(new ImageIcon(
					UserView.class.getResource("/img/help.png")));
			lblHelp.setBounds(738, 11, 38, 39);
		}
		return lblHelp;
	}
	public JLabel getLblAddMoney() {
		if (lblAddMoney == null) {
			lblAddMoney = new JLabel("");
			lblAddMoney.setToolTipText("Pulsa para pasar saldo desde una tarjeta de crédito");
			lblAddMoney.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddMoney.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAddMoney.setIcon(new ImageIcon(BankView.class.getResource("/img/add_money.png")));
			lblAddMoney.setBounds(455, 29, 64, 50);
		}
		return lblAddMoney;
	}
	private JLabel getLblPresent1() {
		if (lblPresent1 == null) {
			lblPresent1 = new JLabel("");
			lblPresent1.setIcon(new ImageIcon(BankView.class.getResource("/img/present.png")));
		}
		return lblPresent1;
	}
	private JLabel getLblPresent2() {
		if (lblPresent2 == null) {
			lblPresent2 = new JLabel("");
			lblPresent2.setIcon(new ImageIcon(BankView.class.getResource("/img/present.png")));
		}
		return lblPresent2;
	}

}
