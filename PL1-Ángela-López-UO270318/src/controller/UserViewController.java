package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.User;
import ui.Main;
import ui.UserView;
import utils.FileUtil;
/**
 * 
 * @author angela uo270318
 *
 */
public class UserViewController {

	private UserView view = new UserView();
	private Main main;
	private User user;
	private List<User> listUsers = new ArrayList<User>();
	private Locale locale;
	private ResourceBundle texts;
	private HelpBroker hb;

	public UserViewController(Main main, Locale locale) {
		this.locale = locale;
		this.main = main;
		texts = ResourceBundle.getBundle("languages/texts", locale);
		localizar();
		help();
		initView();
	}

	private void initView() {
		view.setLocationRelativeTo(main);
		view.getTxtUser().setText(main.getTxtUser().getText());
		view.getTxtPass().setText(main.getTxtPass().getText());

		view.getBtnAccept().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notEmptyFields()) {
					JPasswordField pass1 = (JPasswordField) view.getTxtPass();
					JPasswordField pass2 = (JPasswordField) view.getTxtPass2();
					if (String.valueOf(pass1.getPassword())
							.equals(String.valueOf(pass2.getPassword()))) {
						FileUtil.loadUsersFile("src/files/clientes.dat",
								listUsers);
						boolean valid = true;
						for (User u : listUsers) {
							if (u.getDni().equals(view.getTxtDNI().getText())) {
								JOptionPane.showMessageDialog(view,
										texts.getString("error_dni"));
								valid = false;
								break;
							}
						}
						if (valid) {
							registerUser(pass1);
						}
					} else {
						JOptionPane.showMessageDialog(view,
								texts.getString("error_password"));
					}
				} else
					JOptionPane.showMessageDialog(main,
							texts.getString("empty_fields"), "ERROR",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeView();
			}
		});

		view.setVisible(true);
	}

	protected boolean notEmptyFields() {
		if (view.getTxtDNI().getText().trim().length() > 0
				&& view.getTxtName().getText().trim().length() > 0
				&& view.getTxtSurname().getText().trim().length() > 0
				&& view.getTxtUser().getText().trim().length() > 0
				&& view.getTxtPass().getText().trim().length() > 0
				&& view.getTxtPass().getText().trim().length() > 0) {
			return true;
		} else
			return false;

	}

	protected void registerUser(JPasswordField pass1) {
		String dni = view.getTxtDNI().getText();
		String name = view.getTxtName().getText() + " "
				+ view.getTxtSurname().getText();
		String userName = view.getTxtUser().getText();
		String pass = String.valueOf(pass1.getPassword());
		float balance = 100;
		user = new User(dni, name, userName, pass, balance);
		FileUtil.saveUserToFile("clientes", user);
		main.card.show(main.getContentPane(), "game");
		closeView();
		new BankViewController(main, user, locale, true);
	}

	private void closeView() {
		view.dispose();
	}

	private void localizar() {
		view.setTitle(texts.getString("user_title"));
		view.getLblName().setText(texts.getString("name"));
		view.getLblName()
				.setDisplayedMnemonic(texts.getString("name_mn").charAt(0));
		view.getLblSurname().setText(texts.getString("surname"));
		view.getLblSurname()
				.setDisplayedMnemonic(texts.getString("surname_mn").charAt(0));
		view.getLblBirth().setText(texts.getString("birth"));
		view.getLblBirth()
				.setDisplayedMnemonic(texts.getString("birth_mn").charAt(0));
		view.getLblPass().setText(texts.getString("pass"));
		view.getLblPass()
				.setDisplayedMnemonic(texts.getString("pass_mn2").charAt(0));
		view.getLblPass2().setText(texts.getString("confirm_pass"));
		view.getLblPass2().setDisplayedMnemonic(
				texts.getString("confirm_pass_mn").charAt(0));
		view.getLblUser().setText(texts.getString("user"));

		view.getBtnAccept().setText(texts.getString("accept"));
		view.getBtnAccept().setMnemonic(texts.getString("accept_mn").charAt(0));
		view.getBtnCancel().setText(texts.getString("cancel"));
		view.getBtnCancel().setMnemonic(texts.getString("cancel_mn").charAt(0));
		view.getLblHelp().setToolTipText(texts.getString("help_tp"));
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
		hb= hs.createHelpBroker();
		// inicializarla aunque se mantenga oculta para que se cargue antes
		hb.initPresentation();

		// habilita F1 como tecla de ayuda
		hb.enableHelpKey(view.getRootPane(), "registro", hs);
		hb.enableHelp(view.getLblHelp(), "registro", hs);
	}
}
