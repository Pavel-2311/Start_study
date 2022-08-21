
package Lesson8522;

import java.util.Comparator;


public class Box implements Comparable<Box>{
    
    private int a,b,c;

    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    public int volume(){
        return a*b*c;
    }


    @Override
    public int compareTo(Box rValue) {
      return volume()-rValue.volume();   
}
    
    public static Comparator <Box> compareByA(){ //static обязательно
        return new Comparator<Box>() {// локальный анонимный класс
            @Override
            public int compare(Box b1, Box b2) {
                return b1.a-b2.a;
               
            }
        };
        
    }
}