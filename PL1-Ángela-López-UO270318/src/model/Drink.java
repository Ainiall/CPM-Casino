package model;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Modelo de bebida
 * @author angela uo270318
 *
 */
public class Drink {

	private String code;
	private String name;
	private String type;
	private float price;
	private int units;
	private String photo;
	private ResourceBundle texts;

	public Drink(String code, String name, String type, float price,
			int units) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.units = units;
		photo = "/img/bebidas/"+ this.code + ".png";
	}

	public Drink(Drink otherDrink) {
		this(otherDrink.getCode(), otherDrink.getName(), otherDrink.getType(),
				otherDrink.getPrice(), otherDrink.getUnits());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	public String getPhoto() {
		return photo;
	}

	public String toString(Locale locale) {
		texts = ResourceBundle.getBundle("languages/texts", locale);
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name);
		buffer.append(" - ");
		if(locale.equals(new Locale("en"))){
			buffer.append(texts.getString("badge"));
			buffer.append(this.price);
		}else {
			buffer.append(this.price);
			buffer.append(texts.getString("badge"));
		}
		if (this.units!=0){
			buffer.append(" (");
			buffer.append(this.units);
			buffer.append(" uds)");
			}
		return buffer.toString();
	   }

}
