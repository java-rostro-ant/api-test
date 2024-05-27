package org.rmj.api.test.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    public static void main(String[] args) {
        // Remote database URL, username, and password
        String url = "jdbc:postgresql://chat.guanzongroup.com.ph:5432/synapse";
        String user = "synapse";
        String password = "Atsp,imrtptd";

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish a connection to the remote database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Now you can use the 'connection' object to execute SQL queries and interact with the remote database
            String sql = "SELECT * FROM users";            

            // Don't forget to close the connection when you're done
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
