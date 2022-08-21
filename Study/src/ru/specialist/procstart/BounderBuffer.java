
package ru.specialist.procstart;
/*задача  в которой массив заполняется событиями из потоков. Если массив пустой, поток ждет 
пока в массиве что-то появится, чтобы взять.Если массив заполнен, поток ждет пока другой поток 
возмет из него и можно будет положить свое.*/
import java.util.concurrent.locks.Condition; //класс вложен в ReentrantLock
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BounderBuffer {
    
    final Lock lock = new ReentrantLock(); //блокировка одна
    final Condition notFull = lock.newCondition(); // а условий два
    final Condition notEmpty = lock.newCondition();
    
    final Object[]items = new Object[100];
    int putptr, takeptr, count;
    
    public void put(Object x){
        lock.lock();
        
        try{
            while(count == items.length)
                notFull.await();
            items[putptr] = x;
            if(++putptr==items.length)
                putptr = 0;
            ++count;
            notEmpty.signal();
            System.out.printf("Thread %s has put a signal data: %s\n",
                    Thread.currentThread().getName(), x);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
          System.out.printf("Thread %s unlock\n",
                    Thread.currentThread().getName());  
          lock.unlock();
        }
    }
        public Object take(){
        lock.lock();
        
        try{
            while(count == 0){
              System.out.printf("Thread %s take waiting..\n",
                    Thread.currentThread().getName());              
                notEmpty.await();}
        System.out.printf("Thread %s is going to take data\n",
                    Thread.currentThread().getName()); 
        
            Object x =items[takeptr];
            
            if(++takeptr==items.length)
                takeptr = 0;
            --count;
            notFull.signal();
            return x;
        }
        catch(InterruptedException e){
            e.printStackTrace();
            return null;
        }
        finally{
           
          lock.unlock();
        }
    
        } 
        
        public static void main(String[] args) throws InterruptedException {
        BounderBuffer buf = new BounderBuffer();
        
        Thread t0 = new Thread(
                () -> {                 
                        System.out.println("Thread has taken data: " +
                                Thread.currentThread().getName()+ " "+ buf.take());                   
                }, "T0");
        t0.start();
        
        Thread.sleep(100);
        
         Thread t1 = new Thread(
                () -> {                 
                        buf.put("my string");
                }, "T1");
         t1.start();
        
    }
}
