package ExceptionHW3;

public class MyStringYearException extends RuntimeException {
    public MyStringYearException(int num) {
        super("Ввели " + num + " Год не может быть больше 2023");
    }
}
