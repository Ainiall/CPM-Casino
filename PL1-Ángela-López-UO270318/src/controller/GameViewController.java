package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import model.Game;
import model.User;
import ui.Main;
import utils.FileUtil;
import utils.ImageFactory;

/**
 * 
 * @author angela uo270318
 *
 */
public class GameViewController {

	private final static String FILE_NAME = "src/files/clientes.dat";

	private Main main;
	private List<User> listUsers = new ArrayList<User>();
	private Locale locale;
	private ResourceBundle texts;

	private User user;
	private Game game = null;

	private ProcessBtn proc;
	private ProcessDrag procDrag;
	private ProcessRoulette procR;
	private Component component;
	private boolean clickable = true;
	private HelpBroker hb;

	public GameViewController(Main main, User user, Locale locale) {
		proc = new ProcessBtn();
		procDrag = new ProcessDrag();
		procR = new ProcessRoulette();
		texts = ResourceBundle.getBundle("languages/texts", locale);
		this.locale = locale;
		this.user = user;
		this.main = main;
		localizar();
		help();
		initGameView();
	}

	@SuppressWarnings("serial")
	private void initGameView() {
		FileUtil.loadUsersFile(FILE_NAME, listUsers);
		initialStateView();
		updateTokens();
		checkEnablePlayButton();
		// al iniciar no tienen fichas, deben ir a comprar
		main.getBtnBank().requestFocusInWindow();

		main.getLblRoulette().addMouseListener(procR);

		addDragListener();
		addBoardListener();

		main.getBtnPlay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableTokens();
				main.getTextAreaMessages()
						.append("\n\n" + texts.getString("start_msg"));
				game = new Game();
				setGameTokens();
				main.getBtnRetire().setEnabled(true);
				main.getBtnCardBalance().setEnabled(false);
				main.getBtnPlay().setEnabled(false);
				enableBoard(true);
			}
		});

		main.getBtnRetire().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getTextAreaMessages()
						.append("\n\n" + texts.getString("retired_msg"));
				game.retire();
				updateTokenCount();
				updateBalance();
				clearBoard();
				disableComponents();
			}
		});

		main.getBtnShop().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopViewController(main, user, locale);
			}
		});

		main.getBtnBank().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BankViewController(main, user, locale, false);
				updateTokens();
				if (game != null) {
					enableTokens();
					setGameTokens();
				}
				checkEnablePlayButton();
			}
		});

		main.getBtnCardBalance().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setBalance(0);
				disableComponents();
				JOptionPane.showMessageDialog(main,
						texts.getString("return_card"), "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// Para manejar la X
		main.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				showDialogClose();
			}
		});

		main.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
		main.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				showDialogClose();
			}
		});

		main.getLblHelpGame().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (hb.isDisplayed())
					hb.setDisplayed(false);
				else
					hb.setDisplayed(true);

			}
		});
	}

	// se añaden a la partida las fichas del usuario
	protected void setGameTokens() {
		game.setTokens(Integer.parseInt(main.getTxtToken5().getText()),
				Integer.parseInt(main.getTxtToken10().getText()),
				Integer.parseInt(main.getTxtToken20().getText()),
				Integer.parseInt(main.getTxtToken50().getText()),
				Integer.parseInt(main.getTxtToken100().getText()));

	}

	// el juego ya ha empezado, las fichas forman parte del juego
	protected void updateTokenCount() {
		main.getTxtToken5().setText(String.valueOf(game.getToken5()));
		main.getTxtToken10().setText(String.valueOf(game.getToken10()));
		main.getTxtToken20().setText(String.valueOf(game.getToken20()));
		main.getTxtToken50().setText(String.valueOf(game.getToken50()));
		main.getTxtToken100().setText(String.valueOf(game.getToken100()));

	}

	protected void clearBoard() {
		for (int i = 0; i < main.getPanelBoard().getComponents().length; i++) {
			JButton b = (JButton) main.getPanelBoard().getComponents()[i];
			b.setIcon(null);
			if (b.getBackground().equals(Color.lightGray)) {
				b.setForeground(Color.black);
			} else {
				b.setForeground(Color.white);
			}
			b.setText(b.getName()); // para internacionalizar tablero
		}

	}

	// el juego aun no ha empezado, las fichas las tiene el usuario
	// se actualiza cada vez que compre en la tienda
	protected void updateTokens() {
		int t5 = Integer.parseInt(main.getTxtToken5().getText());
		int t10 = Integer.parseInt(main.getTxtToken10().getText());
		int t20 = Integer.parseInt(main.getTxtToken20().getText());
		int t50 = Integer.parseInt(main.getTxtToken50().getText());
		int t100 = Integer.parseInt(main.getTxtToken100().getText());
		main.getTxtToken5().setText(String.valueOf(t5 + user.getToken(0)));
		main.getTxtToken10().setText(String.valueOf(t10 + user.getToken(1)));
		main.getTxtToken20().setText(String.valueOf(t20 + user.getToken(2)));
		main.getTxtToken50().setText(String.valueOf(t50 + user.getToken(3)));
		main.getTxtToken100().setText(String.valueOf(t100 + user.getToken(4)));
	}

	private void addBoardListener() {
		for (int i = 0; i < main.getPanelBoard().getComponents().length; i++) {
			(main.getPanelBoard().getComponents()[i])
					.addPropertyChangeListener(proc);
		}
	}

	private void addDragListener() {
		main.getLblToken5().addMouseListener(procDrag);
		main.getLblToken10().addMouseListener(procDrag);
		main.getLblToken20().addMouseListener(procDrag);
		main.getLblToken50().addMouseListener(procDrag);
		main.getLblToken100().addMouseListener(procDrag);
	}

	protected void enableBoard(boolean state) {
		for (int i = 0; i < main.getPanelBoard().getComponents().length; i++) {
			(main.getPanelBoard().getComponents()[i]).setEnabled(state);
		}

	}

	// se actualiza el saldo del usuario
	protected void updateBalance() {
		user.updateBalance(Integer.parseInt(main.getTxtToken5().getText()),
				Integer.parseInt(main.getTxtToken10().getText()),
				Integer.parseInt(main.getTxtToken20().getText()),
				Integer.parseInt(main.getTxtToken50().getText()),
				Integer.parseInt(main.getTxtToken100().getText()));
		updateFile();
	}

	// se actualiza la referencia al usuario del fichero
	private void updateFile() {
		for (User u : listUsers) {
			if (u.getUser().equals(user.getUser())) {
				u.setBalance(user.getBalance());
			}
		}
	}

	protected void initialStateView() {
		disableComponents();
		main.getTextAreaMessages().setText(texts.getString("tutorial"));
	}

	private void disableComponents() {
		main.getBtnPlay().setEnabled(false);
		main.getBtnRetire().setEnabled(false);
		main.getBtnCardBalance().setEnabled(true);
		main.getLblRoulette().setEnabled(false);
		main.getLblToken5().setEnabled(false);
		main.getTxtToken5().setText("0");
		main.getLblToken10().setEnabled(false);
		main.getTxtToken10().setText("0");
		main.getLblToken20().setEnabled(false);
		main.getTxtToken20().setText("0");
		main.getLblToken50().setEnabled(false);
		main.getTxtToken50().setText("0");
		main.getLblToken100().setEnabled(false);
		main.getTxtToken100().setText("0");
		enableBoard(false);
	}

	// drag and drop solo con aquellas fichas disponibles
	protected void enableTokens() {
		// se podria hacer con un bucle pero al tener tantas capas de paneles
		// tiene demasiada complejidad ???
		if (!main.getTxtToken5().getText().equals("0"))
			main.getLblToken5().setEnabled(true);
		else
			main.getLblToken5().setEnabled(false);

		if (!main.getTxtToken10().getText().equals("0"))
			main.getLblToken10().setEnabled(true);
		else
			main.getLblToken10().setEnabled(false);

		if (!main.getTxtToken20().getText().equals("0"))
			main.getLblToken20().setEnabled(true);
		else
			main.getLblToken20().setEnabled(false);

		if (!main.getTxtToken50().getText().equals("0"))
			main.getLblToken50().setEnabled(true);
		else
			main.getLblToken50().setEnabled(false);

		if (!main.getTxtToken100().getText().equals("0"))
			main.getLblToken100().setEnabled(true);
		else
			main.getLblToken100().setEnabled(false);
	}

	private void checkEnablePlayButton() {
		if (user.getTokenCount() > 0) {
			if (game == null)
				main.getBtnPlay().setEnabled(true);
			else if (game.isWithoutTokens()) {
				main.getBtnPlay().setEnabled(true);
			}
		}
	}

	@SuppressWarnings("static-access")
	protected void showDialogClose() {
		if (JOptionPane.showConfirmDialog(main, texts.getString("close_qm"),
				texts.getString("close"), JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			finish();
			System.exit(0);
		} else {
			main.setDefaultCloseOperation(main.DO_NOTHING_ON_CLOSE);
		}

	}

	protected void finish() {
		if (game != null) {
			game.retire();
			updateTokenCount();
		}
		updateBalance();
		FileUtil.rewriteFile("clientes", listUsers);
		// deberia ir al login de nuevo?
		//initialStateView();
		//main.card.show(main.getContentPane(), "login");
	}

	private void localizar() {
		main.setTitle(texts.getString("game_title"));
		main.getLblMsg().setText(texts.getString("msg"));
		main.getTextAreaMessages().setText(texts.getString("tutorial"));
		main.getBtnPlay().setText(texts.getString("play"));
		main.getBtnPlay().setMnemonic(texts.getString("play_mn").charAt(0));
		main.getBtnRetire().setText(texts.getString("retire"));
		main.getBtnRetire().setMnemonic(texts.getString("retire_mn").charAt(0));
		main.getBtnShop().setText(texts.getString("shop"));
		main.getBtnShop().setMnemonic(texts.getString("shop_mn").charAt(0));
		main.getBtnBank().setText(texts.getString("bank"));
		main.getBtnBank().setMnemonic(texts.getString("bank_mn").charAt(0));
		main.getBtnCardBalance().setText(texts.getString("card_balance"));
		main.getBtnCardBalance()
				.setMnemonic(texts.getString("card_balance_mn").charAt(0));
		main.getLblHelpGame().setToolTipText(texts.getString("help_tp"));
		main.getLblRoulette().setToolTipText(texts.getString("roulette_tp"));
		localeBoard();

	}

	private void localeBoard() {
		for (int i = 0; i < main.getPanelBoard().getComponents().length; i++) {
			JButton j = (JButton) (main.getPanelBoard().getComponents()[i]);
			if (j.getActionCommand().equals("DOC1")) {
				j.setName(texts.getString("doc1"));
				j.setText(texts.getString("doc1"));
			} else if (j.getActionCommand().equals("DOC2")) {
				j.setName(texts.getString("doc2"));
				j.setText(texts.getString("doc2"));
			} else if (j.getActionCommand().equals("DOC3")) {
				j.setName(texts.getString("doc3"));
				j.setText(texts.getString("doc3"));
			} else if (j.getActionCommand().equals("ODD")) {
				j.setName(texts.getString("odd"));
				j.setText(texts.getString("odd"));
			} else if (j.getActionCommand().equals("EVEN")) {
				j.setName(texts.getString("even"));
				j.setText(texts.getString("even"));
			} else if (j.getActionCommand().equals("RED")) {
				j.setName(texts.getString("red"));
				j.setText(texts.getString("red"));
			} else if (j.getActionCommand().equals("BLACK")) {
				j.setName(texts.getString("black"));
				j.setText(texts.getString("black"));
			} else if (j.getActionCommand().equals("FAIL")) {
				j.setName(texts.getString("fail"));
				j.setText(texts.getString("fail"));
			} else if (j.getActionCommand().equals("PASS")) {
				j.setName(texts.getString("paso"));
				j.setText(texts.getString("paso"));
			}
		}
	}

	// drag and drop
	class ProcessDrag extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			JComponent c = (JComponent) e.getSource();
			if (c.isEnabled()) {
				TransferHandler h = c.getTransferHandler();
				h.exportAsDrag(c, e, TransferHandler.COPY);
				component = c;

			}
		}
	}

	// clase evento tablero
	class ProcessBtn implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			if (e.getPropertyName().equals("foreground")
					&& (e.getNewValue().equals(Color.blue))) {
				JButton btn = (JButton) e.getSource();
				doAction(btn);
			}
		}
	}

	// clase evento ruleta
	class ProcessRoulette extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JComponent c = (JComponent) e.getSource();
			if (c.isEnabled()) {
				if (clickable) {
					clickable = false;
					main.getLblRoulette().setIcon(new ImageIcon(
							Main.class.getResource("/img/ruleta.gif")));
					// dormir 4s y cambiar de nuevo la imagen para simular giro
					Timer timer = new Timer(3000, en -> {
						main.getLblRoulette().setIcon(new ImageIcon(Main.class
								.getResource("/img/ruleta_static.png")));
						game.spin();
						updateTokenCount(); // actualiza txt
						showBetsMsg();
						// se limpia todo el tablero (devolver)
						game.clearBets();
						clearBoard();
						enableTokens();
						// la ruleta vuelve a estar desactivada hasta que se
						// hagan apuestas
						main.getLblRoulette().setEnabled(false);
						game.checkWithoutTokens();
						if (game.isWithoutTokens()) {
							disableComponents();
							main.getTextAreaMessages().append("\n"
									+ texts.getString("without_tokens_msg"));
						}

					});
					timer.setRepeats(false);
					timer.start();
				}
			}
		}
	}

	public void doAction(JButton btn) {
		// cambiar foto y actualizar fichas
		JTextField j = (JTextField) component.getParent().getComponent(1);
		changeBackground(btn, j.getName());
		// anotar apuesta en mensajes
		game.addBet(j.getName(), btn.getActionCommand());
		main.getTextAreaMessages()
				.append("\n---" + texts.getString("bet_of") + j.getName() + " "
						+ texts.getString("to_square") + " " + btn.getName());
		// ruleta funcional
		main.getLblRoulette().setEnabled(true);
		clickable = true;
		// actualizacion de fichas
		game.updateToken(j.getName(), -1);
		j.setText(String.valueOf(game.getToken(j.getName())));
		if (j.getText().equals("0")) {
			component.setEnabled(false);
		}
	}

	public void showBetsMsg() {
		main.getTextAreaMessages().append("\n\n"
				+ texts.getString("winner_number") + " " + game.getWinner());
		// tipo de mensaje distinto segun premio
		main.getTextAreaMessages()
				.append("\n" + texts.getString(game.getPrizeMsg(locale)));
		if (game.isWinnerUser()) {
			main.getTextAreaMessages().append("\n" + game.getBetsWonMsg());
		}
	}

	private void changeBackground(JButton btn, String name) {
		btn.setToolTipText(btn.getText());
		btn.setText("");
		Image imgOriginal = ImageFactory.getImagen(name).getImage();
		Image imgScaled = imgOriginal.getScaledInstance(btn.getWidth() / 2,
				btn.getHeight() / 2, Image.SCALE_FAST);
		ImageIcon icon = new ImageIcon(imgScaled);
		btn.setIcon(icon);
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
		hb.enableHelpKey(main.getRootPane(), "ruleta", hs);
		hb.enableHelp(main.getLblHelpGame(), "ruleta", hs);
	}

}
