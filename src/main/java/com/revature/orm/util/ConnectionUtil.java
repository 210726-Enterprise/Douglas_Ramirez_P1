package com.revature.orm.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Responsible for establishing a connection to our database.
 */
public class ConnectionUtil {
    //"jdbc:postgresql://[ENDPOINT]/[DATABASE]
    public static Connection connection;

    public ConnectionUtil(){

        try {
            connection = DriverManager.getConnection(System.getenv("db_url"), System.getenv("db_username"), System.getenv("db_password"));
            System.out.println("---------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
