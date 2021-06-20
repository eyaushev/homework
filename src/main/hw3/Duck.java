package main.hw3;

public class Duck extends Bird implements IBird {
    @Override
    public String canFly() {
        return this.getName() + " полетела!";
    }

    @Override
    public String chirp() {
        return "кря-кря";
    }

    @Override
    public String chirp(String value) {
        return value;
    }

    @Override
    public String toString() {
        return "Duck{" +
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

    public Duck(){
        super.setName("Утка");
        super.setFamily("Утиные");
        super.setOrder("Гусеобразные");
    }
}
   