
package hacker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Test {
   


List<Integer> arr = Stream.of(-1, 0, 5, 2, 15,-7,0, 5,-3, 24).collect(Collectors.toList());
List <Integer>arr1 = List.of(-1,0,5,2,4);

    public static void plusMinus(List<Integer> arr) {
   
      
       float rat1;
       float rat2;
       float rat3;
       int count = 0 ; 
       int count2 = 0 ; 
       int count3 = 0; 
       
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0)
                count ++;        
                
              if (arr.get(i) < 0){               
                count2 ++;        
                  }
            if (arr.get(i) == 0){
                count3 ++;        
                }
    
    // Write your code here

    }
        System.out.printf("%4f \n", rat1 = (float)count/arr.size());
    System.out.printf("%4f \n",rat2 = (float)count2/arr.size());
    System.out.printf( "%4f \n",rat3 = (float)count3/arr.size());
    }
        
            public static void main(String[] args) throws IOException {
           Test t = new Test();      
                
     /*   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/

        t.plusMinus(t.arr);

    //    bufferedReader.close();
    }//

   
}



