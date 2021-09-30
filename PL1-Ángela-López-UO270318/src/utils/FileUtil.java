package utils;

import java.io.*;
import java.util.*;

import model.Drink;
import model.User;
/**
 * Clase FileUtil que contiene las utilidades de manejo de ficheros
 * @author angela uo270318
 *
 */
public abstract class FileUtil {

	/**
	 * Metodo que carga las bebidas de un fichero que se le pasa como
	 * parametro a una lista.
	 * 
	 * @param file
	 *                 Nombre fichero
	 * @param list
	 *                 Lista a la que se cargan los datos
	 */
	public static void loadDrinksFile(String file, List<Drink> list) {
		String linea;
		String[] datosBebida = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(file));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosBebida = linea.split("@");
				list.add(new Drink(datosBebida[0], datosBebida[1],
						datosBebida[2], Float.parseFloat(datosBebida[3]), 0));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Metodo que carga los usuarios de un fichero que se le pasa como
	 * parametro a una lista.
	 * 
	 * @param fileName
	 *                     Nombre del fichero
	 * @param listUser
	 *                     Lista a la que se cargan los datos
	 */
	public static void loadUsersFile(String fileName, List<User> listUser) {
		String line;
		String[] userData = null;

		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while (file.ready()) {
				line = file.readLine();
				userData = line.split("@");
				listUser.add(new User(userData[0], userData[1], userData[2],
						userData[3], Float.parseFloat(userData[4])));
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Metodo que inserta un nuevo usuario al fichero
	 * 
	 * @param name
	 *                 Nombre del fichero
	 * @param user
	 *                 Usuario a insertar
	 */
	public static void saveUserToFile(String name, User user) {
		try {
			BufferedWriter fichero = new BufferedWriter(
					new FileWriter("src/files/" + name + ".dat", true));
			String linea = user.toString();
			fichero.write(linea);
			fichero.write("\n");
			fichero.flush();
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	/**
	 * Metodo que actualiza el fichero de clientes
	 * 
	 * @param name
	 *                 Nombre del fichero
	 * @param list
	 *                 Lista de usuarios
	 */
	public static void rewriteFile(String name, List<User> list) {
		try {
			BufferedWriter fichero = new BufferedWriter(
					new FileWriter("src/files/" + name + ".dat"));
			for (User u : list) {
				String linea = u.toString();
				fichero.write(linea);
				fichero.write("\n");
			}
			fichero.flush();
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

}
