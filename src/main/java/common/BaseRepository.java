package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private final Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/thuetoa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public BaseRepository() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to database");
    }
    public Connection getConnection(){
        return connection;
    }
}
