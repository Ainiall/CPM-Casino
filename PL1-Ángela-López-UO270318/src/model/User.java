package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Modelo de usuario
 * @author angela uo270318
 *
 */
public class User {

	private String dni;
	private String name;
	private String user;
	private String pass;
	private float balance;
	private List<Integer> tokens = new ArrayList<Integer>(
			Arrays.asList(0, 0, 0, 0, 0));

	// DNI@Nombre completo@Usuario@Clave@Saldo
	public User(String dni, String name, String user, String pass,
			float balance) {
		this.dni = dni;
		this.name = name;
		this.user = user;
		this.pass = pass;
		this.balance = balance;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return dni + "@" + name + "@" + user + "@" + pass + "@" + balance;
	}

	public void setTokens(int token5, int token10, int token20, int token50,
			int token100) {
		tokens = Arrays.asList(token5, token10, token20, token50, token100);

	}

	public int getToken(int pos) {
		return tokens.get(pos);
	}

	public int getTokenCount() {
		int cont = 0;
		for (Integer i : tokens) {
			cont += i;
		}
		return cont;
	}

	public void updateBalance(int token5, int token10, int token20,
			int token50, int token100) {
		float add= token5 * 5 + token10 * 10 + token20 * 20 + token50 * 50
				+ token100 * 100;
		setBalance(this.getBalance()+add);

	}

}
