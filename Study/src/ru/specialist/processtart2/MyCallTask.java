package ru.specialist.processtart2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallTask implements Callable<Long> {

    @Override
    public Long call() throws Exception {

        System.out.println(Thread.currentThread().getName());

        long summa = 0;
        for (long i = 0; i <= 100000000L; i++) {
            if (Thread.interrupted()) {
                return -1L;
            } else {
                summa += i;
            }
        }
        System.out.println("Finished " + Thread.currentThread().getName());
        return summa;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ExecutorService pool = Executors.newSingleThreadExecutor();
        //  ExecutorService pool = Executors.newFixedThreadPool(5);
        ExecutorService pool = Executors.newCachedThreadPool(r->{
            Thread t = new Thread (r);
            t.setPriority(Thread.MAX_PRIORITY);
            t.setDaemon(true);
            return t;
        });

        long t1 = System.currentTimeMillis();
        Future[] tasks = new Future[10];
        for (int i = 0; i < 10; i++) {
            tasks[i] = pool.submit(new MyCallTask()); // создание 10 задач и отправка их в пул
        }
        //    Thread.sleep(3000);
        //     pool.shutdownNow();
        System.out.println(tasks[0].cancel(false));

        //   Future<Long>t11 = pool.submit(new MyCallTask());
        //    Future<Long>t12 = pool.submit(new MyCallTask());     
        for (Future<?> t : tasks) {
            if (t.isCancelled()) {
                System.out.println("Cancelled");
            } else {
                System.out.println(t.get()); // аналог join, дожидается выполнения задач
            }
        }
        //   System.out.println(t11.get());
        //   System.out.println(t12.get());

        long t2 = System.currentTimeMillis();
        System.out.println("Time :" + (t2 - t1));

      //  pool.shutdown();
    }

}
