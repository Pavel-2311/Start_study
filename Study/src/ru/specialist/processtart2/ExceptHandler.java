package ru.specialist.processtart2;

public class ExceptHandler {

    public static void test(int k) {
        try {
            if (k < 0) {
                throw new RuntimeException("k < 0");
            }
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            public void run() {
                System.out.println("Sleeping... ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                }
                System.out.printf("Throwing exception thread %s \n", this.getName());
                throw new RuntimeException();
            }
        };

        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.printf("UncaughtException from thread %s handled by thread %s"
                     + "(specific) : %s \n", th.getName(), Thread.currentThread().getName(), ex);
            }
        };
        t.setUncaughtExceptionHandler(h); // это специальный обработчик

        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.printf("UncaughtException from thread %s handled by thread %s"
                     + "(unspecific) : %s \n", th.getName(), Thread.currentThread().getName(), ex);
            }
        }); // этот автоматом всё ловит

        t.start();
        
        Thread.sleep(2000);
        System.out.println("main");
        
      //  test(-5);
    }
}
