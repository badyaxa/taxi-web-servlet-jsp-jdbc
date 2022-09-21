package taxi.dao;

import java.util.List;
import java.util.Optional;
import taxi.model.Manufacturer;

public interface ManufacturerDao {
    Manufacturer create(Manufacturer manufacturer);

    Optional<Manufacturer> get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
