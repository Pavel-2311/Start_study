
package ru.specialist.resourses;

import java.io.IOException;

public class ProgramRes {
    
    public static void main(String[] args) {
        
    /*    DBConnection db = new DBConnection();
        try{
        db.execute();}
        finally{
        db.close();}*/
    
    try(DBConnection db = new DBConnection();
            DBConnection db1 = new DBConnection()){ //try с ресурсами автоматически 
        db.execute(); // реализует Closeable и метод close() соотв.т.к. обьект 
    }// реализует интерфейс closeable
    
     DBConnection db2 = new DBConnection();
     try(db2){
         db2.execute();
     }
     }
       
    }
    

