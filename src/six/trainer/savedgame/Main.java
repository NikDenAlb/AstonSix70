package six.trainer.savedgame;

import java.io.*;

public class Main {

    public static void main2(String[] args) throws IOException {

        //создаем наш объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("save.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(savedGame);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGame savedGame = (SavedGame) objectInputStream.readObject();

        System.out.println(savedGame);
    }
}