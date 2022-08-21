
package ru.specialist.col;

import java.util.HashSet;
import java.util.Set;


public class Test {
    
    private String data;

    public Test(String data) {
        super();
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public static void main(String[] args) {
        
        Set<Test> set = new HashSet<Test>();
        
        set.add(new Test("one")); // чтобы здесь правильно работало надо переопределить
        set.add(new Test("two"));// методы equals и hashCode
        set.add(new Test("two"));
        
        System.out.println(set.size());
        for (Test t : set) {
            System.out.println(t.getData());  
        }
        
         Set<String> set1 = new HashSet<String>();
        
        set1.add("one");
        set1.add("two");
        set1.add("two");
        
        System.out.println(set1.size());
        for (String t : set1) {
            System.out.println(t);  
        }
        
    }
                
    
}
