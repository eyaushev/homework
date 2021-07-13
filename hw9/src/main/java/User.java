import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class User implements Serializable  {
    private String name; //ФИО с заглавной буквы по формату Иванов Иван Иванович
    private String birthday; //Дата в виде года 1991-01-01
    private String registrationDate; //Дата в виде 2020-01-01T00:00:00
    private String login; //6 знаков алфавитно-числовой на латинице
    private String password; //10 знаков алфавитно-числовой на латинице
    private Address homeAddress;

    public User() {
        this.name = generateName();
        this.birthday = birthDateGenerator();
        this.registrationDate = generateRegistrationDate();
        this.login = generateLogin(6);
        this.password = generatePassword(10);
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() {
        return homeAddress.toString();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s, дата рождения: %s, дата регистрации: %s, логин: %s, пароль: %s",
                name, birthday, registrationDate, login, password
        );
    }

    private String birthDateGenerator(){
        LocalDate start = LocalDate.now().minus(102, ChronoUnit.YEARS);
        LocalDate end = LocalDate.now();
        long days = start.until(end, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return start.plusDays(randomDays).format(formatter);
    }


    private String generateRegistrationDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }

    private String generateLogin(int count){
        return generateRandomAlphaNumeric(count);
    }

    private String generatePassword(int count){
        return generateRandomAlphaNumeric(count);
    }

    private String generateRandomAlphaNumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    private String generateName(){
        String[] names = {"Иван", "Петр", "Сидор", "Сократ", "Олег", "Данил", "Артём", "Борис", "Антон", "Егор", "Александр"};
        String name = names[new Random().nextInt(names.length)];
        return String.format("%sов %s %sович", name, name, name);
    }

    public static List<User> generateUsers(int count){
        List<User> users = new ArrayList<>(Collections.emptyList());
        for (int i=1; i<=count; i++)
            users.add(new User());
        return users;
    }
}
