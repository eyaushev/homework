import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public enum Person {

    INITIAL("Яушев Эдуард Маратович qqqq", "1917-10-03", "yaushev", "qwerty123!", LocalDateTime.now()),
    GENERATED();

    private String fullName;
    private String birthDate;
    private String login;
    private String password;
    private LocalDateTime regDate;

    Person(){
        fullName = fullnameGenerator();
        birthDate = birthDateGenerator();
        login = loginGenerator(6);
        password = passwordGenerator(8);
        regDate = regDateGenerator();

    }

    Person(String fullName, String birthDate, String login, String password, LocalDateTime regDate){
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.login = login;
        this.password = password;
        this.regDate = regDate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
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
        String[] names = {"Иван", "Петр", "Сидор", "Сократ", "Олег", "Данил", "Артём", "Борис", "Антон", "Егор", "Александр"};
        String name = names[new Random().nextInt(names.length)];
        return String.format("%sов %s %sович", name, name, name);
    }

    private String birthDateGenerator(){
        LocalDate start = LocalDate.now().minus(102, ChronoUnit.YEARS);
        LocalDate end = LocalDate.now();
        long days = start.until(end, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return start.plusDays(randomDays).format(formatter);
    }

    private String loginGenerator(int length){
        int minLength = 2;
        Random rand = new Random();
        return RandomStringUtils.randomAlphabetic(rand.nextInt((length-minLength) + 1) + minLength);
    }

    private String passwordGenerator(int length){
        String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
        String DIGIT = "0123456789";
        String SPECIALS = "!@#&()–[{}]:;',?/*~$^+=<>";
        StringBuilder password = new StringBuilder(length);

        int i = 1;
        while (i<length){
            if (i%2 == 0)
                password.append(CHAR_LOWERCASE.charAt(new Random().nextInt(CHAR_LOWERCASE.length())));
            else
                password.append(CHAR_UPPERCASE.charAt(new Random().nextInt(CHAR_UPPERCASE.length())));
            i++;
        }

        password.setCharAt(new Random().nextInt(password.length()), DIGIT.charAt(new Random().nextInt(DIGIT.length())));
        password.append(SPECIALS.charAt(new Random().nextInt(SPECIALS.length())));

        return password.toString();
    }

    private LocalDateTime regDateGenerator(){
        return LocalDateTime.now();
    }

}
