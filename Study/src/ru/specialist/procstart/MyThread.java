
package ru.specialist.procstart;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyThread extends Thread {
    
 /*   private static Lock lock = new ReentrantLock();
    
    @ Override
    public void run(){
        try{
            while (!lock.tryLock(1,TimeUnit.MILLISECONDS))
                System.out.println("Waiting...");
            try{
                for(int i=1; i<=1000;i++)
                 System.out.printf("%s - %d\n", this.getName(),i);   
            }
            finally{
                lock.unlock();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
