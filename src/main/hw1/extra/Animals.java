package main.hw1.extra;

public class Animals {
    public String name;
    public String color;
    public int age;
    public final int pawsCount = 4;

    public void run(){
        System.out.println(name + " бежит!");
    }

    Animals(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }
}
