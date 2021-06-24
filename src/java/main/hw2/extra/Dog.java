package main.hw2.extra;

public class Dog extends Animals {

    public void bark(){
        System.out.println("Гав!");
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }
}
