Hello! I just finished making the whole program for a second time after git rm rfed the last commit I made to gitHub. Very infurating,
but finally glad I was able to finish the program in one sitting (this time 6 hours long). Before running the program, understand that
since all of the classes are java classes, you will need the Java Development Kit (JDK) to compile the program. I also recommend
putting all of the files of the repository into a single folder to avoid potential issues with files not being able to access each
other. One more thing before I start describing the classes, try running the program on an IDE. Since I made these programs on Eclipse,
all of the classes will have a package line on the first line. If you are not running this program on an IDE that does not require the
package header, then remove that line from all of the classes that have it.


CLASS DESCRIPTIONS:
	- THE MAIN CLASS:
		- InventorySystemMain.java
		This class is the only class that the user can interact with. The main method mostly performs the functionalities with the
		interactable menu and calls all other methods based on what the user wants to do. The class will not use every method
		that the ProductInventory and the OrderManager classes have, but will make the most out of the two classes. To clarify what
		"all other methods" means, the main class has 10 methods (excluding main) that each get triggered by the user's request, but
		there are only 8 menu options. That is because there are two methods that are designed to handle InputMismatchExceptions
		that are generated out of the user putting in an invalid token.
		
	- NON-OBJECT CLASSES:
		1. TempTest.java:
		This class was used to test out the Product, ProductInventory, OrderItem, Order, and OrderManager classes to test
		out the functionalities of these classes with each other. Nonetheless, this is not an interactive class where it waits for
		input from the console.
		
		2. TestGenericUtility.java:
		This class was used to test out the VectorUtils class that demontrates Generic methods working with different data types.
		It also has the GenericContainer test to show that it is compatible with other data types.
		
		3. VectorComparisonDemo.java:
		This class compares the differences between the runtimes of ArrayLists and Vectors. It uses System.nanoTime() to get the
		stats about time, and the Runtime class to get information about the memory usage. Nonetheless, it has taught me to use
		Vectors when thread safety is considered a high priority, as it only allows one thread to work with the structure unlike
		ArrayLists, where it is less fail-safe, and should be used when thread safety is not considered a priority.
		
		4. VectorUtils.java:
		This class only contains static methods that play around with Vectors and Generics. There is a method to swap, a method
		to compare elements and return the greatest one, a method that returns the instances of an element present in a vector,
		a method that returns a filtered vector with elements the satisfy the conditions of a predicate, and the last two methods
		that work with Generic types that inherit from Number.
		
	- OBJECT CLASSES:
		1. Product.java:
		This class mostly consists of getters and setters for the 5 data fields. It has a toString() method that uses a bunch
		of \t characters to make spaces between each data field in the object. It also has an equals() method that checks the
		equality between two Products based on whether both objects have the same productId. It also has to implement the compareTo()
		method from the Comparable Interface, where it returns 1 if the caller's product price is greater than the parameter's
		product price. The only thing I do not understand very well is the hashCode(), as the super's method returns an integer
		based on the name of the object and the methods the object has. I am not sure whether I have fully prevented it, though
		I multiplied the hashCode's number by 31 and the int-casted price set by the user.
		
		2. ProductInventory.java:
		This class is more so Vector<Product> with very useful functionalities. You can traverse this vector, change details about
		object fields, get products by user's criteria, and get overall statistics about the Inventory of our management system.
		getTotalProducts() does not return how many of every product is in our inventory, but only the variety of the product that
		is there. This is because of how the stock can be set to a negative number, which does not make sense to me, but the gitHub
		prompt says it can be negative, so I will leave that alone.
		
		3. OrderItem.java:
		This class is very similar to the Product class, it has 5 data fields asking for similar things, and mostly consists of
		getters and setters. I added a toString() method to debug and check whether the object has the right satistics. 
		There is also a calculateTotal() method which is not all that useful but helps with code readability and updating 
		the subtotal if changes are made to the quantity or unit price.
		
		4. Order.java:
		This class has a fair balance of emphasis on its own data fields and the Vector containing information about OrderItem.
		It has getters when retrieving stats about OrderId, customerName, OrderStatus, and OrderDate (get for orderDate is
		not that useful).
		You can update the order's status, get information about the order such as its revenue, and get information about the
		items in the order. It has a toString() method, once again for debugging, and a getter for all the items.
		
		5. OrderManager.java:
		This class mostly centers around a Vector storing all Orders made in the program. You can retreive orders, add orders,
		remove orders, get a smaller vector of orders based on user criteria, and general statistics about the order such as 
		how many orders there are, how much revenue all the orders combined amount to, and printing all the orders in the system.
		
		6. GenericContainer.java:
		This class is not useful at all, though I see the purpose for it as we are learning about Vectors and Generics. It has 
		the same exact method names as Vector, though I might be misunderstood. This class to me is more so of a rename of 
		Vector. It could be that it is for readability.
		

CHALLENGES FACED:

I wish there weren't that many challenges that were overlooked by git deleting all of the java files that I spent three days
writing. I am going off of pure memory here, so bear with me. Writing the Object Classes was relatively straightforward, though 
the biggest setbacks I can recall was the Predicate in VectorUtils and TestGenericUtility and the hashCode method in Product. 
I had to read the documentation behind Predicate and a little bit about hashCode(). Nonetheless, I figured out the fundamental
element of using Predicate and how to filter vectors based off of it. hashCode() is still vague to me, since two objects can
share the same hashCode as the generation of it is apparently based off of the methods inside an object and the name of the object. 
I also wish that there was not an issue with the nextLine() statement taking in previous tokens that are not on a separate line,
though I was able to resolve this issue very quickly.

MAIN TAKE AWAY:

Vectors in general are exactly like ArrayLists, just that they are slightly slower because it is synchronized and is considered
legacy for that it was used during a time when programs must be heavily optimized due to hardware limitations. Generics are also
really useful for a language like Java, since we are generally confined to the data types that we already specifed, but can get
around this using generics.
		