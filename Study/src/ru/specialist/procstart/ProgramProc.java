
package ru.specialist.procstart;

import java.io.IOException;


public class ProgramProc {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Starting external app");
        
        Runtime.getRuntime().exec("explorer.exe");
        
    }
    
}
