
package ru.specialist;


public class MainClass2 {
    
    public static void main(String[] args) {
        
        TestPair2 test = new TestPair2(0);
       
        
        test.setX(10);
        test.setY(20);
        
        System.out.println(test.getX()+ " " + test.getY());
    }
}
