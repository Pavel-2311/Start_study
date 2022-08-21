package ru.specialist.DB;
// задача вывести список таблиц на экран

import java.sql.*;


public class AppDBMetaInfo {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_STRING
            = "jdbc:mysql://localhost:3306/web?user=root&password=demo";

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {

        Class.forName(DRIVER_NAME);
        Connection con = DriverManager.getConnection(CONNECTION_STRING);

        DatabaseMetaData meta = con.getMetaData();
        ResultSet result = meta.getTables("web", "web", null, null);

        while (result.next()) {
            String tableName = result.getString("TABLE_NAME");
            System.out.println(tableName);
        }
        result.close();
        con.close();
    }

}
