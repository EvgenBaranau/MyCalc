/**
 * Created by Администратор on 06.02.2017.
 */
public interface Memory {

    void clear(); // очистка памяти
    void inputValue(double value); // добавление в память
    double increaseValue(double value); // увеличение значения в памяти
    double reduceValue(double value); // уменьшение значения в памяти
    double getValue(); // вернуть значение из памяти

}
