
package ru.specialist.polymorph;

public class Circle extends Shape{
    
    private int r;

    public Circle(int r, double x, double y, String name) {
        super(x, y, name);
        this.r = r;
    }

    @Override
    public String toString() {
        return super.toString()+"{" + "r=" + r + '}';
    }

    @Override
      public double area(){
        return Math.PI*r*r;
    }
  

  
    
    
}
