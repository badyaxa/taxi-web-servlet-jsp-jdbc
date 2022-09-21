package taxi.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import taxi.jdbc.lib.Dao;
import taxi.jdbc.model.Manufacturer;
import taxi.jdbc.util.ConnectionUtil;

@Dao
public class ManufacturerDaoImpl implements ManufacturerDao {
    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        try (Connection connection = ConnectionUtil.getConnection();
                Statement createManufacturerStatement = connection.createStatement()) {
            String insertManufacturerRequest = "INSERT INTO manufacturers(name, country) VALUES('"
                    + manufacturer.getName() + "', '" + manufacturer.getCountry() + "');";
            createManufacturerStatement.executeUpdate(insertManufacturerRequest);
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert manufacturer to DB.", e);
        }
        return null;
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> allManufacturers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 Statement getAllManufacturersStatement = connection.createStatement()) {
            ResultSet resultSet = getAllManufacturersStatement
                    .executeQuery("SELECT * FROM manufacturers");
            while (resultSet.next()) {
                Long id = resultSet.getObject("id", Long.class);
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                Manufacturer manufacturer = new Manufacturer(name, country);
                manufacturer.setId(id);
                allManufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't ", e);
        }
        return allManufacturers;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
