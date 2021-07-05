import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestNG {

    Calculator calculator = new Calculator();

    @Test(description = "Проверка сложения", groups = "sum")
    public void testSum(){
        double result = calculator.sum(1,2);
        Assert.assertEquals(result, 3);
    }

    @Test(description = "Проверка вычитания", groups = "minus", invocationCount=10)
    public void testMinus(){
        double result = calculator.minus(4,2);
        Assert.assertEquals(result, 2);
    }

    @Test(description = "Проверка умножения", groups = "multiply", dataProvider = "multiplyArguments")
    public void testMultiply(double argument1, double argument2, double expResult){
        double result = calculator.multiply(argument1,argument2);
        System.out.println(result);
        Assert.assertEquals(result, expResult);
    }

    @Test(description = "Проверка деления", groups = "divide", dataProvider = "divideArguments")
    public void testDivide(int argument1, int argument2, int expResult) {
        try {
            double result = calculator.divide(argument1,argument2);
            Assert.assertEquals(result, expResult);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    @DataProvider(name = "multiplyArguments")
    public Object[][] multyplyData(){
        return new Object[][]{{0, 1, 0},{1, 2, 2},{2, 3, 6},{3, -4, -12}};
    }

    @DataProvider(name = "divideArguments")
    public Object[][] divideData(){
        return new Object[][]{{1, 0, 0},{1, 1, 1},{6, 3, 2},{10, -2, -5}};
    }

}