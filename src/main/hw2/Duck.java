package main.hw2;

public class Duck extends Bird implements IBird {
    @Override
    public void fly() {
        System.out.println(this.getName() + " полетела!");
    }

    @Override
    public void chirp() {
        System.out.println("кря-кря");
    }

    @Override
    public String toString() {
        return "Утка";
    }
}
