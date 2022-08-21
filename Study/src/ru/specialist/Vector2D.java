
package ru.specialist;

public class Vector2D extends Point2D{
    
 
  
    public Vector2D() {
    }

    public Vector2D(double x, double y) {
        super(x, y);
    }

    public double vectorLenght(double x, double y){ // вычисление длины вектора
      double vl = Math.sqrt(x * x + y * y);
        System.out.println(vl);
        return  vl;   
    }
 
}
