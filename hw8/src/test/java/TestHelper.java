import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHelper {
    public static boolean checkLogin(String login){
        System.out.println("Логин: " + login);
        Pattern pattern = Pattern.compile("^.{2,6}$");
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    public static boolean checkPassword(String password){
        System.out.println("Пароль: " + password);
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–\\[{}\\]:;',?/*~$^+=<>]).{6,20}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean checkFullname(String fullname){
        System.out.println("Полное имя: " + fullname);
        Pattern pattern = Pattern.compile("^\\s*([a-zA-Z*\\p{IsCyrillic}]+\\s*){1,3}$"); // максимум 3 слова без цифр и спецсимволов
        Matcher matcher = pattern.matcher(fullname);
        return matcher.find();
    }

    public static boolean checkBirthdate(String birthdate, int maxYear){
        System.out.println("Дата рождения: " + birthdate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthdate, formatter);
        Period period = Period.between(date, LocalDate.now());
        return period.getYears() <= maxYear;
    }


}
