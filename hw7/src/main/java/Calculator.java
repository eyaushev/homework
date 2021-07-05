public class Calculator {

    public double sum(double x, double y){
        return x + y;
    }

    public double minus(double x, double y){
        return x - y;
    }

    public double multiply(double x, double y){
        return x * y;
    }

    public int divide(int x, int y){
        if (y == 0)
            throw new ArithmeticException("На ноль делить нельзя!");
        return x/y;
    }
}
