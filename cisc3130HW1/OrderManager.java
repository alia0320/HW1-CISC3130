package cisc3130HW1;

import java.util.Vector;

public class OrderManager {
	
	private Vector<Order> orders;
	
	public OrderManager() {
		this.orders = new Vector<>(10,5);
	}
	
	/*
	 * same functionality as that of the ProductInventory addProduct() function. check for duplicate Ids, do nothing when a duplicate
	 * is found, else add the order
	 */
	
	public void addOrder(Order order) {
		boolean duplicate = false;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).equals(order)) {
				duplicate = true;
			}
		}
		
		if (!duplicate) {
			orders.add(order);
		}
	}
	
	/*
	 * same functionality as findProduct() method in productInventory. return null if nothing is found, return the Order of the 
	 * specified Id. 
	 */
	
	public Order findOrder(String orderId) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderId().equals(orderId)) {
				return orders.get(i);
			}
		}
		return null;
	}
	
	/*
	 * goes through the whole vector to find orders of specified status and adds that element to the ordersbystatus vector, which is
	 * what the method returns
	 * 
	 * if there is nothing, it returns an empty vector
	 */
	
	public Vector<Order> getOrdersByStatus(String status) {
		Vector<Order> ordersbystatus = new Vector<>(5);
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderStatus().equals(status)) {
				ordersbystatus.add(orders.get(i));
			}
		}
		return ordersbystatus;
	}
	
	/*
	 * same functionality as getOrdersByStatus(), this time the name of the temp vector to be returned is ordersbycustomer
	 * and only adds elements to temp vector if the Order has the specified customerName
	 * 
	 * if there is nothing, it returns an empty vector
	 */
	
	public Vector<Order> getOrdersByCustomer(String customerName) {
		Vector<Order> ordersbycustomer = new Vector<>(5);
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getCustomerName().equals(customerName)) {
				ordersbycustomer.add(orders.get(i));
			}
		}
		return ordersbycustomer;
	}
	
	/*
	 * go through all elements in orders, use the calculateTotal() method that goes through all items in order and multiplies the
	 * quantity of the item and unitPrice of the item together and then return the total amount of that order, then move to next Order
	 * and do the same
	 */
	
	public double getTotalRevenue() {
		double total = 0;
		for (int i = 0; i < orders.size(); i++) {
			total += orders.get(i).calculateTotal();
		}
		return total;
	}
	
	/*
	 * checks whether there is an existing order with specified orderId. if not, do nothing and print the following statement,
	 * if there is, then update the status of that order to be cancelled
	 */
	
	public void cancelOrder(String orderId) {
		if (findOrder(orderId) != null) {
			findOrder(orderId).updateStatus("Cancelled");
		} else {
			System.out.println("No changes made to OrderManager as order could not be found.");
		}
	}
	
	public void printAllOrders() {
		System.out.println("------------Showing All Orders--------------");
		for (int i = 0; i < orders.size(); i++) {
			System.out.print("Order #" + (i+1)+": "); orders.get(i).printOrder();
		}
		System.out.println("---------------------------------------------");
	}
	
	/*
	 * make a temporary vector that adds orders into the vector if they are of the status "Pending" 
	 */
	
	public Vector<Order> getPendingOrders() {
		Vector<Order> pendingOrders = new Vector<>(5);
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderStatus().equals("Pending")) {
				pendingOrders.add(orders.get(i));
			}
		}
		return pendingOrders;
	}
	
	public int getOrderCount() {
		return orders.size();
	}
}
