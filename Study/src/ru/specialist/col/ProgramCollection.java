
package ru.specialist.col;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;


public class ProgramCollection {
    
    public static boolean testString(String s){
     //   System.out.printf("%s : ", s);
       // System.out.print(s);
     //  System.out.print(" : ");
        
        Stack<Character>st = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch =='[')
                st.push(ch);
            if(ch == ')' || ch ==']'){
                if(st.size()==0) return false;
                char p = st.pop();
                if(!((p=='('&& ch==')')||(p=='['&& ch==']')))
                    return false;
            }
        }
        return st.size()==0;
    }
    

    public static void main(String[] args) {
        
        System.out.println(
        testString("([sdaf])adsfjk(s) d[()as()](sdf)"));
      
      /*  Map<String, Integer> persons = new Hashtable<String, Integer>();
        persons.put("Павел",45);
        persons.put("Марина",23);
        persons.put("Юля",31);
        persons.put("Александра",27);       
        persons.put("Алиса",10);
        
        System.out.println(persons.size());
        
        String name = "Александра";
        if(persons.containsKey(name)){
            int age = persons.get(name);
            System.out.printf("%s - %d \n", name, age);*/
        }
        
        
    }
    

