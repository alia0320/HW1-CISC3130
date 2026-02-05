package week2lab;

public class PokeBox {
	
	private Pokemon value;
	
	public PokeBox(Pokemon value) {
		this.value = value;
	}
	
	public Pokemon get() {
		return value;
	}
	
	public void set(Pokemon value1) {
		value = value1;
	}

}
