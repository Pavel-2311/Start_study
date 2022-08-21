
package ru.specialist.DB;

import java.nio.charset.Charset;
import java.sql.*;
import java.util.Scanner;

public class AppDBSelect {
	
public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
public static final String CONNECTION_STRING =
"jdbc:mysql://localhost:3306/web?user=root&password=demo";


	public static void main(String[] args) throws ClassNotFoundException,
	SQLException {
		
	Class.forName(DRIVER_NAME);
	
	System.out.println("Поиск: ");
	String search = new Scanner(System.in).nextLine();
		
	try(Connection con = DriverManager.getConnection(CONNECTION_STRING))
	{
		String sql = "SELECT title, length FROM courses"
                        +"WHERE title LIKE ?"
                        + "ORDER BY title";
		PreparedStatement cmd = con.prepareStatement(sql);
                cmd.setString(1, "%" + search + "%");                
		ResultSet result = cmd.executeQuery();// последовательно перебирает строки результата
		
		while(result.next()) { // метод перехода на след строку: false - строки кончились. 
			String title = result.getString("title");
			int lenght = result.getInt("lenght");
			
		//	System.out.println(title+" "+ lenght);
			System.out.printf("% -40s %d\n",title , lenght);
		}
		result.close();
	} // con.close(); будет вызван автоматически

	}

}
