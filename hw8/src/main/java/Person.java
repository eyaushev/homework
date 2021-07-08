import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public enum Person {

    ED("Яушев Эдуард Маратович", LocalDate.of(1993, 10, 7), "yaushev", "qwerty123!", LocalDateTime.now()),
    GENERATED();

    private String fullName;
    private LocalDate birthDate;
    private String login;
    private String password;
    private LocalDateTime regDate;

    Person(){
        fullName = fullnameGenerator();
        birthDate = birthDateGenerator();
        login = loginGenerator(4, 6);
        password = passwordGenerator(6, 12);
        regDate = regDateGenerator();

    }

    Person(String fullName, LocalDate birthDate, String login, String password, LocalDateTime regDate){
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.login = login;
        this.password = password;
        this.regDate = regDate;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }



    private String fullnameGenerator(){
        List<String> names = Arrays.asList("Иван", "Петр", "Сидор", "Сократ", "Олег", "Данил", "Артём", "Борис", "Антон", "Егор", "Александр");
        Random rand = new Random();
        String name = names.get(rand.nextInt(names.size()));
        return String.format("%sов %s %sович;", name, name, name);
    }

    private LocalDate birthDateGenerator(){
        LocalDate start = LocalDate.now().minus(102, ChronoUnit.YEARS);
        LocalDate end = LocalDate.now();
        long days = start.until(end, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        return start.plusDays(randomDays);
    }

    private String loginGenerator(int min, int max){
        Random rand = new Random();
        return RandomStringUtils.randomAlphabetic(rand.nextInt((max-min) + 1) + min);
    }

    private String passwordGenerator(int min, int max){
        String SPECIALS = "!@#$%&*()_+-=[]|,./?><";
        Random rand = new Random();
        String password = RandomStringUtils.randomAlphanumeric(rand.nextInt((max-min) + 1) + min);
        char randomPasswordChar = password.charAt(rand.nextInt(password.length()));
        char randomSpecialChar = SPECIALS.charAt(rand.nextInt(SPECIALS.length()));
        return password.replace(randomPasswordChar, randomSpecialChar);
    }

    private LocalDateTime regDateGenerator(){
        return LocalDateTime.now();
    }

}
