package ExceptionHW;

import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {
        inputString();

    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку ");
        String input = scanner.nextLine();
        if (input.equals("")) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        } else {
            inputString();
        }
        return input;
    }
}
