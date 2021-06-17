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

    public void chirp(String value) {
        System.out.println(value);
    }


    @Override
    public String toString() {
        return "Пингвин";
    }

    @Override
    public String canSwim() {
        return super.canSwim() + ", но " + this.getName() + " - водоплавающая птица";
    }
}
