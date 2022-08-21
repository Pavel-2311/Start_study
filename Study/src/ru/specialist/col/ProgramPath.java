
package ru.specialist.col;

import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ProgramPath {
    
    public static final String fileName = "test1.txt";
    
    public static void main(String[] args) throws IOException {
        
        Files.readAllLines(Paths.get(".", fileName)).forEach(out::println); // чтение из файла в корне
        
        System.out.println();
        
        Path dir = Paths.get(".");
        Files.newDirectoryStream(dir).forEach(out::println);// список файлов и папок в корне
    }
    
}
