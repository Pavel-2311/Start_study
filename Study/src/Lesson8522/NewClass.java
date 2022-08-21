
package Lesson8522;

import java.util.Arrays;

public class NewClass {
    
    public static void main(String[] args) {
        
        Box [] boxes = {
            new Box(10,1,1),
            new Box(2,2,2),
            new Box (1,10,10)        
        };
        
        Arrays.sort(boxes);
        for (Box box : boxes) {
            System.out.println(box);
        }
        
        Arrays.sort(boxes, Box.compareByA());
        for (Box box : boxes) {
           System.out.println(box); 
        }

    }
    
}
