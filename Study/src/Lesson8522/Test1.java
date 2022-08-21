
package Lesson8522;

import java.io.FileWriter;
import java.io.IOException;


public class Test1 {
    
    public static void main(String[] args) {
        
       try  (FileWriter writer = new FileWriter("hello.txt")){
       writer.write("Привет"); // только в unicode 
       } //конструкция для 
       catch (IOException ex) {
           System.out.println("Exception : "+ ex.getMessage());}// самозакрывающегося файла
    }
}
