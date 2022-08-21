
package ru.specialist.procstart;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CounterThread implements Runnable{
    
    private int a, b;

    public CounterThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
          for(int i=a; i<=b;i++){
           System.out.printf("%s : %d \n",Thread.currentThread().getName(),i);
       }
       
    }
    public static void main(String[] args) {
        
 //   Thread ct1 = new Thread(new CounterThread(100, 130));
 //   ct1.start();
    
    final int a = 0;
    final int b = 50;
    final int a1 = 51;
    final int b1 = 100;
    
    
         Thread ct2 = new Thread(()->{          
            for(int i=a; i<=b;i++){
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
    ct2.start();
     
         Thread ct3 = new Thread(()->{        
        try {
            ct2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(CounterThread.class.getName()).log(Level.SEVERE, null, ex);
        }
            for(int i=a1; i<=b1;i++){
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
    ct3.start();
    
 
    }
    
}
