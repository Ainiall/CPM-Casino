package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.User;
import ui.BankView;
import ui.Main;
/**
 * 
 * @author angela uo270318
 *
 */
public class BankViewController {
	private BankView view = new BankView();
	private Main main;
	private User user;
	private ClickSpinner proc;
	private ResourceBundle texts;
	private boolean gift;
	private Locale locale;
	private HelpBroker hb;

	public BankViewController(Main main, User user, Locale locale, boolean b) {
		proc = new ClickSpinner();
		gift = b;
		this.locale = locale;
		texts = ResourceBundle.getBundle("languages/texts", locale);
		this.main = main;
		this.user = user;
		help();
		initView();
	}

	private void initView() {
		showWelcomeMessage();
		localizar();
		view.setLocationRelativeTo(main);
		view.getTxtBalance().setText(String.valueOf(user.getBalance()));
		view.getSpinner5().addChangeListener(proc);
		view.getSpinner10().addChangeListener(proc);
		view.getSpinner20().addChangeListener(proc);
		view.getSpinner50().addChangeListener(proc);
		view.getSpinner100().addChangeListener(proc);

		view.getBtnAccept().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setBalance(
						Float.parseFloat(view.getTxtBalance().getText()));
				user.setTokens((int) view.getSpinner5().getValue(),
						(int) view.getSpinner10().getValue(),
						(int) view.getSpinner20().getValue(),
						(int) view.getSpinner50().getValue(),
						(int) view.getSpinner100().getValue());
				if (gift) {
					new GameViewController(main, user, locale);
				}
				view.dispose();
			}
		});

		view.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				if (gift) {
					new GameViewController(main, user, locale);
				}
			}
		});

		view.getLblAddMoney().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new CardViewController(view, user, locale);
			}
		});
		
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

	private void showWelcomeMessage() {
		if (gift) {
			view.getPanelTop().setVisible(true);
		} else {
			view.getPanelTop().setVisible(false);
		}
	}

	class ClickSpinner implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSpinner j = (JSpinner) e.getSource();
			calculateTokens(j);
		}
	}

	public void calculateTokens(JSpinner j) {
		int s5 = (int) view.getSpinner5().getValue()
				* Integer.parseInt(view.getSpinner5().getName());
		int s10 = (int) view.getSpinner10().getValue()
				* Integer.parseInt(view.getSpinner10().getName());
		int s20 = (int) view.getSpinner20().getValue()
				* Integer.parseInt(view.getSpinner20().getName());
		int s50 = (int) view.getSpinner50().getValue()
				* Integer.parseInt(view.getSpinner50().getName());
		int s100 = (int) view.getSpinner100().getValue()
				* Integer.parseInt(view.getSpinner100().getName());
		int total = s5 + s10 + s20 + s50 + s100;
		if (user.getBalance() - total >= 0) {
			view.getTxtTokens().setText(String.valueOf(total));
			view.getTxtBalance().setText(String.valueOf(user.getBalance()-total));
		} else {
			j.setValue(j.getPreviousValue());
			JOptionPane.showMessageDialog(view,
					texts.getString("error_balance"),"ERROR", 0);
		}
	}

	private void localizar() {
		view.setTitle(texts.getString("bank_title"));
		view.getLblGift().setText(texts.getString("gift"));
		view.getLblBalance().setText(texts.getString("balance"));
		view.getLblBalance()
				.setDisplayedMnemonic(texts.getString("balance_mn").charAt(0));
		view.getLblTokens().setText(texts.getString("tokens"));
		view.getLblTokens()
				.setDisplayedMnemonic(texts.getString("tokens_mn").charAt(0));
		view.getLblAddMoney().setToolTipText(texts.getString("add_tp"));
		view.getLblHelp().setToolTipText(texts.getString("help_tp"));
		view.getBtnAccept().setText(texts.getString("accept"));
		view.getBtnAccept().setMnemonic(texts.getString("accept_mn").charAt(0));
		view.getBtnCancel().setText(texts.getString("cancel"));
		view.getBtnCancel().setMnemonic(texts.getString("cancel_mn").charAt(0));
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
		hb.enableHelpKey(view.getRootPane(), "banco", hs);
		hb.enableHelp(view.getLblHelp(), "banco", hs);
		hb.enableHelp(view.getLblAddMoney(), "tarjeta", hs);
	}


}
