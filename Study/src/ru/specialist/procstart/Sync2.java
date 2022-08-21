
package ru.specialist.procstart;


public class Sync2 {
    
      private volatile int counter = 0;
    
    public synchronized void increment(){       
        counter++;
    }
    public int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        Sync2 s = new Sync2();
        
        
        Thread ct1 = new Thread(()->{          
            for(int i=1; i<=10000;i++){        
                s.increment();
                
         //  System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });

         Thread ct2 = new Thread(()->{              
            for(int i=1; i<=10000;i++){
              s.increment(); 
        //   System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
        
    ct1.start();     
    ct2.start();
    
    ct1.join();
    ct2.join();
    
        System.out.println(s.getCounter());
        
    }
}
