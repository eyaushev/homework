package main.hw1.extra;

public class Cat extends Animals {

    public void meow(){
        System.out.println("Мяу!");
    }

    Cat(String name, String color, int age){
        super(name, color, age);
    }
}
