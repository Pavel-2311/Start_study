package ru.specialist.procstart;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncEvent {

    public static void main(String[] args) throws InterruptedException {

        class Sync {

            public int counter;
        }

        Sync s = new Sync();

        Thread ct1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.printf("%s : %d \n", Thread.currentThread().getName(), i);

                synchronized (s) {
                    s.counter = i;
                    s.notify(); // будит поток ct2
               //     s.notifyAll(); // разбудит все спящие потоки
                }
            }
        });

        Thread ct2 = new Thread(() -> {

            try {
                synchronized (s) {
                    while (s.counter<50)
                    s.wait();
                }// остановка этого потока до запуска метода notify()
            } catch (InterruptedException ex) {
                Logger.getLogger(SyncEvent.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            for (int i = 1; i <= 100; i++) {
                System.out.printf("%s : %d \n", Thread.currentThread().getName(), i);
            }
        });

        ct1.start();
      //  Thread.sleep(500); //задержка потока ct1 на 500 милисек
      
    //  Thread.currentThread().join();// deadlock первый поток ждет второй, а второй ждет первый
        ct2.start();

    }

}
