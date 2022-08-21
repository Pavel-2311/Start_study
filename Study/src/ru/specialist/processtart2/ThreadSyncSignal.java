package ru.specialist.processtart2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSyncSignal {

    public static void main(String[] args) throws InterruptedException {

        Lock l = new ReentrantLock();
        Condition greater50 = l.newCondition();
        Condition greater70 = l.newCondition();

        Thread t0 = new Thread(
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        l.lock();
                        try {
                            if (i == 50) {
                                greater50.signalAll();
                            }
                            if (i == 70) {
                                greater70.signalAll();
                            }
                        } finally {
                            l.unlock();
                        }
                    }
                }, "T0");

        Thread t1 = new Thread(
                () -> {
                    l.lock();
                    try {
                        greater50.awaitUninterruptibly();
                    } finally {
                        l.unlock();
                    }

                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }, "T1");

        Thread t2 = new Thread(
                () -> {
                    l.lock();
                    try {
                        greater70.awaitUninterruptibly();
                    } finally {
                        l.unlock();
                    }
                    for (int i = 0; i <= 100; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }, "T2");

        t0.start();
        t1.start();
        t2.start();

    }
}
