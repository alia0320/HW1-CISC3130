package cisc3130HW1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Vector;

public class InventorySystemMain {

	public static void main(String[] args) {
		
		/*
		 * what main is doing is revolving its functionality around the menu that the user can traverse through. if a user wishes
		 * to perform a certain action corresponding to the number, they can type the number. the boolean exitcondition checks whether
		 * the user has triggered the default case where the number is not one that is mentioned (besides 9 but it does the same thing)
		 * and causes the program to exit the while loop and terminate the program.
		 * 
		 * note that besides the main method, every other method has in.nextLine() as its starting line. the reason for this is
		 * to prevent the scanner from picking up previous tokens and putting that into the scanner for the nextLine() command.
		 */
		Scanner in = new Scanner(System.in);
		ProductInventory productInventory = new ProductInventory();
		OrderManager orderManager = new OrderManager();
		boolean exitcondition = false;
		while (!exitcondition) {
			System.out.println("1. Add Product\n"
					+ "2. Remove Product\n"
					+ "3. Find Product\n"
					+ "4. List All Products\n"
					+ "5. Create Order\n"
					+ "6. View Orders\n"
					+ "7. Process Order\n"
					+ "8. Generate Reports\n"
					+ "9. Exit");
			int choice = processInt(in);
			switch(choice) {
			case 1:
				addProduct(in, productInventory);
				break;
			case 2:
				removeProduct(in, productInventory);
				break;
			case 3:
				findProduct(in, productInventory);
				break;
			case 4:
				listProducts(productInventory);
				in.nextLine();
				break;
			case 5:
				createOrder(orderManager, in);
				break;
			case 6: 
				viewOrders(orderManager);
				in.nextLine();
				break;
			case 7:
				processOrder(orderManager, in);
				break;
			case 8:
				generateReports(productInventory, orderManager, in);
				break;
			default: 
				exitcondition = true;
				break;
			}
		}
	}
	
	/*
	 * User input is required to satisfy all fields of the Product object. all edge cases have been handled, and the program
	 * can run without exceptions.
	 */
	
	public static void addProduct(Scanner in, ProductInventory prodInv) {
		System.out.print("Enter Product ID: ");
		String productId = in.next();
		
		in.nextLine();
		System.out.print("Enter Product Name: ");
		String productName = in.nextLine();
		
		System.out.print("Enter Product Category: ");
		String productCategory = in.nextLine();
		
		System.out.print("Enter price of product: ");
		double price = processDouble(in);
		while (price < 0) {
			System.out.print("Price cannot be negative! Enter a number > 0! ");
			price = processDouble(in);
		}
		
		System.out.print("Enter quantity of product: ");
		int quantity = processInt(in);
		while (quantity < 0) {
			System.out.print("Quantity cannot be negative! Enter a number >= 0! ");
			quantity = processInt(in);
		}
		
		in.nextLine();
		System.out.print("Enter supplier of product: ");
		String supplier = in.nextLine();
		
		prodInv.addProduct(new Product(productId, productName, productCategory, price, quantity, supplier));
		System.out.println();
	}
	
	/*
	 * since the removeProduct() is a boolean method, the if condition is based on whether the program can find the product of the
	 * specified ID. if it can, it returns true, if not, it returns false
	 */
	
	public static void removeProduct(Scanner in, ProductInventory prodInv) {
		System.out.print("Enter ID of Product to be removed: ");
		String productId = in.next();
		if (prodInv.removeProduct(productId)) {
			System.out.println("Product with specified ID has been removed.");
		} else {
			System.out.println("Product with specified ID cannot be found. No changes have been made to inventory.");
		}
		System.out.println();
	}
	
	/*
	 * prints the toString() of specified product if it is found, else say the product with specified ID cannot be found
	 */
	
	public static void findProduct(Scanner in, ProductInventory prodInv) {
		System.out.print("Enter product ID of product to be found: ");
		String productId = in.next();
		if (prodInv.findProduct(productId) != null) {
			System.out.println(prodInv.findProduct(productId));
		} else {
			System.out.println("Product of specified ID cannot be found!");
		}
		System.out.println();
	}
	
	/*
	 * prints out the toString() abbreviation of all products in ProductInvetory
	 */
	
	public static void listProducts(ProductInventory prodInv) {
		prodInv.printAllProducts();
		System.out.println();
	}
	
	/*
	 * createOrder() requires that the user fulfills all of the data fields of the Order class. it will also handle items that are
	 * added into Order by prompting the user how many items are in the data set and to input information about each item. it also
	 * handles order status 
	 */
	
	public static void createOrder(OrderManager ordMan, Scanner in) {
		in.nextLine();
		System.out.print("Enter Order ID: ");
		String orderId = in.next();
		
		in.nextLine();
		System.out.print("Enter Customer Name: ");
		String customerName = in.nextLine();
		
		System.out.print("Enter Order Date: ");
		String orderDate = in.nextLine();
		
		ordMan.addOrder(new Order(orderId, customerName, orderDate));
		
		System.out.print("How many items did this customer order? ");
		int items = processInt(in);
		int index = 0;
		while (index < items) {
			System.out.print("Enter product ID for item #" + (index+1) + ": ");
			String productId = in.next();
			
			in.nextLine();
			System.out.print("Enter product name for item #" + (index+1) + ": ");
			String productName = in.nextLine();
			
			System.out.print("Enter quantity for item #" + (index+1) + ": ");
			int quantity = processInt(in);
			while (quantity < 0) {
				System.out.print("Quantity cannot be negative! Enter a number >= 0! ");
				quantity = processInt(in);
			}
			
			System.out.print("Enter price for item #" + (index+1) + ": ");
			double price = processDouble(in);
			while (price < 0) {
				System.out.print("Price cannot be negative! Enter a number > 0! ");
				price = processDouble(in);
			}
			
			ordMan.findOrder(orderId).addItem(new OrderItem(productId, productName, quantity, price));
			index++;
			System.out.println();
		}
		
		in.nextLine();
		System.out.print("Enter status of order: ");
		String status = in.nextLine();
		ordMan.findOrder(orderId).updateStatus(status);
		System.out.println();
	}
	
	/*
	 * calls the printAllOrders() method in the OrderManager class that calls the printOrder() method in the Order class
	 */
	
	public static void viewOrders(OrderManager ordMan) {
		ordMan.printAllOrders();
		System.out.println();
	}
	
	/*
	 * assuming that processOrder would mean to update the order status, this method asks to user to input the Id of the order
	 * they want to process, and to what status they want to update the order to.
	 */
	
	public static void processOrder(OrderManager ordMan, Scanner in) {
		in.nextLine();
		System.out.print("Enter ID of order to process: ");
		String orderId = in.next();
		if (ordMan.findOrder(orderId) != null) {
			in.nextLine();
			System.out.print("Enter Status of order: ");
			String status = in.nextLine();
			ordMan.findOrder(orderId).updateStatus(status);
		} else {
			System.out.println("Could not find order of specified ID. No changes have been made to manager.");
			in.nextLine();
		}
		System.out.println();
	}
	
	/*
	 * generateReports() utilizes methods that have not been used by the first few options. it prints out stats about the value of
	 * the inventory, the revenue the orders have generated, printing products based on threshold inputed by user or by category
	 * inputed by the user, printing orders based on status inputed by user or by customer inputed by the user.
	 */
	
	public static void generateReports(ProductInventory prodInv, OrderManager ordMan, Scanner in) {
		in.nextLine();
		// below is title header for product inventory
		System.out.println("-------Report Statistics for Inventory----------");
		// below are the quantifier methods from productInventory
		System.out.printf("Total Invetory Value: $%.2f%n", prodInv.getTotalInventoryValue());
		System.out.println("Products in Invetory: " + prodInv.getTotalProducts());
		// below are the statements to view products by category		
		System.out.print("To view products of inventory by category, type the category: ");
		String categoryView = in.nextLine();
		Vector<Product> prodCategory = prodInv.getProductsByCategory(categoryView);
		// add checker here
		if (prodCategory.size() == 0) {
			System.out.println("There are no products in that specified category.");
		} else {
			for (int i = 0; i < prodCategory.size(); i++) {
				System.out.println("Item #" + (i+1) + ": " + prodCategory.get(i));
			}
		}
		// below are the statements to view products by low threshold specified by user
		System.out.print("To view products of inventory by low threshold, type the threshold: ");
		int thresholdView = processInt(in);
		in.nextLine();
		Vector<Product> thresholdProd = prodInv.getLowStockProducts(thresholdView);
		// add checker here
		if (thresholdProd.size() == 0) {
			System.out.println("There are no products below specified threshold.");
		} else {
			for (int i = 0; i < thresholdProd.size(); i++) {
				System.out.println("Item #" + (i+1) + ": " + thresholdProd.get(i));
			}
		}
		// lastly, print out the capacity report showing vector stats
		prodInv.printCapacityReport();
		System.out.println("---------------------------------------------------------\n");
		
		// below is the title header for the order manager
		System.out.println("----------Report Statistics for Order Manager------------");
		// below are the quantifier methods from orderManager
		System.out.printf("Total Revenue: $%.2f%n", ordMan.getTotalRevenue());
		System.out.println("Total Order Count: " + ordMan.getOrderCount());
		// below are the methods and lines to print pending Orders
		System.out.println("Viewing pending orders: ");
		Vector<Order> pending = ordMan.getPendingOrders();
		if (pending.size() == 0) {
			System.out.println("There are no pending orders.");
		} else {
			for (int i = 0; i < pending.size(); i++) {
				System.out.println("Order #" + (i+1) + ": " + pending.get(i));
			}
		}
		// below are the lines and methods for viewing orders by customer
		System.out.print("To view orders by customer, type the customer name: ");
		String customerName = in.nextLine();
		Vector<Order> customerOrders = ordMan.getOrdersByCustomer(customerName);
		if (customerOrders.size() == 0) {
			System.out.println("That customer has no orders.");
		} else {
			for (int i = 0; i < customerOrders.size(); i++) {
				System.out.println("Order #" + (i+1) + ": " + customerOrders.get(i));
			}
		}
		//below are the lines and methods for viewing orders by status
		System.out.print("To view orders by status, type the order status (\"Pending\", \"Processing\", \"Shipped\", \"Out for delivery\", \"Delivered\", \"Returned\", \"Cancelled\"): ");
		String status = in.nextLine();
		Vector<Order> statusOrders = ordMan.getOrdersByStatus(status);
		if (statusOrders.size() == 0) {
			System.out.println("There are no orders with that specified status.");
		} else {
			for (int i = 0; i < statusOrders.size(); i++) {
				System.out.println("Order #" + (i+1) + ": " + statusOrders.get(i));
			}
		}
		System.out.println("------------------------------------------------------\n");

	}
	
	/*
	 * to handle InputMismatchException generated out of a user typing any character that is not satisfactory of a double.
	 * it uses recursion and continues the cycle until the user enters an actual number
	 */
	
	public static double processDouble(Scanner in) {
		double number = 0;
		try {
			number = in.nextDouble();
		} catch (InputMismatchException ex) {
			System.out.print("Please enter a valid number: ");
			in.nextLine();
			number = processDouble(in);
		}
		return number;
	}
	
	/*
	 * same scenario as processDouble(), this time the exception is only triggered when the user does not enter a whole number
	 */
	
	public static int processInt(Scanner in) {
		int number = 0;
		try {
			number = in.nextInt();
		} catch (InputMismatchException ex) {
			System.out.print("Please enter a valid whole number: ");
			in.nextLine();
			number = processInt(in);
		}
		return number;
	}

}
