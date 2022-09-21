package taxi.jdbc.dao;

import java.util.List;
import java.util.Optional;
import taxi.jdbc.model.Driver;

public interface DriverDao {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
