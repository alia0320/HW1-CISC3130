package cisc3130HW1;

import java.util.Vector;
import java.util.function.Predicate;

public class VectorUtils {
	
	public static <T> void swap(Vector<T> vec, int index1, int index2) {
		T temp = vec.get(index1);
		vec.set(index1, vec.get(index2));
		vec.set(index2, temp);
	}
	
	public static <T extends Comparable<T>> T findMax(Vector<T> vec) {
		T maxelement = vec.get(0);
		for (int i = 1; i < vec.size(); i++) {
			if (vec.get(i).compareTo(maxelement) > 0) {
				maxelement = vec.get(i);
			}
		}
		return maxelement;
	}
	
	public static <T> int countMatches(Vector<T> vec, T target) {
		int occurrences = 0;
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).equals(target)) {
				occurrences++;
			}
		}
		return occurrences;
	}
	
	/*
	 * to satisfy condition: we will have to use the test method of the Predicate class. if the boolean returns true, then add
	 * the element of the satisfied condition to the filtered Vector
	 */
	
	public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition) {
		Vector<T> filtered = new Vector<>(10);
		for (int i = 0; i < vec.size(); i++) {
			if (condition.test(vec.get(i))) {
				filtered.add(vec.get(i));
			}
		}
		return filtered;
	}
	
	public static <T extends Number> double sumNumbers(Vector<T> numbers) {
		double total = 0;
		for (int i = 0; i < numbers.size(); i++) {
			total += numbers.get(i).doubleValue();
		}
		return total;
	}
	
	public static <T extends Number> double averageNumbers(Vector<T> numbers) {
		double total = sumNumbers(numbers);
		return total/numbers.size();
	}

}
