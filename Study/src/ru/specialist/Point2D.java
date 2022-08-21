
package ru.specialist;


public class Point2D {
    
    private double x;
    private double y;
    
    private static int counter = 1;
    private final int id ;
    
  

    public Point2D() { // конструктор умолчаний
        this(0,0);
    }
    
    public Point2D(double x, double y){ // полный конструктор(все задает)
        this.x = x;
        this.y = y;
        id = counter++;
    }
    
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }
    
     public Point2D addTo(Point2D rValue){    
     return new Point2D(this.x+rValue.x,this.y + rValue.y);   
    }

    @Override
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ')';
    }
    
    
    
    
}
