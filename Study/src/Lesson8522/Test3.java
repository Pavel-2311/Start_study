
package Lesson8522;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int [] m = {1,2,3,4,5};
        
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("array.txt")));
        
        for (int i : m) {
            dos.writeInt(i);   
        }
        dos.close();
    }
    
}
