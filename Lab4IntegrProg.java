package ru.specialist.processtart2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;


public class Lab4IntegrProg {

    public static final int STEPS = 10000000;
    public static final int TASKS = 10;

    public static double singleThread(DoubleFunction<Double> f,
            double a, double b, int steps) {

        double h = (b - a) / steps;
        double summa = 0d;

        for (int i = 0; i <= steps; i++) {
            double x = a + h * i + h / 2;
            double y = f.apply(x);
            summa += y * h;
        }
        return summa;
    }
     public static double multiThread(DoubleFunction<Double> f,
            double a, double b) {

       class Ab{
           double a;
           double b;

            public Ab(double a, double b) {
                this.a = a;
                this.b = b;
            }           
       }
       double h = (b-a)/TASKS;
       
       List<Ab> l = new ArrayList<Ab>();
       for(int i = 0; i < TASKS; i++)
        l.add(new Ab(a+i*h, a+ (i+1)*h));
       
       return l.parallelStream()
              .mapToDouble(pool -> {
                  System.out.println(Thread.currentThread().getName());
                  return singleThread(f, pool.a,pool.b,STEPS/TASKS);
                      }).sum();
       
     }

    public static void main(String[] args) {
        
    
        long t1 = System.currentTimeMillis();
        double r1 = singleThread(Math::sin, 0d, Math.PI / 2, STEPS);
        long t2 = System.currentTimeMillis();
        System.out.println("Single thread: " + r1 + " " + (t2 - t1));

       
        long t3 = System.currentTimeMillis();
        double r2 = Lab4IntegrProg.multiThread(Math::sin, 0d, Math.PI / 2);
        long t4 = System.currentTimeMillis();
        System.out.println("Multi thread: " + r2+ " " + (t4 - t3));

       
    }
}
