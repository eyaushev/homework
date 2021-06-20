package main.hw2.extra;

public class Cat extends Animals {

    public void meow(){
        System.out.println("Мяу!");
    }

    public Cat(String name, String color, int age){
        super(name, color, age);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
