import java.util.List;

/**
 * Created by Администратор on 06.02.2017.
 */
public class EngineerCalcWithMemory extends EngineerCalculator implements Memory { // инженерный с памятью

    private StorageCell cell = new StorageCell();

    @Override
    public void clear() {
        cell.setValue(0);
    } // очистка памяти

    @Override
    public void inputValue(double value) { // добавление в память текущего значения
        cell.setValue(value);

    }

    @Override
    public double increaseValue(double value) { // прибавляем текущее значение к значению в памяти
        cell.setValue(cell.getValue()+value);
        return cell.getValue();
    }

    @Override
    public double reduceValue(double value) { // отнимаем текущее значение от значения в памяти
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
                case "cos":
                    result = getCos(result);
                    break;
                case "exp":
                    result = getExp(result);
                    break;
                case "sqrt":
                    result = getSqrt(result);
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
