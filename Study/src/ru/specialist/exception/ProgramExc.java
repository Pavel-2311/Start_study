
package ru.specialist.exception;

public class ProgramExc {
    
    public static void test (String a, String b)
 //   throws MyException
    {
    
      try{
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);   
        
        if (n1<0 || n1>100){
         //   throw new IllegalArgumentException("n1 out of [0,100]");
            throw new MyException(" my exception", n1);
        }
        int n = n1/n2;
        System.out.println(n);}
      
      catch (NumberFormatException | ArithmeticException e ){
          System.out.println(e.getMessage());
          throw new RuntimeException("не число", e);
      }
    /*  catch (ArithmeticException ae){
          System.out.println("Деление на 0");
      }*/
     catch (MyException me){
           System.out.println(me.getMessage());
          // System.out.println(me.getInvalidData());
       }

        finally{
                System.out.println("finally");
                }
         System.out.println("Продолжение test");
    }
    
    public static void main(String[] args) {
       try{ 
        test("199", "3");}
        catch (ArithmeticException ae){
          System.out.println(ae.getMessage());
      }
      
       
        System.out.println("Продолжение main");
    }
    
}
