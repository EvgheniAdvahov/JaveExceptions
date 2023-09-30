package ExceptionHW3;

import Lesson3.MyException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws MyException {
        List<String> myReadyList = new ArrayList<>(Arrays.asList("Имя ",
                "Фамилия ",
                "Отчество ",
                "Номер телефона: ",
                "Пол ",
                "Дата Рождения "));
        String[] myFinalArray = UserInput(myReadyList);
        String finalString = "";
        for (String data : myFinalArray) {
            finalString = finalString.concat("<" + data + ">");
        }
        writetoFile(finalString, myFinalArray[0]);
    }

    public static String[] UserInput(List<String> myList) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String[] myInputList;
        String str = "";
        Collections.shuffle(myList);
        for (String item : myList) {
            str = str.concat(item);
        }

        System.out.println("Пожалуйста введите данные разделённые пробелом: " + str);
        userInput = scanner.nextLine();
        myInputList = userInput.split(" ");
        scheckStringSize(myInputList, myList);
        String[] finalList = new String[6];

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals("Фамилия ")) {
                checkIfLetter(myInputList[i]);
                finalList[0] = myInputList[i];
            } else if (myList.get(i).equals("Имя ")) {
                checkIfLetter(myInputList[i]);
                finalList[1] = myInputList[i];
            } else if (myList.get(i).equals("Отчество ")) {
                checkIfLetter(myInputList[i]);
                finalList[2] = myInputList[i];
            } else if (myList.get(i).equals("Номер телефона: ")) {
                numberToInt(myInputList[i]);
                finalList[4] = myInputList[i];
            } else if (myList.get(i).equals("Пол ")) {
                checkGender(myInputList[i]);
                finalList[5] = myInputList[i];
            } else if (myList.get(i).equals("Дата Рождения ")) {
                checkDate(myInputList[i]);
                finalList[3] = myInputList[i];
            }
        }
        return finalList;
    }

    public static void checkIfLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                throw new MyStringCheckLetterException(str);
            }
        }
    }

    public static Integer numberToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new MyStringParseException(str);
        }
    }

    public static void checkGender(String str) {
        if (str.equals("f") || str.equals("m")) {
            ;
        } else {
            throw new MyStringGenderException(str);
        }
    }

    public static boolean checkDate(String str) {
        if (str.length() != 10) {
            throw new MyStringSizeException(str.length());
        } else if (str.charAt(2) != '.' && str.charAt(5) != '.') {
            throw new MyStringDelimeterException("Неправильный формат ввода. Дата, месяц и год должны быть разделены '.'");
        }
        String[] stringList = str.split("\\.");
        if (numberToInt(stringList[2]) > 2023) {
            throw new MyStringYearException(Integer.parseInt(stringList[2]));
        }
        return false;
    }

    public static void scheckStringSize(String[] list, List<String> myList) {
        if (list.length < myList.size()) {
            throw new MyStringLeghtException("Ввели меньше данных- " + list.length);
        } else if (list.length > myList.size()) {
            throw new MyStringLeghtException("Ввели больше данных- " + list.length);
        }
    }

    public static void writetoFile(String text, String name) {
        try {
            String s = "G:\\My Drive\\GeekBrains\\Java\\WorkingWithErrors\\WorkingWithErrors\\src\\main\\java\\ExceptionHW3\\";
            String strToFile = text;
            String path = s.concat(name);
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(strToFile + "\n");
            bufferedWriter.close();
            System.out.println("User " + name + " added");
        } catch (IOException e) {
            System.out.println("Exception!!");
            e.printStackTrace();
            e.getMessage();
        }
    }

}
