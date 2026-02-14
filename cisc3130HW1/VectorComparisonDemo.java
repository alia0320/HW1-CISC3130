package cisc3130HW1;

import java.util.Vector;
import java.util.ArrayList;

public class VectorComparisonDemo {

	public static void main(String[] args) {
		printALStats();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		printVectorStats();
	}
	
	public static void printALStats() {
		ArrayList<Product> prodAL = new ArrayList<>();
		
		// assess add time for ArrayList
		
		long start_add_AL_time = System.nanoTime(); // check the time of the program running before adding the elements
		for (int i = 0; i < 100000; i++) {
			prodAL.add(new Product("PP001", "Cheerios", "Cereal", 5.99, 1, "General Mills"));
		}
		long end_add_AL_time = System.nanoTime(); // check the time of the program after adding the elements
		long add_AL_time = end_add_AL_time - start_add_AL_time; // total duration of add time in nanoseconds
		
		// assess access time for ArrayList
		
		long start_acc_AL_time = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			prodAL.get(i);
		}
		long end_acc_AL_time = System.nanoTime();
		long acc_AL_time = end_acc_AL_time - start_acc_AL_time;
		
		// print Memory Statistics using Runtime. while the function is not entirely accurate with the memory stats, it still
		// gives a good idea on how much memory is being used for Vectors vs ArrayLists
		
		Runtime runtime = Runtime.getRuntime();
		
        long megaByte = 1024L * 1024L; // since runtime memory methods return the memory stats in bytes, they will need to be divided
        // by the megaByte to get the units in megabyte
        
        System.out.println("------System Run Time Stats (ArrayList)-------");
        System.out.println("Time to add 100,000 elements to ArrayList: " + add_AL_time + " nanoseconds");
        System.out.println("Time to access 1,000 elements in ArrayList: " + acc_AL_time + " nanoseconds");
        System.out.println();
		
		System.out.println("------------Heap Utilization Stats (ArrayList)--------------");
	    System.out.println("Total Memory (allocated from OS): " + runtime.totalMemory() / megaByte + " MB");
	    System.out.println("Free Memory (within allocated total): " + runtime.freeMemory() / megaByte + " MB");
	    System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / megaByte + " MB");
	    System.out.println("Max Memory (JVM limit): " + runtime.maxMemory() / megaByte + " MB");
	}
	
	public static void printVectorStats() {
		Vector<Product> prodVec = new Vector<>();
		
		// assess add time for vector
		
		long start_add_vec_time = System.nanoTime(); // check the time of the program running before adding the elements
		for (int i = 0; i < 100000; i++) {
			prodVec.add(new Product("PP001", "Cheerios", "Cereal", 5.99, 1, "General Mills"));
		}
		long end_add_vec_time = System.nanoTime(); // check the time of the program after adding the elements
		long add_vec_time = end_add_vec_time - start_add_vec_time; // total duration of add time in nanoseconds
		
		// assess access time for vector
		
		long start_acc_vec_time = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			prodVec.get(i);
		}
		long end_acc_vec_time = System.nanoTime();
		long acc_vec_time = end_acc_vec_time - start_acc_vec_time;
		
		// print Memory Statistics using Runtime. while the function is not entirely accurate with the memory stats, it still
		// gives a good idea on how much memory is being used for Vectors vs ArrayLists
		
		Runtime runtime = Runtime.getRuntime();
		
        long megaByte = 1024L * 1024L; // since runtime memory methods return the memory stats in bytes, they will need to be divided
        // by the megaByte to get the units in megabyte
        
        System.out.println("------System Run Time Stats (Vector)-------");
        System.out.println("Time to add 100,000 elements to Vector: " + add_vec_time + " nanoseconds");
        System.out.println("Time to access 1,000 elements in Vector: " + acc_vec_time + " nanoseconds");
        System.out.println();
		
		System.out.println("------------Heap Utilization Stats (Vector)--------------");
	    System.out.println("Total Memory (allocated from OS): " + runtime.totalMemory() / megaByte + " MB");
	    System.out.println("Free Memory (within allocated total): " + runtime.freeMemory() / megaByte + " MB");
	    System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / megaByte + " MB");
	    System.out.println("Max Memory (JVM limit): " + runtime.maxMemory() / megaByte + " MB");
	}

	
	/*
	 * Summary of what I've seen:
	 * Vectors and ArrayLists will barely be noticeable in difference if the data sets are as small as 10,000. The only time you
	 * would notice a difference between the two is when you are working with larger data sets, as seen with 100,000 elements. It is
	 * evident that ArrayList will beat Vectors in all categories, add/access time and heap utilization. Vectors should only be used
	 * when you are making a sensitive program, and thread-safety is key to making that program work. Otherwise, use ArrayLists, they
	 * are way faster and use less memory on the RAM.
	 */
}
