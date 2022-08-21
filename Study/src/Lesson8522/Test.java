
package Lesson8522;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {
    public static void main(String[] args) {
        
        File file = new File("file.txt");
             //  File file = new File(".."+File.separator+"file.txt");  кроссплатформенное создание
             // файла.
        
        try {
       
            file.createNewFile();
         //  throw new IOException (" all is bad");
        } catch (IOException ex) {
            System.out.println("EXception: "+ ex.getMessage());
        }
      File dir = new File(".");
      File [] files = dir.listFiles(new FileFilter() { //возвращает список файлов из текущей
            @Override  //директории
            public boolean accept(File pathname) {
              return pathname.isFile();
            }
      });
      
        for (File f : files) {
            System.out.println(f.getName());
        }
        
        
        
        
        
    }
    
}
