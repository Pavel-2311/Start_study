
package Lesson150522;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Test {
    
    public static void main(String[] args) {
        
        Calendar sys = Calendar.getInstance();
       // System.out.println(sys.get(Calendar.DAY_OF_WEEK));
        System.out.printf("%1$tY %1$td %1$tB\n", sys);
        
      Date d = sys.getTime();
      DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, 
              new Locale("ru", "RU"));
        System.out.println(df.format(d));
        
    }
}
