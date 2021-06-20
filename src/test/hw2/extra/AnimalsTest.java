package test.hw2.extra;

import main.hw2.extra.Animals;
import main.hw2.extra.Cat;
import main.hw2.extra.Dog;

public class AnimalsTest {
    public static void main(String[] args) {
        Animals cat1 = new Cat("Барсик", "черный", 3);
        Animals cat2 = new Cat("Гарфилд", "рыжий", 5);
        Animals dog1 = new Dog("Тузик", "черный", 5);
        Animals dog2 = new Dog("Шарик", "черный", 4);
        System.out.println(cat1.toString());
        System.out.println(cat2.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
    }
}
