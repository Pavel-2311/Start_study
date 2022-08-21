
package ru.specialist.execpools;

import java.util.concurrent.ExecutionException;


public class ProgIntegral {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        Integral.singleThread(Math::sin, 0d, Math.PI/2);
        Integral.singleThread(Math::sin, 0d, Math.PI/2);
        
        long t1 = System.currentTimeMillis(); 
        double r1 = Integral.singleThread(Math::sin, 0d, Math.PI/2);
        long t2 = System.currentTimeMillis(); 
        
        System.out.println("Значение: "+ r1);
        System.out.println("Время вычисления: "+ (t2-t1));
        
        Integral.multiThread(Math::sin, 0d, Math.PI/2);
        Integral.multiThread(Math::sin, 0d, Math.PI/2);
        
        long t3 = System.currentTimeMillis(); 
        double r2 = Integral.multiThread(Math::sin, 0d, Math.PI/2);
        long t4 = System.currentTimeMillis(); 
        
        System.out.println("Значение: "+ r2);
        System.out.println("Время вычисления: "+ (t4-t3));
        
        long t5 = System.currentTimeMillis(); 
        double r3 = Integral.multiThread2(Math::sin, 0d, Math.PI/2);
        long t6 = System.currentTimeMillis(); 
        
        System.out.println("Значение: "+ r3);
        System.out.println("Время вычисления: "+ (t6-t5));
        
        long t7 = System.currentTimeMillis(); 
        double r4 = Integral.multiThread3(Math::sin, 0d, Math.PI/2);
        long t8 = System.currentTimeMillis(); 
        
        System.out.println("Значение: "+ r4);
        System.out.println("Время вычисления: "+ (t8-t7));
        
        
    }
    
}
