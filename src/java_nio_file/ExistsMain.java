package java_nio_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class ExistsMain {
    public static void main(String[] args) {
        try {
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size of file1.txt in Dir1: " + size);
            System.out.println("It was last modified: " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size: " + attrs.size());
            System.out.println("last modified: " + attrs.lastModifiedTime());
            System.out.println("Is directy: " + attrs.isDirectory());
            System.out.println("Is regular file: " + attrs.isRegularFile());
            System.out.println("Creation time: " + attrs.creationTime());
            System.out.println("last access time: " + attrs.lastAccessTime());

/*

            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
            //Files.createFile(fileToCreate);
            //nie stworzy kolejnego pliku o tej samej nazwie

            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
            //Files.createDirectory(dirToCreate);
            //Path directoriesToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir4\\Dir5");
            Path directoriesToCreate = FileSystems.getDefault().getPath("Examples\\Dir2\\Dir4\\Dir5\\Dir6\\Dir7");
            Files.createDirectories(directoriesToCreate);
*/


/*

            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "file1_copy.txt");
            //Files.delete(fileToDelete);
            Files.deleteIfExists(fileToDelete);
            //deletes a file only if it exists

*/
/*

            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1_copy.txt");
            Path desitnationFolder = FileSystems.getDefault().getPath("Examples", "Dir1", "file1_copy.txt");
            Files.move(fileToMove, desitnationFolder);
*/

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1_copy.txt");
////            Files.copy(sourceFile, copyFile);
////            will thow an exception while next run because the copyfile exists
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}