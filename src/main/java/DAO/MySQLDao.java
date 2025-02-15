package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDao {
    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";
        Connection conn = null;

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
            throw new RuntimeException(e);
        }  catch (SQLException e){
            System.out.println("Connection failed:" + e.getMessage());
            System.exit(1);
        }
        return conn;
    }
}
