# ReadmeMD

### Задание 2

- Не был создан массив

try {

int d = 0;

int[] intArray = {

1, 2, 3, 4, 5, 6, 7, 8, 9};

double catchedRes1 = intArray[8] / d;

System.out.println("catchedRes1 = " + catchedRes1);

}   catch (ArithmeticException e) {

System.out.println("Catching exception: " + e);

},

### Задание 3

1. throws Exception в main - не вижу смысла на нём,

так как ошибки, которые могут возникнуть - unchecked.

1. Обращаемся к элементу который находится вне массива abc[3] = 9;
2. Throwable ex ловит все ошибки и исключения - лучше прописать в последнем catch
3. throws FileNotFoundException - нам не нужен в этом методе.

public static void main(String[] args) {

try {

int a = 90;

int b = 3;

System.out.println(a / b);

printSum(23, 234);

int[] abc = { 1, 2 };

abc[1] = 9;

} catch (NullPointerException ex) {

System.out.println("Указатель не может указывать на null!");

} catch (IndexOutOfBoundsException ex) {

System.out.println("Массив выходит за пределы своего размера!");

}catch (Throwable ex) {

System.out.println("Что-то пошло не так...");

}

}

public static void printSum(Integer a, Integer b) {

System.out.println(a + b);

}

}