package ru.specialist.DB;

import java.sql.*;
import java.util.Scanner;

public class Lab5DBInsert {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_STRING
            = "jdbc:mysql://localhost:3306/web?user=root&password=demo";

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {

        Class.forName(DRIVER_NAME);

        System.out.println("Название курса: ");
        String title = new Scanner(System.in).nextLine();

        System.out.println("Длительность курса: ");
        int length = new Scanner(System.in).nextInt();

        System.out.println("Описание курса: ");
        String description = new Scanner(System.in).nextLine();

        try ( Connection con = DriverManager.getConnection(CONNECTION_STRING)) {
            try {
                String sql = "INSERT INTO courses (title, length, description )"
                        + "VALUES (?,?,?)";

 //               INSERT INTO courses (title,length, description)
 //               VALUES ('Java 1',40, 'Java Intro')
                PreparedStatement cmd = con.prepareStatement(sql);

                cmd.setString(1, title);

                cmd.setInt(2, length);
                cmd.setString(3, description);

                if (cmd.executeUpdate() == 1) {
                    System.out.println("Курс добавлен");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
