
package ru.specialist.procstart;


public class SincJoin {
    
    public static void main(String[] args) throws InterruptedException {
        
           Thread t0 = new Thread(()->{          
            for(int i=1; i<=100;i++){
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
       t0.start();
       
      // Thread.sleep(1000); задержка выполнения main на 1000 милисек.
      t0.join(); // main будет ждать пока не закончит выполняться t0
       
        System.out.println(Thread.currentThread().getName());
    }
    
}
