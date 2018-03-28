package directory_contents;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ReadingMain {
    public static void main(String[] args) {

        /*
        DirectoryStream.Filter<Path> filter =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path path) throws IOException {
                        return (Files.isRegularFile(path));
                    }
                };
*/
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        //Path directory = FileSystems.getDefault().getPath("Examples\\Dir2");
        Path directory = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

//        String separator = File.separator;
//        System.out.println(separator);
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);

        try{
            Path tempFile = Files.createTempFile("mojplik", ".jjd");
            System.out.println("Scieżka do mojego pliku: " + tempFile.toAbsolutePath());

        } catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores){
            System.out.println("Nazwa dysku i jego oznaczenie" + store);
            System.out.println("file store name: " + store.name());
        }

        System.out.println("+ + +");

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths){
            System.out.println(path);
        }

    }


}