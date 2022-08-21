package ru.specialist.execpools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;

public class Integral { // класс реализующий площадь фигуры с параллельными потоками

    public static final int STEPS = 10000000;
    public static final int TASKS = 10;

    public static double singleThread(DoubleFunction<Double> f,
            double a, double b) {

        return singleThread(f, a, b, STEPS);
    }

    static double singleThread(DoubleFunction<Double> f,
            double a, double b, int steps) {

        double h = (a - b) / steps;
        double summa = 0d;

        for (int i = 0; i < steps; i++) {
            double x = a + h * i + h / 2; // алгоритм средних прямоугольников
            double y = f.apply(x);
            summa += y * h;
        }
        return summa;

    }

    public static double multiThread(DoubleFunction<Double> f,
            double a, double b) throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(TASKS);
        double hx = (b - a) / TASKS;
        Future<Double>[] tasks = new Future[TASKS];

        for (int i = 0; i < TASKS; i++) {
            final double ax = a + i * hx;
            final double bx = ax + hx;
            tasks[i]
                    = pool.submit(() -> Integral.singleThread(f, ax, bx, STEPS / TASKS));
        }
        double summa = 0d;
        for (Future<Double> t : tasks) {
            summa += t.get();
        }
        pool.shutdown();
        return summa;
    }

    public static double multiThread2(DoubleFunction<Double> f,
            double a, double b) throws InterruptedException, ExecutionException {

        double hx = (b - a) / TASKS;
        Thread[] threads = new Thread[TASKS];

        final DoubleAdder r = new DoubleAdder(); // для суммирования значений

        for (int i = 0; i < TASKS; i++) {
            final double ax = a + i * hx;
            final double bx = ax + hx;
            threads[i] = new Thread(() -> {
                double rx
                        = Integral.singleThread(f, ax, bx, STEPS / TASKS);
                r.add(rx);
            }); threads[i].start();
        }
     
        for (Thread t : threads) {
            t.join();
        }
       
        return r.sum();
}
  public static double multiThread3(DoubleFunction<Double> f,
            double a, double b)
  {
      class Pair{
          
          double a;
          double b;
          
          public Pair( double a, double b){
              this.a = a;
              this.b = b;
          }
      }
      double h = (b-a)/TASKS;
      List<Pair> ts = new ArrayList<Pair>();
              for(int i =0; i< TASKS; i++)
                  ts.add(new Pair(a+i*h , a+(i+1)*h));
             
              // был использован ForkJoinPool.commonPool();
              return
              ts.parallelStream().mapToDouble(p->singleThread(f, p.a, p.b, STEPS/TASKS)).sum();
              
  }
  


}