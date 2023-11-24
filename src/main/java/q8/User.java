package q8;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // class Shape {

    // }

    // class Circle extends Shape {

    // }

    // public static void main(String[] args) {
    //     Object o;
    //     Shape s;
    //     Circle c;

    //     List<? extends Shape> l1 = new ArrayList<>();
    //     List<? super Shape> l2 = new ArrayList<>();

    //     l1.add(c);
    //     l2.add(c);
    //     l1.add(s);
    //     l2.add(s);
    //     l1.add(o);
    //     l2.add(o);
    //     c = l1.get(0);
    //     c = l2.get(0);
    //     s = l1.get(0);
    //     s = l2.get(0);
    //     o = l1.get(0);
    //     o = l2.get(0);
    // }
}
