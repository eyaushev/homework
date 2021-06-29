import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Тестирование калькулятора")
public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    @Tag("sum")
    @DisplayName("Проверка суммирования")
    public void testSum(){
        double result = calculator.sum(1,2);
        Assertions.assertEquals(3, result);
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @Tag("minus")
    @DisplayName("Проверка вычитания")
    public void testMinus(){
        double result = calculator.minus(4,2);
        Assertions.assertEquals(2, result);
    }

    @Tag("multiply")
    @DisplayName("Проверка умножения")
    @ParameterizedTest(name = "{displayName} на {arguments}")
    @ValueSource(doubles = {0,1,2,3})
    public void testMultiply(double argument){
        double result = calculator.multiply(argument,argument);
        Assertions.assertEquals(argument * argument, result);
    }

    @Tag("divide")
    @DisplayName("Проверка деления")
    @ParameterizedTest(name = "{displayName} на {arguments}")
    @ValueSource(doubles = {0,1,2,3})
    public void testDivide(double argument){
        double result = calculator.divide(argument,argument);
        Assertions.assertEquals(argument/argument, result);
    }
}
