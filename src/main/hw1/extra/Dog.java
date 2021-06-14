package main.hw1.extra;

public class Dog extends Animals {

    public void bark(){
        System.out.println("Гав!");
    }

    Dog(String name, String color, int age) {
        super(name, color, age);
    }
}
