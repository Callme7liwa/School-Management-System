package org.sid.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;

    public DBConnection() throws IOException {

    }

    public Connection connect() throws IOException {
        try
        {
            String pilot = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test";
            Class.forName(pilot);
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("CONNECTED");
            return connection;
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException error)
        {
            System.out.println("ERROR NOT CONNECTED"+error.getMessage());
        }
        return null;
    }

    public void disconnect() {
        try
        {
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
