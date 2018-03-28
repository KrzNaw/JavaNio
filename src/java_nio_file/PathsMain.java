package java_nio_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsMain {
    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

//        Path filePath = FileSystems.getDefault().getPath("C:\\IdeaProjects\\JavaNio\\files\\SubDirectoryFile.txt");
        Path filePath = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");
        printFile(filePath);
        filePath = Paths.get("C:\\IdeaProjects\\JavaNio\\files\\SubDirectoryFile.txt");
        System.out.println("\nprint 2");
        printFile(filePath);
    }


    private static void printFile(Path path){
    try(BufferedReader fileReader = Files.newBufferedReader(path)){
        String line;
        while ((line = fileReader.readLine()) !=null){
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


}
