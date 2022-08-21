package ru.specialist.processtart2;

class MyThread extends Thread { // первый вариант создания потока

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.interrupted()) { // для завершения потока 1
                System.out.println("Interrupting " + this.getName());
                return;
            }
            System.out.println(this.getName() + " " + i);
        }
    }
}

class MySuperThread implements Runnable { // второй вариант создания потока

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}

public class AppThread2 {

    public static void main(String[] args) {
        Thread t0 = new MyThread();// первый способ
        Thread t1 = new MyThread();// первый способ
        Thread t2 = new Thread(new MySuperThread(),
                "My Thread for t2");// второй способ с заданием имени потока

        Thread t3 = new Thread( // третий метод
                new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });

        Thread t4 = new Thread( // четвертый метод
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                });

        t0.setPriority(Thread.MAX_PRIORITY); //установка приоритета
        t2.setDaemon(true);

        t0.start(); // запускает код метода run в отдельном потоке
        t1.start();
        t2.start();
        t3.start();
        //   t4.start();

        t1.interrupt(); //для завершения потока 1
        System.out.println("Alive thread for t3: " + t3.isAlive());
        System.out.println("State for t3: " + t3.getState()); //состояние потока

        System.out.println(Thread.currentThread().getName());
    }
}
