import java.util.List;

/**
 * Created by Администратор on 06.02.2017.
 */
public class SimpleCalculator implements ICalculate {


    public double addition(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double multiplication(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        return x / y;
    }


    @Override
    public double calculate(List<String> list) {
        double result = 0;
        for (int i = 1; i < list.size(); i++) {
            switch (list.get(i)) {
                case "+":
                    result = addition(result, Double.valueOf(list.get(++i)));
                    break;
                case "-":
                    result = subtraction(result, Double.valueOf(list.get(++i)));
                    break;
                case "*":
                    result = multiplication(result, Double.valueOf(list.get(++i)));
                    break;
                case "/":
                    result = division(result, Double.valueOf(list.get(++i)));
                    break;
                default:
                    result = Double.valueOf(list.get(i));
                    break;
            }
        }
        return result;
    }
}
