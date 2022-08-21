package ru.specialist.processtart2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyThread3 extends Thread {

    private static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            while (!lock.tryLock(1,TimeUnit.NANOSECONDS)) 
                System.out.println("Waiting...");
            
            try {
                for (int i = 0; i <= 100; i++) 
                    System.out.println(this.getName() + " " + i);
                
            } finally {
                lock.unlock();
            }
         
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
        
        Thread t1 = new MyThread3();
        Thread t2 = new MyThread3();
        Thread t3 = new MyThread3();
        Thread t4 = new MyThread3();
        
        
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        
    }
}
