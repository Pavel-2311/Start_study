package ru.specialist.processtart2;

public class Lab1 implements Runnable {

    private int a, b;

    public Lab1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = a; i <= b; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }}

    public static void main(String[] args) {

        Thread t0 = new Thread(new Lab1(1, 50));
        t0.start();

        Thread t1 = new Thread(new Lab1(51, 100));
        t1.start();

        final int a = 1;
        final int b = 50;
        final int a1 = 51;
        final int b1 = 100;

        Thread t2 = new Thread(() -> {
            for (int i = a; i <= b; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        t2.start();
        
              Thread t3 = new Thread(() -> {
            for (int i = a1; i <= b1; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        t3.start();

    }}

