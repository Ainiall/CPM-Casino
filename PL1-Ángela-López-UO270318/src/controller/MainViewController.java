package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;


import model.User;
import ui.Main;
import utils.FileUtil;

import javax.help.*;
import java.net.*;
import java.io.*;
/**
 * 
 * @author angela uo270318
 *
 */
public class MainViewController {

	private Main main;
	private List<User> listUsers = new ArrayList<User>();
	private String locale_language;
	private Locale locale;
	private ResourceBundle texts;
	HelpBroker hb;

	public MainViewController(Main main) {
		locale= Locale.getDefault();
		locale_language=locale.getLanguage();
		if(locale_language.equals("es")) {
			main.getComboBoxLanguage().setSelectedIndex(0);
		}else {
			main.getComboBoxLanguage().setSelectedIndex(1);
		}
		this.main = main;
		help();
		localizar();
		initLoginView();
	}

	@SuppressWarnings("serial")
	private void initLoginView() {
		
		main.getTxtUser().requestFocusInWindow();
		main.getComboBoxLanguage().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (main.getComboBoxLanguage().getSelectedItem().equals("ES")) {
					locale = new Locale("es");
					localizar();
				} else {
					locale = new Locale("en");
					localizar();
				}

			}
		});

		FileUtil.loadUsersFile("src/files/clientes.dat", listUsers);

		main.getBtnLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValidUser();
			}
		});
		main.getBtnRegister().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValidRegisterUser();
			}
		});

		main.getTxtUser().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				main.getLblUserError().setVisible(false);
			}
		});
		main.getTxtPass().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				main.getLblPassError().setVisible(false);
			}
		});

		main.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
		main.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	protected void checkValidUser() {
		boolean found = false;
		for (User u : listUsers) {
			if (u.getUser().equals(main.getTxtUser().getText())) {
				found = true;
				JPasswordField pass = (JPasswordField) main.getTxtPass();
				if (!u.getPass().equals(String.valueOf(pass.getPassword()))) {
					main.getLblUserError()
							.setText(texts.getString("user_error"));
					main.getLblPassError().setVisible(true);
					pass.grabFocus();
					pass.getCursor();
				} else {
					reset();
					main.setTitle(texts.getString("game_title"));
					main.card.show(main.getContentPane(), "game");
					new GameViewController(main, u, locale);
					reset();
				}
			}
		}
		if (!found) {
			main.getLblUserError().setVisible(true);
		}

	}

	protected void checkValidRegisterUser() {
		boolean exists = false;
		if (main.getTxtUser().getText().trim().length() == 0) {
			main.getLblUserError().setText(texts.getString("user_error_empty"));
			main.getLblUserError().setVisible(true);

		} else {
			for (User u : listUsers) {
				if (u.getUser().equals(main.getTxtUser().getText())) {
					main.getLblUserError()
							.setText(texts.getString("user_error_register"));
					main.getLblUserError().setVisible(true);
					exists = true;
					break;
				}
			}
			if (!exists) {
				new UserViewController(main, locale);
				reset();
			}
		}

	}

	private void reset() {
		main.getLblPassError().setVisible(false);
		main.getLblUserError().setVisible(false);
		main.getTxtUser().setText("");
		main.getTxtPass().setText("");
	}

	private void localizar() {
		texts = ResourceBundle.getBundle("languages/texts", locale);
		main.setTitle(texts.getString("main_title"));
		main.getLblTitle().setText(texts.getString("main_title"));
		main.getLblUser().setText(texts.getString("user"));
		main.getLblUser()
				.setDisplayedMnemonic(texts.getString("user_mn").charAt(0));
		main.getLblPass().setText(texts.getString("pass"));
		main.getLblPass()
				.setDisplayedMnemonic(texts.getString("pass_mn").charAt(0));
		main.getLblUserError().setText(texts.getString("user_error"));
		main.getLblPassError().setText(texts.getString("pass_error"));
		main.getBtnLogin().setText(texts.getString("login"));
		main.getBtnLogin().setMnemonic(texts.getString("login_mn").charAt(0));
		main.getBtnRegister().setText(texts.getString("register"));
		main.getBtnRegister()
				.setMnemonic(texts.getString("register_mn").charAt(0));
		main.getLblHelp().setToolTipText(texts.getString("help_tp"));
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
		hb.enableHelpKey(main.getRootPane(), "introduccion", hs);
		// para que se muestre en el boton
		hb.enableHelp(main.getLblHelp(), "introduccion", hs);
		// para el boton de contenidos
		// hb.enableHelpOnButton(component, "introduccion", hs);

		// reconstruir ayuda cuando se cambien los html
		// $ cd path_proyecto/ayuda
		// $ java -jar path_java_help/jh2.0/javahelp/bin/jhindexer.jar .
	}

}
