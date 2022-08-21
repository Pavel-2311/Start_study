
package ru.specialist.integral;

import java.util.function.DoubleFunction;


public class ProgramIntegral {
    
    public static final int STEPS = 10000000;
    
    public static double integral(DoubleFunction<Double> /*MathFunction*/ f,
            double a, double b){
        
        double h = (b-a)/STEPS;
        double summa = 0d;
        
        for(int i = 0; i<= STEPS; i++){
            double x = a+i*h +h/2;
          //  double y = f.function(x);
                    //Math.sin(x);
              double y = f.apply(x);
            summa +=y*h;
            
        }
            return summa;
        
    }
    public static void main(String[] args) {
   /*     class SinFunc implements MathFunction{
          @Override
          public double function(double x) {
        return Math.sin(x);
    }
        }
        
        MathFunction f = new SinFunc();*/
        
   /*    double r1 = integral(new MathFunction(){
          public double function(double x) {
        return Math.sin(x);
    }},0,Math.PI/2);
*/        
       
     //  double r1 = integral( x -> Math.sin(x),0, Math.PI/2);
     
       long l1 = System.currentTimeMillis();
       double r1 = integral( Math::sin,0, Math.PI/2);
      System.out.println(r1);  
       long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
        
        
    }
}
