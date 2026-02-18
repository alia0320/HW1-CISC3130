package cisc3130HW1;

import java.util.Vector;
import java.util.Enumeration;

public class ProductInventory {
	private Vector<Product> products;
	
	public ProductInventory() {
		this.products = new Vector<>(10);
	}
	
	/*
	 * addProduct uses a boolean that will switch to true as the for loop checks the whole vector for another duplicate.
	 * if there is another duplicate, then the program will not add anything to the products vector.
	 */
	
	public void addProduct(Product product) {
		boolean duplicate = false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).equals(product)) {
				duplicate = true;
			}
		}
		
		if (!duplicate) {
			products.add(product);
		}
	}
	
	/*
	 * uses found boolean to verify whether a product with specified id has been found. a while loop goes through the whole
	 * vector to find product with specified Id. if found is true, then break out of the loop and return found, or else, go through
	 * the whole vector and dont change the boolean value
	 */
	
	public boolean removeProduct(String productId) {
		boolean found = false;
		int index = 0;
		while (!found && index < products.size()) {
			if (products.get(index).getProductId().equals(productId)) {
				found = true;
				products.remove(index);
			}
			index++;
		}
		return found;
	}
	
	public Product findProduct(String productId) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductId().equals(productId)) {
				return products.get(i);
			}
		}
		return null;
	}
	
	public Vector<Product> getProductsByCategory(String category) {
		Vector<Product> prodcat = new Vector<>(10);
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCategory().equals(category)) {
				prodcat.add(products.get(i));
			}
		}
		return prodcat;
	}
	
	public Vector<Product> getLowStockProducts(int threshold) {
		Vector<Product> prodlow = new Vector<>(10);
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getQuantity() < threshold) {
				prodlow.add(products.get(i));
			}
		}
		return prodlow;
	}
	
	public double getTotalInventoryValue() {
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += (products.get(i).getPrice()*products.get(i).getQuantity());
		}
		if (products.size() != 0) {
			return total;
		} else {
			return 0;
		}
	}
	
	/*
	 * uses findProduct() method already defined in the class to save time. assume that stock can be negative number.
	 * if product of specified ID cannot be found, it prints a statement saying that product cannpt be found.
	 */
	
	public void updateStock(String productId, int quantityChange) {
		if ((findProduct(productId)!= null) && quantityChange >= 0) {
			findProduct(productId).setQuantity(quantityChange);
		} else {
			System.out.println("Could not find item of specified ID, not changes made to stock. Also make sure the quantity is not negative.");
		}
	}
	
	public void printAllProducts() {
		System.out.println("-----------------------------");
		for (int i = 0; i < products.size(); i++) {
			System.out.println("Product #" + (i+1) + ": " + products.get(i));
		}
		System.out.println("------------------------------");
	}
	
	/*
	 * assume that products in the git assignment means that it just wants the variety of them, not including the stock
	 */
	
	public int getTotalProducts() {
		return products.size();
	}
	
	/*
	 * prints capacity of products Vector and its size. prints out the percent of the vector used and how many more elements
	 * need to be added to the vector before vector resize
	 */
	
	public void printCapacityReport() {
		System.out.println("----------ProductInventory Capacity Report----------");
		System.out.println("Current size of Products Vector: " + products.size());
		System.out.println("Capacity of the Products Vector: " + products.capacity());
		System.out.println("Utilization of Vector's Capacity: " + ((double) products.size()/products.capacity()) * 100 + "%");
		System.out.println("Max number of elements before Vector resize: " + (products.capacity()-products.size()));
		System.out.println("--------------------------------------------");
	}
	
	public void optimizeCapacity() {
		products.trimToSize();
	}
	
	public void ensureCapacity(int minCapacity) {
		products.ensureCapacity(minCapacity);
	}
	
	/*
	 * Difference between enum and Iterator: enums are synchronized and fail-safe when dealing with synchronized structures such as 
	 * Vectors. Iterators are more so preferred when there aren't multiple threads doing different things to the same data structure.
	 */
	
	public void printProductsUsingEnumeration() {
		Enumeration<Product> prodenum = products.elements();
		while (prodenum.hasMoreElements()) {
			System.out.println(prodenum.nextElement());
		}
	}

	
}
