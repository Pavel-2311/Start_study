
package Lesson8522;

import java.util.ArrayList;


public class Collect {
    
    public static void main(String[] args) {
        
        ArrayList<Number> list = new ArrayList<>();
        list.add(10); // wrapper Integer т.к. в ArrayList можно добавлять только обьекты
        list.add(.7);
     //   list.add ("Hello");
     //   list.add(new Object());
     list.add(101);
     list.get(0);
     
     // ArrayList<ArrayList<String>> двумерная коллекция строк
     
        for (Number number : list) {
            System.out.println(number);
        }
        // ArrayList <? extends Comparable<T>> параметризация для сравнения обьектов
        
        
    }
    
}
