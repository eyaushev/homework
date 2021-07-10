import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование на валидность значений")
public class PersonTest {

//    Person person = Person.GENERATED;
    Person person = Person.INITIAL; // Экземпляр с невалидными значениями

    @Test
    @DisplayName("Проверка логина")
    public void testLogin(){
        Assertions.assertTrue(TestHelper.checkLogin(person.getLogin()));
    }

    @Test
    @DisplayName("Проверка пароля")
    public void testPassword(){
        Assertions.assertTrue(TestHelper.checkPassword(person.getPassword()));
    }

    @Test
    @DisplayName("Проверка полного имени")
    public void testFullName(){
        Assertions.assertTrue(TestHelper.checkFullname(person.getFullName()));
    }

    @Test
    @DisplayName("Проверка возраста")
    public void testBirthday(){
        Assertions.assertTrue(TestHelper.checkBirthdate(person.getBirthDate(), 102));
    }
}
