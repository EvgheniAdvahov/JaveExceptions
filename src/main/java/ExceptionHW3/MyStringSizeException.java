package ExceptionHW3;

public class MyStringSizeException extends RuntimeException{
    public MyStringSizeException(){
        super();
    }

    public MyStringSizeException(int n){
        super("Ввели "+ n + " cимволов в Дате Рождения. Должно быть 10 символов");
    }

}
