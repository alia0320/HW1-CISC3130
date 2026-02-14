package cisc3130HW1;

import java.util.Vector;

public class TempTest {

	public static void main(String[] args) {
		/*
		 * ProductInventory inventory = new ProductInventory();
		 * 
		 * inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10,
		 * "TechCorp")); inventory.addProduct(new Product("P002", "T-Shirt", "Clothing",
		 * 19.99, 50, "FashionInc")); inventory.addProduct(new Product("P003", "Mouse",
		 * "Electronics", 29.99, 5, "TechCorp"));
		 * 
		 * inventory.printAllProducts(); inventory.printCapacityInfo();
		 * 
		 * Vector<Product> electronics = inventory.getProductsByCategory("Electronics");
		 * System.out.println("Electronics: " + electronics.size());
		 * 
		 * Vector<Product> lowStock = inventory.getLowStockProducts(10);
		 * System.out.println("Low stock items: " + lowStock.size());
		 * 
		 * System.out.println("Total inventory value: $" +
		 * inventory.getTotalInventoryValue());
		 */
		
		OrderManager orderManager = new OrderManager();

		Order order1 = new Order("O001", "Alice", "2024-01-15");
		order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
		order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
		orderManager.addOrder(order1);

		Order order2 = new Order("O002", "Alice", "2024-01-16");
		order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
		orderManager.addOrder(order2);

		orderManager.findOrder("O002").updateStatus("Out for delivery");
		
		
		orderManager.printAllOrders();
		System.out.println("Total revenue: $" + orderManager.getTotalRevenue());
		
		System.out.print(orderManager.getOrdersByCustomer("Alice"));
	}

}
