import java.util.List;
import java.util.Random;

public class Address {
    private String city;
    private String street;
    private String house;
    private int appartment;
    private Random random = new Random();

    public Address(){
        String[] cities = {"Москва", "Санкт-Петербург", "Казань", "Иннополис", "Уфа", "Воронеж"};
        String[] streets = {"Университетская", "Ленина", "Чистопольская", "Пушкина", "Чернышевского", "Спортивная"};
        String[] houses = {"2A", "3", "4B", "5/1", "6", "7", "8A"};

        this.city = getRandomString(cities);
        this.street = getRandomString(streets);
        this.house = getRandomString(houses);
        this.appartment = getRandomInt(100);
    }

    private String getRandomString(String[] array){
        return array[random.nextInt(array.length)];
    }

    private int getRandomInt(int maxValue){
        return random.nextInt(maxValue) + 1;
    }

    @Override
    public String toString() {
        return String.format("г.%s, ул.%s, д.%s, кв.%s", city, street, house, appartment);
    }
}
