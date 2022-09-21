package taxi.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/taxi_service_db";
    private static final String USERNAME = "badyaha";
    private static final String PASSWORD = "root";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver for MySQL", e);
        }
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            Properties bdProperties = new Properties();
            bdProperties.put("user", USERNAME);
            bdProperties.put("password", PASSWORD);
            connection = DriverManager
                    .getConnection(URL, bdProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB", e);
        }
        return connection;
    }
}
