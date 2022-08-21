
package ru.specialist.procstart;


public class Main {
    
    public static void main(String[] args) throws InterruptedException
    { Thread t1 = new MyThread();
     Thread t2 = new MyThread();
     
     t1.start();
     t2.start();
     
     // привязка сущности обьекта к потоку, отвечает за это монитор
     //в докум-ции это описано как захват потоком монитора обьекта
     //когда монитор захвачен потоком, другой поток не может захватить этот же монитор
     //до тех пор, пока поток не освободит монитор это называется захват блокировки
        
    }
    
}
