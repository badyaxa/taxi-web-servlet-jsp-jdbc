package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver for MySQL", e);
        }
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            Properties bdProperties = new Properties();
            bdProperties.put("user", "badyaha");
            bdProperties.put("password", "root");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_service_db", bdProperties);
        } catch (SQLException ee) {
            throw new RuntimeException("Can't create connection to DB", ee);
        }
        return connection;
    }
}
