
package Lesson150522;


public class NewClass {
    
    public static void main(String[] args) {
        
        Singleton s1 = Singleton.getInstance();
	Singleton s2 = Singleton.getInstance();	
	if(s1==s2) System.out.println("ok");
        
    }
    
}
