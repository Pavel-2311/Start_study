package ru.specialist.processtart2;

import java.util.concurrent.atomic.AtomicInteger;

class Sync {

    private volatile int counter = 0;

    public synchronized void increment() { // чтобы не писать synchronized в каждом потоке
        // напишем только в сигнатуре метода
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}

public class ThreadDataSync {

    public static void main(String[] args) throws InterruptedException {

        Sync sync = new Sync();
        
        AtomicInteger ai = new AtomicInteger(0);

        Thread t0 = new Thread(
                () -> {
                    for (int i = 0; i <= 10000; i++) {
                        //    System.out.println(Thread.currentThread().getName() + " " + i);
                   //     synchronized (sync) { //когда работает этот synchronized 
                            //другой поток t1 заблокирован
                            sync.increment();
                            ai.getAndIncrement();
                        } // действия в операторе synchronized выполняются последовательно
                        // то в одном потоке, то в другом и т.д а не сразу все
                        //synchronized использует монитор обьекта sync , а не сам обьект. 
                        //вот они его перехватывают друг у друга.
                 //   }
                }, "T0");

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i <= 10000; i++) {
                        //    System.out.println(Thread.currentThread().getName() + " " + i);
                      //  synchronized (sync) {
                            sync.increment();
                            ai.incrementAndGet();
                        //}
                    }
                }, "T1");

        t0.start();
        t1.start();

        t0.join();
        t1.join();

        System.out.println(sync.getCounter());
        System.out.println(ai.get());

    }

}
