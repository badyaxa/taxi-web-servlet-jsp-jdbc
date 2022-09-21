package taxi.jdbc.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import taxi.jdbc.dao.DriverDao;
import taxi.jdbc.lib.Inject;
import taxi.jdbc.lib.Service;
import taxi.jdbc.model.Driver;
import taxi.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id)
                .orElseThrow(() -> new NoSuchElementException("Could not get driver "
                        + "by id = " + id));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
