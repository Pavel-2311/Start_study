
package ru.specialist.generics;

enum Colors {Red, Green, Blue;

public static final Colors DEFAULT_COLOR = Colors.Green;

public String upperName (){
    return name().toUpperCase();
}

}


public class Program {
    
    public static <T extends Comparable <? super T>> boolean isGreater( T a, T b){ // метод generic
        
        return a.compareTo(b)>0;
    }
    public static void main(String[] args) {
        
        Colors c1 = Colors.Red;
        System.out.println(c1.name());
        System.out.println(c1.upperName());
        
        System.out.println(c1.ordinal()); // порядковый номер литерала в enum
        
        for (Colors c : Colors.values()) { // все литералы enum
            System.out.println(c);  
        }
        
        System.out.println(isGreater(5,3));
        System.out.println(isGreater(10.7, 8.2));
   //     System.out.println(isGreater("abc", "def"));
        
        ReadOnlyStorage r0 = new ReadOnlyStorage(10);//типизирован Comparable 
        //по умолчанию сырой тип
        // без ограничения по типу будет Object
        
  //      ReadOnlyStorage<Integer> r1 = new ReadOnlyStorage<Integer>(10);
  //      ReadOnlyStorage<Double> r2 = new ReadOnlyStorage<Double>(2.3);
  //      ReadOnlyStorage<?> r3 = new ReadOnlyStorage<String>("abc"); //? обозначает неизвестный тип
     //   ReadOnlyStorage<Program> r4 = new ReadOnlyStorage<Program>(new Program());
        // т.к. класс Program не реализует Comparable
  //      System.out.println(2*r1.getData());
  //      System.out.println(r2.getData());
   //     System.out.println(r3.getData());
      //  System.out.println(r4.getData());
    }
}
