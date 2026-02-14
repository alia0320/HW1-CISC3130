package cisc3130HW1;

import java.util.Vector;

public class GenericContainer<T> {
	Vector<T> items;
	
	public GenericContainer() {
		this.items = new Vector<>();
	}
	
	public void add(T item) {
		items.add(item);
	}
	
	public T get(int index) {
		return items.get(index);
	}
	
	public boolean remove(T item) {
		boolean found = false;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).equals(item)) {
				found = true;
				items.remove(items.get(i));
				break;
			}
		}
		return found;
	}
	
	public int size() {
		return items.size();
	}
	
	public Vector<T> getAll() {
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
	public boolean contains(T item) {
		return items.contains(item);
	}
	
	public void addAll(Vector<T> other) {
		for (int i = 0; i < other.size(); i++) {
			items.add(other.get(i));
		}
	}
	
	/*
	 * i really do not see a purpose for this class as you can simply make a Vector with the same exact name. It is either that or
	 * I misunderstood the instructions. I guess this is more so a demonstration of whether I understand generics, but still, this 
	 * class does not really amount to much.
	 */
}
