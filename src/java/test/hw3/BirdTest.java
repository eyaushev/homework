package test.hw3;

import main.hw3.BirdImpl;
import main.hw3.Duck;
import main.hw3.Penguin;

public class BirdTest {
    public static void main(String[] args) {
        BirdImpl duck = new Duck();
        BirdImpl penguin = new Penguin();

        System.out.println(duck.chirp());
        System.out.println(penguin.chirp("гав-гав"));

        System.out.println(penguin);
        System.out.println(duck);
    }
}
