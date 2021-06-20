package main.hw2.extra;

public class Cat extends Animals {

    public void meow(){
        System.out.println("Мяу!");
    }

    public Cat(String name, String color, int age){
        super(name, color, age);
    }
}
