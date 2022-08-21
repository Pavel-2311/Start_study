
package ru.specialist.procstart;

class MyThread extends Thread{

/*   @Override
    public void run() {
       for(int i=1; i<=50;i++){
           System.out.printf("%s : %d \n", getName(),i);
       }
    }}

class MySuperThread implements Runnable{

    public void run() {
       for(int i=1; i<=50;i++){
           System.out.printf("%s : %d \n",Thread.currentThread().getName(),i);
       }
    
}}

public class ThreadStart {
    
    public static void main(String[] args) {
        
    
        System.out.println(Thread.currentThread().getName());
        
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        
        Thread t3 = new Thread(new MySuperThread());
        
        Thread t4 = new Thread(new Runnable(){
            @Override
            public void run() {
            for(int i=1; i<=50;i++){
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }}
        });
        
          Thread t5 = new Thread(()->{          
            for(int i=1; i<=50;i++){
           System.out.printf("%s : %d \n", Thread.currentThread().getName(),i);    
            }
        });
        
        mt1.setPriority(Thread.MAX_PRIORITY);
          
        mt1.start(); // запуск отдельного потока созданного в методе run
        mt2.start();
        t3.start();
        
        System.out.println(Thread.currentThread().getState());
        
        t4.setDaemon(true);
        t5.setDaemon(true);
        
        t4.start();
        t5.start();
    }*/
    
}
