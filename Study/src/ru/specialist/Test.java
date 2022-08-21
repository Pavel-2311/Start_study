
package ru.specialist;


public class Test {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Point2D p1= new Point2D();
        Point2D p2= new Point2D( 2.5 , 4.9);
//        System.out.println(" Counter = "+ Point2D.getCounter());
//        System.out.println(p1 + " " +p1.getId() );
//        
       
        p1.setX(-1.2);
        p1.setY(2.3);
//        System.out.println(p1);
//        System.out.println(p2);
//        
//        System.out.println(" Counter = "+ Point2D.getCounter());
//        System.out.println(p2 + " " +p2.getId() );
//        
        Point2D p3 = p1.addTo(p2);
        System.out.println(p3 + " "+ p3.getId());
      

//   Class.forName("ru.specialist.Point2D");
    }
}
