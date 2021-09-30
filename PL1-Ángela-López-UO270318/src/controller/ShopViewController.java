package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.Drink;
import model.Menu;
import model.Order;
import model.User;
import ui.Main;
import ui.ShopView;
import utils.StateBackground;
/**
 * 
 * @author angela uo270318
 *
 */
public class ShopViewController {

	private ShopView view = new ShopView();
	private Main main;
	private User user;
	private Menu menu;
	private Order order;
	private AccionBoton aB;
	private StateBackground state;
	private ResourceBundle texts;
	private Locale locale;
	private HelpBroker hb;

	public ShopViewController(Main main, User user, Locale locale) {
		this.main = main;
		this.user = user;
		this.locale = locale;
		state = new StateBackground(this);
		texts = ResourceBundle.getBundle("languages/texts", locale);
		aB = new AccionBoton();
		menu = new Menu(locale);
		order = new Order(locale);
		localizar();
		help();
		initView();

	}

	private void initView() {
		view.setLocationRelativeTo(main);
		view.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				paintButtons();
			}
		});
		view.getTxtBalance().setText(String.valueOf(user.getBalance()));

		view.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		view.getBtnBuy().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getBalance() >= order.calculatePrice()) {
					showDialog();
				} else {
					JOptionPane.showMessageDialog(view,
							texts.getString("error_balance"));
				}
			}
		});
		view.getBtnAlcohol().addItemListener(state);
		view.getBtnNotAlcohol().addItemListener(state);

		view.getPanelDrinks()
				.setLayout(new GridLayout(getList().size() / 5, 3, 5, 5));
		createDrinkCard();
		
		view.getLblHelp().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (hb.isDisplayed())
					hb.setDisplayed(false);
				else
					hb.setDisplayed(true);

			}
		});
		view.setVisible(true);

	}

	protected void showDialog() {
		String msg = view.getTextAreaOrder().getText() + "\n"
				+ view.getLblExtra().getText() + "\n"
				+ view.getTextAreaExtra().getText()
				+ "\n-----------------------\n" + texts.getString("price")
				+ view.getTxtPrice().getText();

		int answer = JOptionPane.showConfirmDialog(view,
				texts.getString("confirm_title") + "\n-----------------------\n"
						+ msg,
				texts.getString("confirm"), JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (answer == 0) {
			user.setBalance(user.getBalance() - order.calculatePrice());
			main.getTextAreaMessages()
					.append("\n\n-----------------------------\n"
							+ texts.getString("order") + "\n" + msg
							+ "\n-----------------------------");
			init();
			view.dispose();
		}

	}

	public List<Drink> getList() {
		if (view.getBtnAlcohol().isSelected()) {
			return menu.getAlcoholList();
		} else if (view.getBtnNotAlcohol().isSelected()) {
			return menu.getNotAlcoholList();
		} else {
			return menu.getListDrinks();
		}
	}

	private void createDrinkCard() {
		view.getPanelDrinks().removeAll();
		for (int i = 0; i < getList().size(); i++) {
			view.getPanelDrinks().add(newPanel(i));
		}
	}

	private JPanel newPanel(Integer pos) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setName(pos.toString());
		panel.add(newButton(pos), BorderLayout.CENTER);
		panel.add(newText(pos), BorderLayout.SOUTH);
		return panel;
	}

	private JLabel newText(Integer pos) {
		JLabel label;
		if (locale.equals(new Locale("es"))) {
			label = new JLabel(String.valueOf(
					getList().get(pos).getPrice() + texts.getString("badge")));
		} else {
			label = new JLabel(String.valueOf(
					texts.getString("badge") + getList().get(pos).getPrice()));
		}
		label.setBorder(new EmptyBorder(0, 10, 0, 10));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}

	private JButton newButton(Integer pos) {
		JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(getList().get(pos).toString(locale));
		boton.setActionCommand(pos.toString());
		boton.addMouseListener(aB);
		return boton;
	}

	private void paintButtons() {
		for (int i = 0; i < view.getPanelDrinks().getComponents().length; i++) {
			JPanel panel = (JPanel) (view.getPanelDrinks().getComponents()[i]);
			JButton btn = (JButton) panel.getComponent(0);
			setScaledImage(btn, getList().get(i).getPhoto());
		}
	}

	private void setScaledImage(JButton btn, String url) {
		Image imgOriginal = new ImageIcon(getClass().getResource(url))
				.getImage();
		Image imgScaled = imgOriginal.getScaledInstance(btn.getWidth(),
				btn.getHeight(), Image.SCALE_FAST);
		ImageIcon icon = new ImageIcon(imgScaled);
		btn.setIcon(icon);
	}

	class AccionBoton extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			JButton bt = (JButton) e.getSource();
			if (e.getButton() == MouseEvent.BUTTON1) { // click izquiero, 2
														// central 3 derecho
				addToOrder(Integer.parseInt(bt.getActionCommand()));
			} else
				deleteFromOrder(Integer.parseInt(bt.getActionCommand()));
		}
	}

	private void addToOrder(int pos) {
		Drink d = getList().get(pos);
		int i = (int) view.getSpinnerUnits().getValue();
		order.add(d, i);
		showOrder(d);
		view.getTxtPrice()
		.setText(String.valueOf(order.calculatePrice()));

	}

	public void deleteFromOrder(int pos) {
		Drink d = getList().get(pos);
		int i = (int) view.getSpinnerUnits().getValue();
		order.delete(d, i);
		showOrder(d);
		view.getTxtPrice()
				.setText(String.valueOf(order.calculatePrice()));
	}

	private void showOrder(Drink drink) {
		view.getTextAreaOrder().setText(order.showOrder());
	}

	protected void init() {
		order.inicializar();
	}

	private void localizar() {
		view.setTitle(texts.getString("shop_title"));
		view.getLblBalance().setText(texts.getString("balance"));
		view.getBtnAlcohol().setText(texts.getString("alcohol"));
		view.getBtnAlcohol()
				.setMnemonic(texts.getString("alcohol_mn").charAt(0));
		view.getBtnNotAlcohol().setText(texts.getString("not_alcohol"));
		view.getBtnNotAlcohol()
				.setMnemonic(texts.getString("not_alcohol_mn").charAt(0));
		view.getLblUnits().setText(texts.getString("units"));
		view.getLblUnits()
				.setDisplayedMnemonic(texts.getString("units_mn").charAt(0));
		view.getLblPrice().setText(texts.getString("price"));
		view.getBtnBuy().setText(texts.getString("buy"));
		view.getBtnBuy().setMnemonic(texts.getString("buy_mn").charAt(0));
		view.getBtnCancel().setText(texts.getString("cancel"));
		view.getBtnCancel().setMnemonic(texts.getString("cancel_mn").charAt(0));
		view.getLblExtra().setText(texts.getString("extra"));
		view.getLblExtra()
				.setDisplayedMnemonic(texts.getString("extra_mn").charAt(0));
		view.getLblHelp().setToolTipText(texts.getString("help_tp"));

	}

	public void initDrinkMenu(int filter) {
		if (filter == 0) {
			view.getPanelDrinks()
					.setLayout(new GridLayout(getList().size() / 5, 3, 5, 5));
		} else {
			view.getPanelDrinks()
					.setLayout(new GridLayout(getList().size() / 3, 3, 5, 5));
		}
		createDrinkCard();
		view.pack(); // The pack() method sizes the frame so that all its
						// contents are at or above their preferred sizes...
		view.getPanelDrinks().repaint(); // para que se actualice el fondo
		paintButtons();
	}
	
	private void help() {
		URL hsURL;
		HelpSet hs;
		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		} catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}
		hb = hs.createHelpBroker();
		// inicializarla aunque se mantenga oculta para que se cargue antes
		hb.initPresentation();

		// habilita F1 como tecla de ayuda
		hb.enableHelpKey(view.getRootPane(), "tienda", hs);
		hb.enableHelpKey(view.getBtnAlcohol(), "filtros", hs);
		hb.enableHelpKey(view.getBtnNotAlcohol(), "filtros", hs);
	}
}
