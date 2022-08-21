
package ru.specialist.procstart;

import java.util.concurrent.atomic.AtomicInteger;


public class SyncData {

    public static void main(String[] args) throws InterruptedException {
        
   class Sync{
       
       public volatile int counter = 0;
   }
   
   Sync s = new Sync();

        AtomicInteger c = new AtomicInteger(); // спец класс для производства атомарных операций
                                               // в потоках
        Thread ct1 = new Thread(()->{          
            for(int i=1; i<=10000;i++){
               c.incrementAndGet(); // метод сразу добавляет 1 и возвращет значение
          //      synchronized(s){ // synchronized надо писать во всех потоках, иначе не сработает
          //      s.counter = s.counter+1;}
                
         //  System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });

         Thread ct2 = new Thread(()->{              
            for(int i=1; i<=10000;i++){
                c.incrementAndGet();
                 synchronized(s){
                s.counter = s.counter+1;}
        //   System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
        
    ct1.start();     
    ct2.start();
    
    ct1.join();
    ct2.join();
    
        System.out.println(s.counter);
        System.out.println(c.get());
        
    }
    
}
