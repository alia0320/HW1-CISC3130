package cisc3130HW1;

public class OrderItem {
	
	private String productId;
	private String productName;
	private int quantity;
	private double unitPrice;
	private double subtotal;
	
	public OrderItem(String prodId, String prodName, int quantity, double price) {
		this.productId = prodId;
		this.productName = prodName;
		this.quantity = quantity;
		this.unitPrice = price;
		this.subtotal = quantity * price;
	}
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String prodname) {
		this.productName = prodname;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double calculateSubtotal() {
		this.subtotal = this.unitPrice * this.quantity;
		return this.subtotal;
	}
	
	/*
	 * omits subtotal as it is subject to updates every now and then. by this I mean that if a user uses setQuantity or setUnitPrice,
	 * it changes the subtotal, and the subtotal will have to be calculated again
	 */
	
	@Override
	public String toString() {
		return "Product ID: " + this.productId + "\tProduct Name: " + this.productName + "\tQuantity: " + this.quantity + "\tUnit Price: " + this.unitPrice;
	}

}
