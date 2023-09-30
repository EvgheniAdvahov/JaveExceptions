package ExceptionHW3;

public class MyStringCheckLetterException extends RuntimeException{
    public MyStringCheckLetterException(String str) {
        super("В " + str + " Могут быть только буквы!");
    }
}
