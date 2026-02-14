package cisc3130HW1;

import java.util.Vector;

public class Order {
	
	private String orderId;
	private String customerName;
	private String orderDate;
	private Vector<OrderItem> items;
	private String orderStatus;
	
	public Order(String orderId, String customerName, String orderDate) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.items = new Vector<>(10);
		this.orderStatus = "Pending";
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public String getOrderDate() {
		return this.orderDate;
	}
	
	public String getOrderStatus() {
		return this.orderStatus;
	}
	
	/*
	 * updateStatus uses a switch case that will restrict the user as to what parts of the process the order are listed below.
	 * if the user puts in a data field that is not specified, then it will not update the orderStatus at all. it will print
	 * into the console that the field is not a valid status.
	 */
	
	public void updateStatus(String status) {
		switch (status) {
		case "Pending":
			this.orderStatus = status;
			break;
		case "Processing":
			this.orderStatus = status;
			break;
		case "Shipped":
			this.orderStatus = status;
			break;
		case "Out for delivery":
			this.orderStatus = status;
			break;
		case "Delivered":
			this.orderStatus = status;
			break;
		case "Cancelled":
			this.orderStatus = status;
			break;
		case "Returned":
			this.orderStatus = status;
			break;
		default:
			System.out.println("Not a valid status");
			break;
		}
	}
	
	/*
	 * checks whether there is a duplicate. if not, then add an item to the items vector
	 */
	
	public void addItem(OrderItem item) {
		boolean duplicate = false;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				duplicate = true;
			}
		}
		
		if (!duplicate) {
			items.add(item);
		}
	}
	
	/*
	 * loops through the Vector until it finds its match and removes item of specified product Id. if not, then no action is made,
	 * and the method will return false
	 */
	
	public boolean removeItem(String productId) {
		boolean found = false;
		int index = 0;
		while (!found && index < items.size()) {
			if (items.get(index).getProductId().equals(productId)) {
				found = true;
				items.remove(index);
			}
			index++;
		}
		return found;
	}
	
	/*
	 * behaves the same way the findProduct loop works, it uses a for loop to to search through the whole array and returns the
	 * item of specified Id. if not, then the method returns null
	 */
	
	public OrderItem findItem(String productId) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getProductId().equals(productId)) {
				return items.get(i);
			}
		}
		return null;
	}
	
	/*
	 * looks through each element of items vector and multiplies the unit price and quantity together, which is then added to total
	 * before moving to the next element
	 */
	
	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += (items.get(i).calculateSubtotal());
		}
		return total;
	}
	
	public int getTotalItems() {
		int total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getQuantity();
		}
		return total;
	}
	
	/*
	 * use printf statement to format the order. show ID, name, date, status, and value of the order obtained from calculateTotal()
	 */
	
	public void printOrder() {
		double orderValue = calculateTotal();
		System.out.printf("Order ID: %-10s Customer Name: %-15s Order Date: %-10s Order Status: %-18s Order Value: $%.2f%n", this.orderId, this.customerName, this.orderDate, this.orderStatus, orderValue);
	}
	
	/*
	 * serves as a test method since I am too lazy to not print out the whole vector
	 */
	
	@Override
	public String toString() {
		return "Order ID: " + this.orderId + "\tCustomer Name: " + this.customerName + "\tOrder Date: " + this.orderDate + "\tOrder Status: " + this.orderStatus;
	}
	
	/*
	 * i assume that this is a getter and that the gitHub does not mean a literal copy of the items Vector.
	 */
	
	public Vector<OrderItem> getItems() {
		return this.items;
	}

}
