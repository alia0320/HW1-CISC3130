package week2lab;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric");
        Pokemon charmander = new Pokemon("Charmander", "Fire");

        System.out.println(pikachu);
        System.out.println(charmander+"\n");

        System.out.println("Task 1:");
        PokeBox box_charmander = new PokeBox(charmander); // task 1, bad version
        System.out.println("This pokemon is in a PokeBox: " + box_charmander.get()); // checking whether the bad version of the class works
        box_charmander.set(new Pokemon("Charmeleon", "Fire")); // evolve!
        System.out.println("This pokemon is in a PokeBox: " + box_charmander.get()+"\n"); // checking whether the bad version of the class works
        
        System.out.println("Task 2: \nI just wrote the Box class.");
        Box<Pokemon> pokemonBox = new Box<>(pikachu); // task 2
        Box<String> itemBox = new Box<>("Oran Berry");
        Box<Integer> levelBox = new Box<>(25);
        System.out.println();
        
        
        System.out.println("Task 3:");
        Pair<Pokemon, String> heldItem = new Pair<>(pikachu, "Oran Berry"); // task 3
        System.out.println(heldItem+"\n");
        
        System.out.println("Task 4:");
        PokemonOnlyBox<Pokemon> b1 = new PokemonOnlyBox<>(pikachu); // task 4
        System.out.println(b1.getType()+"\n");
        
        System.out.println("Task 5:");
        BattlePokemon squirtle = new BattlePokemon("Squirtle", "Water", 60); // task 5
        PokemonOnlyBox<BattlePokemon> battleBox = new PokemonOnlyBox<>(squirtle);
        System.out.println(battleBox.get()+"\n");
        
        System.out.println("Task 6:");
        Box<String> a = new Box<>("Potion");
        Box<String> b = new Box<>("Rare Candy");
        System.out.println("Before: a=" + a.get() + ", b=" + b.get());
        swap(a, b);
        System.out.println("After:  a=" + a.get() + ", b=" + b.get());
        
    }
    
    public static <T> void swap(Box<T> a, Box<T> b) {
    	T temp = a.get();
    	a.set(b.get());
    	b.set(temp);
    }

}