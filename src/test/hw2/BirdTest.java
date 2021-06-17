package test.hw2;

import main.hw2.Bird;
import main.hw2.Duck;
import main.hw2.Penguin;

public class BirdTest {
    public static void main(String[] args) {
        Bird duck = new Duck();
        Bird penguin = new Penguin();

        System.out.println(duck.chirp());
        System.out.println(penguin.chirp("гав-гав"));

        System.out.println(penguin);
        System.out.println(duck);
    }
}
