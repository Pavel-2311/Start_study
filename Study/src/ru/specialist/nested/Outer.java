
package ru.specialist.nested;

import java.util.Comparator;


public class Outer {
    
    public static class Nested {
    
        void increment (Outer o){
            o.data++;
        }
    }
     public  class Inner {
    
        void increment (){
            data++;
        }
    }
    
    private int data;

    public Outer(int data) {
        this.data = data;
        Nested n;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    Comparator<Integer> xc; //обьект локального класса можно использовать снаружи
    
    public boolean isGreater(int x){
        
        final int k = -1; //можно без final, но менять ее все равно нельзя

     /*   class MyComparator implements Comparator<Integer>{
            
            @Override
            public int compare(Integer a, Integer b){
                return a +k* b;
            }    }    
       // MyComparator c = new MyComparator();
       Comparator<Integer> c = new MyComparator();*/// описание класса и создание обьекта
       
       Comparator<Integer> c = new  Comparator<Integer>() // создается анонимный (без имени)класс
       {
                  // тут же создается обьект в ссылку помещается переменная  интерфейса                              
            public int compare(Integer a, Integer b){
                return a +k* b;}
       };
               
                //  xc = c;
               return c.compare(data, x) > 0;
    }}
     
     
    
    
    

