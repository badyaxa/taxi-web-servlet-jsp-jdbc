package mate.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import taxi.jdbc.model.Manufacturer;
import mate.jdbc.util.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        Statement getAllMnufacturersStatement = null;
        try {
            getAllMnufacturersStatement = connection.createStatement();
            ResultSet resultSet = getAllMnufacturersStatement.executeQuery("SELECT * FROM manufacturers");
            while (resultSet.next()) {
                Long id = resultSet.getObject("id", Long.class);
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                Manufacturer manufacturer = new Manufacturer(id, name, country);
                System.out.println("manufacturer = " + manufacturer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't ", e);
        }
    }
}
