package main.hw2;

public class Penguin extends Bird implements IBird {
    @Override
    public void fly() {
        System.out.println("Пингвины не летают!");
    }

    @Override
    public void chirp() {
        System.out.println("чик-чирик");
    }
}
