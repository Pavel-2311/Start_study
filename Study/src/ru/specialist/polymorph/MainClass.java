
package ru.specialist.polymorph;

public class MainClass {
    public static void main(String[] args) {
        
        Shape [] shapes = { 
        new Rect(2 , 3 ,-1.4 ,0.8, "Rectangle0"),
        new Circle(10,2.1 , -2.6, "Circle0"),
        new Rect(1, 2, 0.9, -1, "Rectangle1")};
        
        for (Shape shape : shapes) {
            System.out.println(shape.area());  
        }
     
   /*     for (Shape shape : shapes) {
            if (shape instanceof Rect){
                Rect tmp = (Rect)shape;
                System.out.println(tmp.area());}
            else if(shape instanceof Circle){    
                Circle tmp = (Circle)shape;
                System.out.println(tmp.area());}
        }*/
        
    }
    
}
