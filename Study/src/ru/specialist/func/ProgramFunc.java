
package ru.specialist.func;

import java.util.ArrayList;
import java.util.Collections;


public class ProgramFunc {
    
    public static void main(String[] args) {
        
        ArrayList<PersonFunc> persons = new ArrayList<PersonFunc>();
        persons.add(new PersonFunc("Павел", 45));
        persons.add(new PersonFunc("Катя", 41));
        persons.add(new PersonFunc("Юля", 31));
        persons.add(new PersonFunc("Алиса", 11));
        
  /*      for (PersonFunc p : persons) {
            System.out.println(p);  
        }
        persons.stream().forEach(System.out::println);*/
        
      /*   for (PersonFunc p : persons) {
             if(p.age >=18)
            System.out.println(p);  }
        
        persons.stream().filter(p->p.age>=18).forEach(System.out::println);*/
      
       ArrayList<PersonFunc> result = new ArrayList<>();// тоже самое
        for (PersonFunc p : persons) {
          if(p.age >=18)
              result.add(p);
        }
      Collections.sort(result, (p1,p2)->p1.name.compareTo(p2.name));
        for (PersonFunc p : result) {
            System.out.println(p);
           
        }
         System.out.println();
         
         
     persons.parallelStream().
             filter(p->p.age>=18). //тоже самое
             sequential().
             sorted((p1,p2)->p1.name.compareTo(p2.name)).
             map(p->p.name).
             forEach(System.out::println);   
        
    
    
    }  
}
