
package ru.specialist.func;

import java.util.ArrayList;
import java.util.Collections;


public class ProgFunc2 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(-2);
        nums.add(1);
        
            for (Integer num : nums) {// одно и тоже 1
            System.out.println(num);
        }
            
        nums.stream().forEach(x->System.out.println(x)); // одно и тоже 1
        nums.stream().forEach(System.out::println); // одно и тоже 1
        
        for (Integer num : nums) {
            if(num > 0)
            System.out.println(num);} //тоже самое 2
        
     nums.stream().filter(x->x>0).forEach(System.out::println); //тоже самое 2
    
        ArrayList<Integer> result = new ArrayList<>(); // тоже самое 3
         for (int k : nums) 
            if(k > 0)
                result.add(k);
         
             Collections.sort(result);
             for (int k : result) 
                 System.out.println(k);
             
              nums.stream().filter(x->x>0). // тоже самое 3
              sorted().forEach(System.out::println);
             
               nums.parallelStream().filter(x->x>0). // распараллелевание выполнения задач
              sequential().sorted().forEach(System.out::println);
              
}
    }
    

