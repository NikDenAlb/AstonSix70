package Stage1.six.trainer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Привет, мир!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
} 