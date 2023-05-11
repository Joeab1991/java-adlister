package models;

public class Order {
	private String crust;
	private String size;
	private String cheese;
	private String[] sauce;
	private String[] toppings;
	private String street;
	private String city;
	private String state;
	private String zip;

	public Order() {
	}

	public Order(String crust, String size, String cheese, String[] sauce, String[] toppings, String street, String city,
				 String state, String zip) {
		this.crust = crust;
		this.size = size;
		this.cheese = cheese;
		this.sauce = sauce;
		this.toppings = toppings;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCheese() {
		return cheese;
	}

	public void setCheese(String cheese) {
		this.cheese = cheese;
	}

	public String[] getSauce() {
		return sauce;
	}

	public void setSauce(String[] sauce) {
		this.sauce = sauce;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
