package main.hw2;

public abstract class Bird {
    private String name;
    private String family;
    private String order;

    public String canSwim(){
        return "Птицы обычно не плавают";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
