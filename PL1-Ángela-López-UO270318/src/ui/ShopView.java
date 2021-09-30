package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
/**
 * 
 * @author angela uo270318
 *
 */
public class ShopView extends JDialog {

	private static final long serialVersionUID = 531683322890750164L;
	private JPanel contentPane;
	private JPanel panelLeft;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JToggleButton btnAlcohol;
	private JLabel lblUnits;
	private JSpinner spinnerUnits;
	private JScrollPane scrollPanelOrder;
	private JButton btnBuy;
	private JButton btnCancel;
	private JPanel panelDrinks;
	private JToggleButton btnNotAlcohol;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JTextArea textAreaOrder;
	private JPanel panelBalance;
	private JPanel panelFilter;
	private JPanel panelPrice;
	private JPanel panelButtons;
	private JPanel panelUnits;
	private JPanel panel_2;
	private JPanel panel_1;
	private JScrollPane scrollPaneExtra;
	private JTextArea textAreaExtra;
	private JLabel lblExtra;
	private JPanel panelTop;
	private JLabel lblHelp;

	// para poder deseleccionar el actual, comentar para preview
	private final ButtonGroup buttonGroup = new ButtonGroup() {
		private static final long serialVersionUID = 7495914453451496362L;

		@Override
		public void setSelected(ButtonModel model, boolean selected) {
			if (selected) {
				super.setSelected(model, selected);
			} else {
				clearSelection();
			}
		}
	};

	public ShopView() {
		setModal(true);
		setTitle("Casino 4 Tréboles: Tienda");
		setBounds(0, 0, 800, 500);
		setMinimumSize(new Dimension(800, 500));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDrinks(), BorderLayout.CENTER);
		contentPane.add(getPanelLeft(), BorderLayout.WEST);
		contentPane.add(getPanelTop(), BorderLayout.NORTH);

	}

	private JPanel getPanelLeft() {
		if (panelLeft == null) {
			panelLeft = new JPanel();
			panelLeft.setOpaque(false);
			panelLeft.setLayout(new GridLayout(3, 1, 0, 0));
			panelLeft.add(getPanel_1());
			panelLeft.add(getScrollPanelOrder());
			panelLeft.add(getPanel_2());
		}
		return panelLeft;
	}

	public JLabel getLblBalance() {
		if (lblBalance == null) {
			lblBalance = new JLabel("Saldo: ");
			lblBalance.setLabelFor(getTxtBalance());
			lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblBalance;
	}

	public JTextField getTxtBalance() {
		if (txtBalance == null) {
			txtBalance = new JTextField();
			txtBalance.setEditable(false);
			txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtBalance.setColumns(10);
		}
		return txtBalance;
	}

	public JToggleButton getBtnAlcohol() {
		if (btnAlcohol == null) {
			btnAlcohol = new JToggleButton("Alcohólicas");
			btnAlcohol.setFocusPainted(false);
			btnAlcohol
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAlcohol.setMnemonic('a');
			buttonGroup.add(btnAlcohol);
			btnAlcohol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAlcohol;
	}

	public JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Unidades: ");
			lblUnits.setDisplayedMnemonic('u');
			lblUnits.setLabelFor(getSpinnerUnits());
			lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUnits;
	}

	@SuppressWarnings("deprecation")
	public JSpinner getSpinnerUnits() {
		if (spinnerUnits == null) {
			spinnerUnits = new JSpinner();
			spinnerUnits.setModel(new SpinnerNumberModel(new Integer(1),
					new Integer(1), null, new Integer(1)));
			spinnerUnits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return spinnerUnits;
	}

	private JScrollPane getScrollPanelOrder() {
		if (scrollPanelOrder == null) {
			scrollPanelOrder = new JScrollPane();
			scrollPanelOrder.setViewportView(getTextAreaOrder());
		}
		return scrollPanelOrder;
	}

	public JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Comprar");
			btnBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBuy.setMnemonic('p');
			btnBuy.setBackground(new Color(0, 128, 0));
			btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnBuy;
	}

	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCancel.setMnemonic('c');
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancel;
	}

	public JPanel getPanelDrinks() {
		if (panelDrinks == null) {
			panelDrinks = new JPanel();
			panelDrinks.setLayout(new GridLayout(5, 3, 0, 0));
		}
		return panelDrinks;
	}

	public JToggleButton getBtnNotAlcohol() {
		if (btnNotAlcohol == null) {
			btnNotAlcohol = new JToggleButton("Sin alcohol");
			btnNotAlcohol.setFocusPainted(false);
			btnNotAlcohol
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNotAlcohol.setMnemonic('s');
			buttonGroup.add(btnNotAlcohol);
			btnNotAlcohol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnNotAlcohol;
	}

	public JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Precio: ");
			lblPrice.setLabelFor(getTxtPrice());

			lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPrice;
	}

	public JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPrice.setEditable(false);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}

	public JTextArea getTextAreaOrder() {
		if (textAreaOrder == null) {
			textAreaOrder = new JTextArea();
			textAreaOrder.setEditable(false);
			textAreaOrder.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return textAreaOrder;
	}

	private JPanel getPanelBalance() {
		if (panelBalance == null) {
			panelBalance = new JPanel();
			panelBalance.setOpaque(false);
			panelBalance.setLayout(new GridLayout(0, 2, 0, 0));
			panelBalance.add(getLblBalance());
			panelBalance.add(getTxtBalance());
		}
		return panelBalance;
	}

	private JPanel getPanelFilter() {
		if (panelFilter == null) {
			panelFilter = new JPanel();
			panelFilter.setOpaque(false);
			panelFilter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelFilter.add(getBtnAlcohol());
			panelFilter.add(getBtnNotAlcohol());
		}
		return panelFilter;
	}

	private JPanel getPanelPrice() {
		if (panelPrice == null) {
			panelPrice = new JPanel();
			panelPrice.setOpaque(false);
			panelPrice.add(getLblPrice());
			panelPrice.add(getTxtPrice());
		}
		return panelPrice;
	}

	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setOpaque(false);
			panelButtons.add(getBtnBuy());
			panelButtons.add(getBtnCancel());
		}
		return panelButtons;
	}

	private JPanel getPanelUnits() {
		if (panelUnits == null) {
			panelUnits = new JPanel();
			panelUnits.setOpaque(false);
			panelUnits.setLayout(new GridLayout(0, 2, 0, 0));
			panelUnits.add(getLblUnits());
			panelUnits.add(getSpinnerUnits());
		}
		return panelUnits;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setOpaque(false);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
			panel_2.add(getPanelPrice());
			panel_2.add(getScrollPaneExtra());
			panel_2.add(getPanelButtons());
		}
		return panel_2;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
			panel_1.add(getPanelBalance());
			panel_1.add(getPanelFilter());
			panel_1.add(getPanelUnits());
		}
		return panel_1;
	}

	private JScrollPane getScrollPaneExtra() {
		if (scrollPaneExtra == null) {
			scrollPaneExtra = new JScrollPane();
			scrollPaneExtra.setOpaque(false);
			scrollPaneExtra.setViewportView(getTextAreaExtra());
			scrollPaneExtra.setColumnHeaderView(getLblExtra());
		}
		return scrollPaneExtra;
	}

	public JTextArea getTextAreaExtra() {
		if (textAreaExtra == null) {
			textAreaExtra = new JTextArea();
			textAreaExtra.setLineWrap(true);
			textAreaExtra.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return textAreaExtra;
	}

	public JLabel getLblExtra() {
		if (lblExtra == null) {
			lblExtra = new JLabel("OBSERVACIONES: ");
			lblExtra.setDisplayedMnemonic('o');
			lblExtra.setLabelFor(getTextAreaExtra());
			lblExtra.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblExtra;
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

	public JLabel getLblHelp() {
		if (lblHelp == null) {
			lblHelp = new JLabel("");
			lblHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblHelp.setIcon(
					new ImageIcon(ShopView.class.getResource("/img/help.png")));
			lblHelp.setToolTipText("Pulsa para ver la ayuda");
		}
		return lblHelp;
	}
}
