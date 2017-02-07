import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.02.2017.
 */
public class CalculatorMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader("example.txt"))) // поток ввода
         {
            while (rd.ready()) {
                list.add(rd.readLine().trim().toLowerCase()); // добавляем в коллекцию выражение
            }

            System.out.println("Input data: ");
            System.out.println("Calculator: "+list.get(0));
            System.out.print("Task: ");
            for(int i = 1;i<list.size();i++)
            {
                System.out.print(list.get(i));
            }

            System.out.println();

            double result = CalculatorUtility.parseAndCalculate(list); // вычисляем


            System.out.println("Result: " + String.valueOf(result)); // выводим результат
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
