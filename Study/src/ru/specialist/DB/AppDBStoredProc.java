package ru.specialist.DB;

import java.sql.*;
import java.util.Scanner;

public class AppDBStoredProc {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_STRING
            = "jdbc:mysql://localhost:3306/web?user=root&password=demo";
    
     

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {

        Class.forName(DRIVER_NAME);
        
         System.out.println("Поиск: ");
	String search = new Scanner(System.in).nextLine();

        try ( Connection con = DriverManager.getConnection(CONNECTION_STRING)) {
            CallableStatement sp = con.prepareCall("call countCourses( ? )");
            sp.execute();
            
            int count = sp.getInt(1);
            System.out.println("Все курсов: " + count);
            
        }
}}
