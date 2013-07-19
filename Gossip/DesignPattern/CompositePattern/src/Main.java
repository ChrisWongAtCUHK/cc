import java.util.*;

interface Edible {
    void eat();
}

class Cuisine implements Edible {
    private String food;
    Cuisine(String food) {
        this.food = food;
    }
    public void eat() {
        System.out.println("eat " + food);
    }
}

class Eatlist implements Edible {
    private List<Edible> list = new ArrayList<Edible>();
    public void add(Edible edible) {
        list.add(edible);
    }
    public void eat() {
        for(Edible edible : list) {
            edible.eat();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cuisine cuhkCuisine = new Cuisine("Cuisine from CUHK");
        
        Eatlist eatlist1 = new Eatlist();
        eatlist1.add(new Cuisine("Lemon pile"));
        eatlist1.add(new Cuisine("UC staff canteen chinese tea"));
        
        Eatlist eatlist2 = new Eatlist();
        eatlist2.add(new Cuisine("Cup noodle"));
        eatlist2.add(new Cuisine("Fry noodle king"));
        
        Eatlist all = new Eatlist();
        all.add(cuhkCuisine);
        all.add(eatlist1);
        all.add(eatlist2);
        
        all.eat();
    }
}