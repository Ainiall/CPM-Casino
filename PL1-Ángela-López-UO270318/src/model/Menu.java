package model;

import java.util.*;

import utils.FileUtil;
/**
 * Modelo de Menu
 * @author angela uo270318
 *
 */
public class Menu {

	private static final String FICHERO_BEBIDAS = "src/files/bebidas.dat";
	private static final String DRINKS_FILE = "src/files/drinks.dat";
	private List<Drink> list = null;
	private List<Drink> listAlcohol = null;
	private List<Drink> listNotAlcohol = null;

	public Menu(Locale locale) {
		list = new ArrayList<Drink>();
		loadAllDrinks(locale);
		listAlcohol = new ArrayList<Drink>();
		loadAlcoholDrinks();
		listNotAlcohol = new ArrayList<Drink>();
		loadNotAlcoholDrinks();

	}

	private void loadAllDrinks(Locale locale) {
		if (locale.equals(new Locale("es"))) {
			FileUtil.loadDrinksFile(FICHERO_BEBIDAS, list);
		} else {
			FileUtil.loadDrinksFile(DRINKS_FILE, list);
			orderList(list);
		}

	}

	private void orderList(List<Drink> list) {
		if (list.size() > 0) {
			  Collections.sort(list, new Comparator<Drink>() {
			      @Override
			      public int compare(final Drink object1, final Drink object2) {
			          return object1.getName().compareTo(object2.getName());
			      }
			  });
			}
	}

	private void loadNotAlcoholDrinks() {
		for (Drink d : list) {
			if (d.getType().equals("1")) {
				listNotAlcohol.add(d);
			}
		}
	}

	private void loadAlcoholDrinks() {
		for (Drink d : list) {
			if (d.getType().equals("0")) {
				listAlcohol.add(d);
			}
		}

	}

	public List<Drink> getListDrinks() {
		return list;
	}

	public List<Drink> getAlcoholList() {
		return listAlcohol;
	}

	public List<Drink> getNotAlcoholList() {
		return listNotAlcohol;
	}

}
