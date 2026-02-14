package cisc3130HW1;

import java.util.Vector;

public class TestGenericUtility {

	public static void main(String[] args) {
		GenericContainer<String> stringContainer = new GenericContainer<>();
		stringContainer.add("Hello");
		stringContainer.add("World");
		
		for (int i = 0; i < stringContainer.size(); i++) {
			System.out.print(stringContainer.get(i) + " ");
		}
		System.out.println();

		GenericContainer<Integer> intContainer = new GenericContainer<>();
		intContainer.add(10);
		intContainer.add(20);
		Vector<Integer> intVector = new Vector<>();
		intVector.add(30);
		intVector.add(40);
		intContainer.addAll(intVector);
		for (int i = 0; i < intContainer.size(); i++) {
			System.out.print(intContainer.get(i) + " ");
		}
		System.out.println();
		intContainer.remove(30);
		for (int i = 0; i < intContainer.size(); i++) {
			System.out.print(intContainer.get(i) + " ");
		}
		System.out.println();

		GenericContainer<Product> productContainer = new GenericContainer<>();
		productContainer.add(new Product("PP001", "Cheerios", "Cereal", 4.99, 5, "General Mills"));
		productContainer.add(new Product("PP002", "Honey Nut Cheerios", "Cereal", 4.49, 10, "General Mills"));
		productContainer.add(new Product("PP003", "Multi Grain Cheerios", "Cereal", 4.9, 20, "General Mills"));

		for (int i = 0; i < productContainer.size(); i++) {
			System.out.println(productContainer.get(i) + " ");
		}
		System.out.println();
		
		// test filter method
		Vector<Product> products = new Vector<>(5);
		products.add(new Product("PP001", "Cheerios", "Cereal", 4.99, 5, "General Mills"));
		products.add(new Product("PP002", "Honey Nut Cheerios", "Cereal", 4.49, 10, "General Mills"));
		products.add(new Product("PP003", "Multi Grain Cheerios", "Cereal", 4.9, 20, "General Mills"));
		products.add(new Product("PP004", "Starry", "Soda", 3.49, 20, "PepsiCo"));
		products.add(new Product("PP005", "Pepsi", "Soda", 3.49, 40, "PepsiCo"));
		products.add(new Product("PP005", "Pepsi", "Soda", 3.49, 40, "PepsiCo"));
		//print all products with Cereal as its category
		Vector<Product> filterByCategory = VectorUtils.filter(products, product -> product.getCategory().equals("Cereal"));
		for (int i = 0; i < filterByCategory.size(); i++) {
			System.out.println(filterByCategory.get(i) + " ");
		}
		System.out.println();		
		
		// test findMax() using Products
		System.out.println("Max of products: " + VectorUtils.findMax(products)); // should print Cheerios Product
		System.out.println();
		
		// test occurences
		Vector<String> stringvec = new Vector<>(5);
		stringvec.add("Wolf");
		stringvec.add("Fox");
		stringvec.add("Hound");
		stringvec.add("Fox");
		stringvec.add("Fox");
		stringvec.add("Dog");
		System.out.println("Fox appearances: " + VectorUtils.countMatches(stringvec, "Fox"));
		// see that works with Products
		System.out.println("Pepsi apperances: " + VectorUtils.countMatches(products, new Product("PP005", "Pepsi", "Soda", 3.49, 40, "PepsiCo")));
		System.out.println();

		// test swap
		System.out.println("String vector before swap:");
		for (int i = 0; i < stringvec.size(); i++) {
			System.out.print(stringvec.get(i) + " "); // ignore fencepost problem
		}
		System.out.println();
		System.out.println("String vector after swap:");
		VectorUtils.swap(stringvec, 0, stringvec.size()-1);
		for (int i = 0; i < stringvec.size(); i++) {
			System.out.print(stringvec.get(i) + " "); // ignore fencepost problem
		}
		System.out.println();
		System.out.println();

		
		// test both sum and average method for int and double
		Vector<Integer> ints = new Vector<>();
		ints.add(10);
		ints.add(20);
		ints.add(30);
		System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
		System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0
		Vector<Double> doubles = new Vector<>();
		doubles.add(5.34);
		doubles.add(7.33);
		doubles.add(5.33);
		System.out.println("Sum: " + VectorUtils.sumNumbers(doubles));  // 18.0
		System.out.println("Average: " + VectorUtils.averageNumbers(doubles)); // 3.0
	}

}
