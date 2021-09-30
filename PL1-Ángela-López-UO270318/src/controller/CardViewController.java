package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import model.User;
import ui.BankView;
import ui.CardView;
/**
 * 
 * @author angela uo270318
 *
 */
public class CardViewController {
	private CardView view = new CardView();
	private BankView bankView;
	private User user;
	private ResourceBundle texts;

	public CardViewController(BankView bv, User user, Locale locale) {
		this.user = user;
		this.bankView = bv;
		texts = ResourceBundle.getBundle("languages/texts", locale);
		localizar();
		initView();
	}

	private void initView() {
		view.setLocationRelativeTo(bankView);

		view.getBtnAccept().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notEmptyFields()) {
					// el actual, puede haber en fichas
					float balance = Float
							.parseFloat(bankView.getTxtBalance().getText());
					if (view.getTxtMoney().getText().matches("[0-9]+")) {
						float add = Float
								.parseFloat(view.getTxtMoney().getText());
						bankView.getTxtBalance()
								.setText(String.valueOf(balance + add));
						float tokens;
						if (bankView.getTxtTokens().getText().isEmpty())
							tokens = 0;
						else
							tokens = Float.parseFloat(
									bankView.getTxtTokens().getText());
						user.setBalance(balance + tokens + add);
						view.dispose();
					} else {
						JOptionPane.showMessageDialog(bankView,
								texts.getString("only_numbers"), "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(bankView,
							texts.getString("empty_fields"), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		view.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		view.setVisible(true);
	}

	protected boolean notEmptyFields() {
		if (view.getTxtCardNumber().getText().trim().length() > 0
				&& view.getTxtCardCCVI().getText().trim().length() > 0) {
			return true;
		} else
			return false;

	}

	private void localizar() {
		view.setTitle(texts.getString("card_title"));
		view.getLblTipoDeTarjeta().setText(texts.getString("card_type"));
		view.getLblTipoDeTarjeta().setDisplayedMnemonic(
				texts.getString("card_type_mn").charAt(0));
		view.getLblNmeroDeTarjeta().setText(texts.getString("card_number"));
		view.getLblNmeroDeTarjeta().setDisplayedMnemonic(
				texts.getString("card_number_mn").charAt(0));
		view.getLblCcvi()
				.setDisplayedMnemonic(texts.getString("ccvi_mn").charAt(0));
		view.getLblFechaDeCaducidad().setText(texts.getString("date"));
		view.getLblFechaDeCaducidad()
				.setDisplayedMnemonic(texts.getString("date_mn").charAt(0));
		view.getLblMoney().setText(texts.getString("transfer"));
		view.getLblFechaDeCaducidad()
				.setDisplayedMnemonic(texts.getString("transfer_mn").charAt(0));

		view.getBtnAccept().setText(texts.getString("accept"));
		view.getBtnAccept().setMnemonic(texts.getString("accept_mn").charAt(0));
		view.getBtnCancel().setText(texts.getString("cancel"));
		view.getBtnCancel().setMnemonic(texts.getString("cancel_mn").charAt(0));
	}	

}
