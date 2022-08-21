
package ru.specialist.procstart;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Interrupt {
    
    public static void main(String[] args) {
        
           Thread t0 = new Thread(()->{          
            for(int i=1; i<=100;i++){
                
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    System.out.printf("%s : interrupted from sleep\n",
                            Thread.currentThread().getName() );
                    return;
                }
                if (Thread.interrupted()){
                    System.out.printf("%s : interrupted \n",Thread.currentThread().getName() );
                    return;
                }               
                else
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
       t0.start();
       t0.interrupt();
        System.out.println("main");
    }
    
}
