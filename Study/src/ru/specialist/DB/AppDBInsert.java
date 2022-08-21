package ru.specialist.DB;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AppDBInsert {

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
                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                
                String sql = "INSERT INTO courses (title, length, description )"
                        + "VALUES (?,?,?)";

                // INSERT INTO courses (title,length, description)
//            VALUES ('Java 1',40, 'Java Intro')
                PreparedStatement cmd = con.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);//запрос у базы сгенерированных при выполнении ключей

                cmd.setString(1, title);

                cmd.setInt(2, length);
                cmd.setString(3, description);

                if (cmd.executeUpdate() == 1) {
                   con.commit();// ручное управление транзакциями
                    try ( ResultSet ids = cmd.getGeneratedKeys()) { // выполнение запроса о ключах

                        if (ids.next()) {
                            int generated_id = ids.getInt(1);
                            System.out.println("Курс добавлен. ID: " + generated_id);
                        }
                    }
                }
            } catch (SQLException e) {
                con.rollback();// ручное управление транзакциями
                System.out.println(e.getMessage());
            }
        }
    }
}
