package mate.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mate.jdbc.util.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        Statement getAllMnufacturersStatement = null;
        try {
            getAllMnufacturersStatement = connection.createStatement();
            ResultSet resultSet = getAllMnufacturersStatement.executeQuery("SELECT * FROM manufacturers");
            System.out.println("resultSet = " + resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Can't ", e);
        }
    }
}
