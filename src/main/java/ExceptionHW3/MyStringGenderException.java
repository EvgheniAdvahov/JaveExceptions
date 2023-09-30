package ExceptionHW3;

public class MyStringGenderException extends RuntimeException{
    public MyStringGenderException(String str) {
        super(str + " Не правильно введён пол! Формат 'm' или 'f'");
    }
}
