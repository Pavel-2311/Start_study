package ru.specialist.processtart2;

public class ThreadSyncNotify {

    public static void main(String[] args) throws InterruptedException {

        class Sync {
            volatile int counter = 0;
        }

        Sync sync = new Sync();

        Thread t0 = new Thread(
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);

                        synchronized (sync) {
                            sync.counter = i;
                            sync.notify();
                        }
                    }
                }, "T0");
        Thread t1 = new Thread(
                () -> {
                    try {
                        synchronized (sync) {
                            while(sync.counter<70)
                            sync.wait();
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }, "T1");

        t0.start();
        Thread.sleep(300);
        t1.start();

    }

}
