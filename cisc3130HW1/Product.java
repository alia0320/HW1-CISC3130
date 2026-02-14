package cisc3130HW1;

public class Product implements Comparable<Product> {
	
	private String productId;
	private String name;
	private String category;
	private double price;
	private int quantity;
	private String supplier;
	
	public Product(String prodid, String name, String category, double price, int quantity, String supplier) {
		this.productId = prodid;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
	}
	
	/*
	 * dedicate this section of code to setters and getters of data fields
	 */
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setProductId(String id) {
		this.productId = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getSupplier() {
		return this.supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	/*
	 * end dedication for getters and setters here, move onto actual product methods
	 */
	@Override
	public String toString() {
		return "Product ID: " + this.productId + "\tProduct Name: " + this.name + "\tProduct Category: " + this.category +
				"\tPrice: " + this.price + "\tQuantity: " + this.quantity + "\tSupplier: " + this.supplier;
	}
	
	/*
	 * override the equals() method in Object: make the new condition return true if the productId of both Strings are the same as
	 * each other
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (this.getProductId().equals(other.getProductId())) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * compareTo returns a positive number if the caller's price is greater than the parameter's price
	 */
	
	public int compareTo(Product other) {
		if (this.price > other.getPrice()) {
			return 1;
		} else if (this.price == other.getPrice()) {
			return 0;
		} else {
			return -1;
		}
	}
	
	/*
	 * 
	 */
	
	@Override
	public int hashCode() {
		return super.hashCode() * 31* ((int) price);
	}
}
