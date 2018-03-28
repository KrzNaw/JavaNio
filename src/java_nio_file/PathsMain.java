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
//        Path filePath = Paths.get(".", "files", "SubDirectoryFile.txt");
        Path filePath = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");
        printFile(filePath);
        String fileAddress = "C:\\IdeaProjects\\OutThere.txt";
        //filePath = Paths.get("C:\\IdeaProjects\\OutThere.txt");
        filePath = Paths.get(fileAddress);
        System.out.println("\nprint 2");
        printFile(filePath);

        System.out.println(filePath.toAbsolutePath());

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());
        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubDirectoryFile.txt");
        System.out.println("\nprin3\n");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        Path path3 = Paths.get("H:\\", "TestDirectory", "cokolwiek.txt");
        System.out.println(path3.toAbsolutePath());
        //pokazuje abolutną ścieżkę, ktorą stworzyłem do nieistniejącego pliku

        Path path4 = Paths.get("D:\\", "Jakikolwiek", "nieistniejącyPlik.txt");
        System.out.println(path4.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(filePath));
        //sprawdza czy dany plik istnieje i zwraca true or false

        System.out.println("Exists dla Path path4 = Paths.get(\"D:\\\\\", \"Jakikolwiek\", \"nieistniejącyPlik.txt\");"
                + Files.exists(path4));
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
