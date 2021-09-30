package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/**
 * Modelo de Juego
 * @author angela uo270318
 *
 */
public class Game {

	private int token5 = 0;
	private int token10 = 0;
	private int token20 = 0;
	private int token50 = 0;
	private int token100 = 0;

	private int winner;
	private boolean withoutTokens;
	private String betsWon;
	private boolean userWon = false;

	private static final List<Integer> reds = new ArrayList<Integer>(
			Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30,
					32, 35, 36));
	// columnas
	List<Integer> c1 = new ArrayList<Integer>(
			Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36));
	List<Integer> c2 = new ArrayList<Integer>(
			Arrays.asList(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35));
	List<Integer> c3 = new ArrayList<Integer>(
			Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34));
	// docenas
	List<Integer> doc1 = new ArrayList<Integer>(
			Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
	List<Integer> doc2 = new ArrayList<Integer>(
			Arrays.asList(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
	List<Integer> doc3 = new ArrayList<Integer>(
			Arrays.asList(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));
	// fallo
	List<Integer> fail = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6,
			7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
	// paso
	List<Integer> pass = new ArrayList<Integer>(Arrays.asList(19, 29, 21, 22,
			23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));

	List<Bet> bets = new ArrayList<Bet>();

	public Game() {
		initGame();
	}

	private void initGame() {
		withoutTokens = false;
	}

	public void calculatePrize() {
		for (Bet b : bets) {
			checkPrice(b);
		}
	}

	private void checkPrice(Bet b) {
		// si la casilla es 0 caso especial
		if (getWinner() == 0) {
			if (b.getSquare().equals("0")) {
				b.setWinner(true);
				// 35 ganadas + 1 apostada
				b.setTokensWon(Integer.parseInt(b.getToken()) * 36);
				updateToken(b.getToken(), 1 * 36);
			} else if (b.getSquare().equals("C1") || b.getSquare().equals("C2")
					|| b.getSquare().equals("C3")
					|| b.getSquare().equals("DOC1")
					|| b.getSquare().equals("DOC2")
					|| b.getSquare().equals("DOC3")
					|| b.getSquare().equals("FAIL")
					|| b.getSquare().equals("EVEN")
					|| b.getSquare().equals("RED")
					|| b.getSquare().equals("BLACK")
					|| b.getSquare().equals("ODD")
					|| b.getSquare().equals("PASS")) {
				b.setWinner(true);
				// se recupera la apostada
				b.setTokensWon(Integer.parseInt(b.getToken()) * 1);
				updateToken(b.getToken(), 1);
				if (!b.getToken().equals("5")) {
					int half = Integer.parseInt(b.getToken()) / 2;
					b.setTokensWon(Integer.parseInt(b.getToken()) + half);
					// se entregan las ganadas
					updateHalf(half);
				}
			}
		} else {
			if (b.getSquare().equals("C1")) {
				if (c1.contains(getWinner())) {
					b.setWinner(true);
					// 1 apostada, 2 ganadas
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("C2")) {
				if (c2.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("C3")) {
				if (c3.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("DOC1")) {
				if (doc1.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("DOC2")) {
				if (doc2.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("DOC3")) {
				if (doc3.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 3);
					updateToken(b.getToken(), 3);
				}
			} else if (b.getSquare().equals("FAIL")) {
				if (fail.contains(getWinner())) {
					b.setWinner(true);
					// 1 apostada, 1 ganada
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}
			} else if (b.getSquare().equals("EVEN")) {
				if (isEven(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}
			} else if (b.getSquare().equals("RED")) {
				if (isRed(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}
			} else if (b.getSquare().equals("BLACK")) {
				if (!isRed(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}

			} else if (b.getSquare().equals("ODD")) {
				if (!isEven(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}
			} else if (b.getSquare().equals("PASS")) {
				if (!fail.contains(getWinner())) {
					b.setWinner(true);
					b.setTokensWon(Integer.parseInt(b.getToken()) * 2);
					updateToken(b.getToken(), 2);
				}
			} else {
				if (Integer.parseInt(b.getSquare()) == getWinner()) {
					b.setWinner(true);
					// se ganan 35, la que se apuesta se mantiene en el tablero
					b.setTokensWon(Integer.parseInt(b.getToken()) * 36);
					updateToken(b.getToken(), 36);
				}
			}
		}
	}

	private void updateHalf(int half) {
		if (half == 5) {
			updateToken("5", 1);
		} else if (half == 10) {
			updateToken("10", 1);
		} else if (half == 25) {
			updateToken("20", 1);
			updateToken("5", 1);
		} else
			updateToken("50", 1);

	}

	private boolean isRed(int winner) {
		return reds.contains(getWinner());
	}

	private boolean isEven(int winner) {
		return winner % 2 == 0;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void spin() {
		setWinner(Roulette.spin());
		calculatePrize();
	}

	public int getToken5() {
		return token5;
	}

	public void setToken5(int token5) {
		this.token5 = token5;
	}

	public int getToken10() {
		return token10;
	}

	public void setToken10(int token10) {
		this.token10 = token10;
	}

	public int getToken20() {
		return token20;
	}

	public void setToken20(int token20) {
		this.token20 = token20;
	}

	public int getToken50() {
		return token50;
	}

	public void setToken50(int token50) {
		this.token50 = token50;
	}

	public int getToken100() {
		return token100;
	}

	public void setToken100(int token100) {
		this.token100 = token100;
	}

	public void setTokens(int token5, int token10, int token20, int token50,
			int token100) {
		setToken5(token5);
		setToken10(token10);
		setToken20(token20);
		setToken50(token50);
		setToken100(token100);
	}

	public void addBet(String token, String square) {
		bets.add(new Bet(token, square));
	}

	public void updateToken(String name, int i) {
		if (name.equals("5"))
			setToken5(token5 + i);
		else if (name.equals("10"))
			setToken10(token10 + i);
		else if (name.equals("20"))
			setToken20(token20 + i);
		else if (name.equals("50"))
			setToken50(token50 + i);
		else if (name.equals("100"))
			setToken100(token100 + i);
	}

	public String getPrizeMsg(Locale locale) {
		betsWon = "";
		for (Bet b : bets) {
			if (b.isWinner()) {
				userWon = true;
				betsWon += "\n" + b.getMsg(locale);

			}
		}
		if (userWon) {
			return "winner_msg";
		} else {
			return "loser_msg";
		}
	}

	public void checkWithoutTokens() {
		int tokens = token5 + token10 + token20 + token50 + token100;
		if (tokens == 0) {
			withoutTokens = true;
		}
	}

	public boolean isWithoutTokens() {
		return withoutTokens;
	}

	public String getBetsWonMsg() {
		return betsWon;
	}

	public void clearBets() {
		bets.clear();
		userWon = false;
	}

	public boolean isWinnerUser() {
		return userWon;
	}

	public int getToken(String name) {
		if (name.equals("5"))
			return getToken5();
		else if (name.equals("10"))
			return getToken10();
		else if (name.equals("20"))
			return getToken20();
		else if (name.equals("50"))
			return getToken50();
		else if (name.equals("100"))
			return getToken100();
		else
			return 0;
	}

	// para recuperar aquellas fichas que no se han jugado aun
	public void retire() {
		for (Bet b : bets) {
			updateToken(b.getToken(), 1);
		}
		clearBets();
	}
}
