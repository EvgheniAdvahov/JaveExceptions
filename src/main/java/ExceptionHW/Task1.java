package ExceptionHW;

import java.util.Scanner;
import static java.lang.Float.*;

public class Task1 {
    public static void main(String[] args) {
        inputNumber();

    }

    public static String inputNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        String input = scanner.nextLine();
        try {
            System.out.println("Пользователь ввёл: " + parseFloat(input));
        }catch (NumberFormatException e){
            System.out.println("Неправильный ввод ");
            inputNumber();
        }


        return input;
    }
}

