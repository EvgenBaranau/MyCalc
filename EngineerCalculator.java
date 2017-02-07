import java.util.List;

/**
 * Created by Администратор on 06.02.2017.
 */
public class EngineerCalculator extends SimpleCalculator implements ICalculate { // инженерный калькулятор

    public double getCos(double x) { // cos
        return Math.cos(x);
    }

    public double getExp(double x) {
        return Math.exp(x);
    } // exp

    public double getSqrt(double x) {
        return Math.sqrt(x);
    } // sqrt

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
                case "cos":
                    result = getCos(result);
                    break;
                case "exp":
                    result = getExp(result);
                    break;
                case "sqrt":
                    result = getSqrt(result);
                    break;
                default:
                    result = Double.valueOf(list.get(i));
                    break;
            }
        }
        return result;
    }
}
