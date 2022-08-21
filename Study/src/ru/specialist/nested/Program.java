
package ru.specialist.nested;


public class Program {
    
    public static void main(String[] args) {
     /*   Outer.Nested n = new Outer.Nested();
        Outer o = new Outer(10);
        
        Outer.Inner i1 = o.new Inner();
        Outer.Inner i2 = o.new Inner();
        
        i1.increment();
        i2.increment();
        
      //  n.increment(o);
        System.out.println(o.getData());*/
     
     Invoice inv = new Invoice("Рога&Копыта");
    // inv.new Line("Рога", 10, 100);
       inv.addLine("Рога", 10, 100);
       inv.addLine("Копыта", 20, 40);
    
   //  Invoice.Line l2 = inv.new Line("Копыта", 20, 40); 
       Invoice.Line l2 = inv.addLine("Копыта", 20, 40); 
       l2.setPrice(30);
        System.out.println(inv);
        
    }
    
}
