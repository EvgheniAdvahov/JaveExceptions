package ExceptionHW3;

import Lesson3.MyException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReadFile {

    public void readWrite() throws MyException {
        try (FileWriter writer = new FileWriter("NewTestFile"))
        {

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new MyException("My message exception", e);
        }
    }

}
