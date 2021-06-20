package main.hw3;

public class Penguin extends Bird implements IBird {
    @Override
    public String canFly() {
        return "Пингвины не летают!";
    }

    @Override
    public String chirp() {
        return "чик-чирик";
    }

    public String chirp(String value) {
        return value;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "name='" + super.getName() + '\'' +
                ", family='" + super.getFamily() + '\'' +
                ", order='" + super.getOrder() + '\'' +
                ", chirp='" + chirp() + '\'' +
                ", canFly='" + canFly() + '\'' +
                ", canSwim='" + canSwim() + '\'' +
                '}';
    }

    @Override
    public String canSwim() {
        return super.canSwim() + ", но " + this.getName() + " - водоплавающая птица";
    }

    public Penguin(){
        super.setName("Пингвин");
        super.setFamily("Пингвиновые");
        super.setOrder("Пингвинообразные");
    }
}
