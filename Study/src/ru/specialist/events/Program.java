
package ru.specialist.events;

// events аналог паттерна проектирования Observer

public class Program {
    
    public static void fireFighters (Object s){
        System.out.println("Пожарные приехали");
    }
     
    public static void main(String[] args) {
        
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        TvSet tv = new TvSet();
        AirCondition ac = new AirCondition();
        
        sw.addElectricityListener(lamp);// это подписка на событие
        sw.addElectricityListener(tv);
        
        sw.addElectricityListener(e ->ac.on(e));//только потому что сигнатура метода с точностью
        sw.addElectricityListener(ac::on); // до имени (sourse) подходит
        
        sw.addElectricityListener(e ->Program.fireFighters(e));
        sw.addElectricityListener(Program::fireFighters);
        
        sw.addElectricityListener(new ElectricityListener(){ //анониный класс
           @Override
           public void electricity (Object e){   
               System.out.println("Пожар!");
           }
        });
        
     sw.addElectricityListener(
             e->System.out.println("Fire!")); //тоже что и выше , это лямбда
                                                          
        sw.switchOn();
       
    }}
    

