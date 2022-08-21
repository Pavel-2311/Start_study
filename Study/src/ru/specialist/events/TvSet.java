
package ru.specialist.events;

public class TvSet implements ElectricityListener{
    
      @Override
    public void electricity(Object sourse) {
        System.out.println("Телевизор включился");
    }
    
    
}
