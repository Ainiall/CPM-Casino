package model;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Modelo de apuesta
 * @author angela uo270318
 *
 */
public class Bet {

	private String token;
	private String square;
	private boolean winner; //si la apuesta dio premio
	private int prize;		//cuantia del premio
	private ResourceBundle texts;

	public Bet(String token, String square) {
		this.token = token;
		this.square = square;
		this.prize = 0;
		winner = false;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public String getMsg(Locale locale) {
		texts = ResourceBundle.getBundle("languages/texts", locale);
		if (locale.equals(new Locale("en"))) {
			return "---" + getSquare() + ": " + texts.getString("badge")
			+ prize;
		}else {
			return "---" + getSquare() + ": " + prize
					+ texts.getString("badge");
		}
	}

	public void setTokensWon(int prize) {
		this.prize = prize;

	}

}
