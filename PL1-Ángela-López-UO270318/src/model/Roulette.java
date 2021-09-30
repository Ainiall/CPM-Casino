package model;
/**
 * Modelo de ruleta
 * @author angela uo270318
 *
 */
public class Roulette {
	
	public static int spin() {
		return ((int) (Math.random() * 36) + 1);
	}
}
