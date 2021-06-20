package test.hw4;

import main.hw2.extra.Animals;
import main.hw2.extra.Cat;
import main.hw2.extra.Dog;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        cats.add(new Cat("Барсик", "черный", 3));
        cats.add(new Cat("Гарфилд", "рыжий", 5));

        dogs.add(new Dog("Тузик", "черный", 5));
        dogs.add(new Dog("Шарик", "черный", 4));

        Set<Animals> catSet = new HashSet<>(cats);
        Set<Animals> dogSet = new HashSet<>(dogs);

        Map<String, Set<Animals>> animalMap = new HashMap<>();
        animalMap.put("Кошка", catSet);
        animalMap.put("Собака", dogSet);
    }
}
