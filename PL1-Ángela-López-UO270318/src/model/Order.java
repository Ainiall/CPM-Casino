package model;

import java.util.*;
/**
 * Modelo de Order
 * @author angela uo270318
 *
 */
public class Order {

	private List<Drink> listaPedido = null;

	private Locale locale;

	public Order(Locale locale) {
		this.locale=locale;
		listaPedido = new ArrayList<Drink>();
	}

	public void add(Drink articuloDelCatalogo, int unidades) {
		Drink articuloEnPedido = null;

		for (Drink d : listaPedido) {
			if (d.getCode().equals(articuloDelCatalogo.getCode()))
				articuloEnPedido = d;
		}

		if (articuloEnPedido == null) {
			Drink articuloAPedido = new Drink(articuloDelCatalogo);
			articuloAPedido.setUnits(unidades);
			listaPedido.add(articuloAPedido);
		} else {
			int totalUnidades = articuloEnPedido.getUnits() + unidades;
			articuloEnPedido.setUnits(totalUnidades);
		}
	}

	public void delete(Drink articuloDelCatalogo, int unidades) {
		for (Drink d : listaPedido) {
			if (d.getCode().equals(articuloDelCatalogo.getCode())) {
				if (d.getUnits() - unidades > 0) {
					d.setUnits(d.getUnits() - unidades);
				} else {
					listaPedido.remove(d);
					return;
				}
			} else {
			
			}
		}

	}

	public float calculatePrice() {
		float total = 0.0f;
		for (Drink d : listaPedido) {
			total += d.getPrice() * d.getUnits();
		}
		return total;
	}

	public void inicializar() {
		listaPedido.clear();
	}

	public String showOrder() {
		String pedido = "";
		for (Drink d : listaPedido) {
			pedido = pedido + d.toString(locale) + "\n";
		}
		return pedido;
	}

}
