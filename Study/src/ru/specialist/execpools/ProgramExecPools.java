
package ru.specialist.execpools;

import java.util.concurrent.*;

public class ProgramExecPools {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService pool = Executors.newWorkStealingPool(Runtime.getRuntime()
                .availableProcessors()); // степень распараллелливания потоков равна кол-ву 
        // ядер процессора, которое видит jvm
        
        //newCachedThreadPool();
        //newFixedThreadPool();
        //newSingleThreadExecutor();
        
        long t1 = System.currentTimeMillis();
        
        Future [] tasks = new Future [10];
        
        for (int i=0; i< 10; i++) // расчет 10 потоков
        tasks [i] = pool.submit(new MyCallTask());
        
      //  Thread.sleep(70000); //задержка для выполнения 2 оставшихся задач
      
     // pool.shutdownNow();
     tasks[9].cancel(true);
        
        Future<Long> t11 = pool.submit(new MyCallTask());
        Future<Long> t12 = pool.submit(new MyCallTask());
        
        for (Future <?> t : tasks) {
            
            if (t.isCancelled())
                System.out.println("Задача была отменена");
            else 
            System.out.println( t.get());}
        
       System.out.println( t11.get());
       System.out.println( t12.get());
       
        long t2 = System.currentTimeMillis();
        
              
        System.out.println("Время в милисекундах : " + (t2-t1));
        
        pool.shutdown();
        
        
        
    }
    
}
