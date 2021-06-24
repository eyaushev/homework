package main.hw2.extra;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age && name.equals(animals.name) && color.equals(animals.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, age, pawsCount);
    }
}
