package taxi.jdbc;

import java.util.List;
import mate.jdbc.dao.ManufacturerDaoImpl;
import taxi.jdbc.dao.ManufacturerDao;
import taxi.jdbc.model.Manufacturer;

public class Main {
    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        List<Manufacturer> manufacturers = manufacturerDao.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }
    }
}
