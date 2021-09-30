package utils;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import controller.ShopViewController;

/**
 * Clase StateBackground que maneja el estado de los toggle button
 * @author angela uo270318
 *
 */
public class StateBackground implements ItemListener {

	private ShopViewController svc;

	public StateBackground(ShopViewController svc) {
		this.svc = svc;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JToggleButton b = (JToggleButton) e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			b.setSelected(true);
			b.setBackground(new Color(51, 153, 102));
			svc.initDrinkMenu(1);
		} else {
			b.setSelected(false);
			b.setBackground(Color.WHITE);
			svc.initDrinkMenu(0);
		}
	}
}