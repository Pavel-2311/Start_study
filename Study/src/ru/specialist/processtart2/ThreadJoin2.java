
package ru.specialist.processtart2;



public class ThreadJoin2 {
    
     public static void main(String[] args) throws InterruptedException {

        Thread t0 = new Thread(
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }, "T0");
        Thread t1 = new Thread(
                () -> { 
            try {
                while (t0.getState() == Thread.State.NEW) // условия для потока t0:если он new 
                    // передать управление потоку t1
                    Thread.yield();
                t0.join(); //сделали чтобы последовательно работали потоки
                // join() работает только для запущеного потока (runnable)на new не сработает
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }, "T1");
        
        t1.start();
        Thread.sleep(100);
        t0.start();// если закоментить будет deadlock
        
        t0.join(); // текущий поток (main) переводится в сост ожидания до конца выполнения потока t0
        t1.join();
        
        System.out.println(Thread.currentThread().getName());
        
      // Thread.currentThread().join();тоже deadlock (ожидание при котором никто никого не дождется
    }

    
}
