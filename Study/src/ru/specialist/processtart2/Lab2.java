package ru.specialist.processtart2;

import static java.lang.Math.asin;
import static java.lang.Math.sin;

public class Lab2 {

    public static void main(String[] args) throws InterruptedException {

        class S {

            volatile double x = 1d;
            volatile boolean phase = true;
        }
        S s = new S();

        Thread t0 = new Thread(
                () -> {
                    for (int i = 0; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + sin(s.x));

                        synchronized (s) {
                            if (s.phase == true) {
                                s.x = Math.sin(s.x);
                                s.phase = false;
                                s.notify();
                            }
                            try {
                                s.wait();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }, "T0");

        Thread t1 = new Thread(
                () -> {

                    for (int i = 0; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + asin(s.x));

                        synchronized (s) {
                            if (s.phase == false) {
                                s.x = Math.asin(s.x);
                                s.phase = true;
                                s.notify();
                            }
                            try {
                                s.wait();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }, "T1");

        t0.start();
        t1.start();

    }
}
