package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    private static MyConnection instance;
    private Connection connection;

    public void MyConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLuongSP";
        try {
            connection = DriverManager.getConnection(url , "sa", "sapassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

	
}



