package java_nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*try {
            FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFountException" + e.getMessage());
            e.printStackTrace();
        }*/

        try {
            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            //the line below allows to write
            List<String> lines = Files.readAllLines(dataPath);
            //lines 22 and 25 are for reading
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
