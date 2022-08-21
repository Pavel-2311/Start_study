
package ru.specialist.resourses;

import java.io.*;

public class DBConnection implements Closeable{

    public DBConnection() {
        System.out.println("Open connection...");
    }
    public void execute(){
        System.out.println("Execute command...");
    }
    private boolean isClosed = false;
    
    @Override
    public void close() {
        if(!isClosed){
            System.out.println("close connection");
            isClosed = true;
        }}
    
    
    
}
