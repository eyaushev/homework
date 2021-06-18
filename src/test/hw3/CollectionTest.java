package test.hw3;

import main.hw1.extra.Cat;
import main.hw1.extra.Dog;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        cats.add(new Cat("Барсик", "черный", 3));
        cats.add(new Cat("Гарфилд", "рыжий", 5));
        cats.add(new Cat("Гарфилд", "рыжий", 5));

        dogs.add(new Dog("Тузик", "черный", 5));
        dogs.add(new Dog("Шарик", "черный", 4));
        dogs.add(new Dog("Шарик", "черный", 4));

        System.out.println(cats.get(0).name);
        System.out.println(dogs.get(0).name);
    }
}
