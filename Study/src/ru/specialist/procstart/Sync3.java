
package ru.specialist.procstart;


public class Sync3 {// класс реализует два потока, работающие в противофазе
    // один считает синус, другой арксинус
    public static void main(String[] args) {
        
        class Sync{
            volatile double x = 1d;
            volatile boolean isSin = true;
        }
        Sync s = new Sync();
    
        Thread t1 = new Thread(()->{          
            for(int i=0; i<10;i++){        
                synchronized (s){
                    while(!s.isSin)
                        try{
                            s.wait();
                        }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    s.x = Math.sin(s.x);
                    System.out.println(s.x);
                    s.isSin = false;
                    s.notify();
                } 
            }
        });
              Thread t2 = new Thread(()->{          
            for(int i=0; i<10;i++){        
                synchronized (s){
                    while(s.isSin)
                        try{
                            s.wait();
                        }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    s.x = Math.asin(s.x);
                    System.out.println(s.x);
                    s.isSin = true;
                    s.notify();
                } 
            }
        });
        t1.start();
        t2.start();
        
    }
    
}
