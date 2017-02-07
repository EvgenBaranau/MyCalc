import java.util.List;

/**
 * Created by Администратор on 06.02.2017.
 */
public class SimpleCalculatorWithMemory extends SimpleCalculator implements Memory {

    private StorageCell cell = new StorageCell();

    @Override
    public void clear() {
        cell.setValue(0);
    }

    @Override
    public void inputValue(double value) {
        cell.setValue(value);

    }

    @Override
    public double increaseValue(double value) {
        cell.setValue(cell.getValue()+value);
        return cell.getValue();
    }

    @Override
    public double reduceValue(double value) {
        cell.setValue(cell.getValue()-value);
        return cell.getValue();
    }

    @Override
    public double getValue() {
        return cell.getValue();
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
                case "m+":
                    increaseValue(result);
                    break;
                case "mc":
                    clear();
                    break;
                case "m-":
                    reduceValue(result);
                    break;
                case "mr":
                    result = getValue();
                    break;
                case "m":
                    inputValue(result);
                    break;
                default:
                    result = Double.valueOf(list.get(i));
                    break;
            }
        }
        return result;
    }
}
