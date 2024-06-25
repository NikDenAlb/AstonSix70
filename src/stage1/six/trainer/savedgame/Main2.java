package stage1.six.trainer.savedgame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGame savedGame = (SavedGame) objectInputStream.readObject();

        System.out.println(savedGame);
    }
}