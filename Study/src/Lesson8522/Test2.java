
package Lesson8522;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Test2 {
    
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
       
        BufferedReader reader = new BufferedReader (new InputStreamReader(
                new FileInputStream("hello.txt")));// с кодировкой cp1251
        
        String str = reader.readLine();
        System.out.println(str);
        reader.close();
    }

  
    
}
