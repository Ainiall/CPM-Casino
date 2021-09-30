package utils;

import javax.swing.ImageIcon;

/**
 * Clase ImageFactory que contiene las utilidades de manejo de imagenes
 * @author angela uo270318
 *
 */
public class ImageFactory {

	/**
	 * Metodo que asigna al tablero la ficha apostada
	 * 
	 * @param name
	 *                 Nombre de la ficha
	 * @return ImageIcon de la ficha seleccionada
	 */
	public static ImageIcon getImagen(String name) {
		return new ImageIcon(ImageFactory.class
				.getResource("/img/fichas/ficha_" + name + ".png"));
	}

}
