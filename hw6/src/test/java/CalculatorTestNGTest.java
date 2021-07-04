import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorTestNGTest {
    @Test
    public void justTest(){
        System.out.println("MAVEN!");
        Assert.assertEquals(1, 1);
    }

}
