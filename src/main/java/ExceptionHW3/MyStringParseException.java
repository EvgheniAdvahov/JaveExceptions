package ExceptionHW3;

public class MyStringParseException extends NumberFormatException{
    public MyStringParseException(String str) {
        super("Невозможно преобразовать " + str + " в Integer");
    }
}
