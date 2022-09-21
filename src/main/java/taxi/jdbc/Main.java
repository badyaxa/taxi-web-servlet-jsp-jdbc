package taxi.jdbc;

import java.util.List;
import taxi.jdbc.dao.ManufacturerDao;
import taxi.jdbc.dao.ManufacturerDaoImpl;
import taxi.jdbc.model.Manufacturer;

public class Main {
    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        List<Manufacturer> manufacturers = manufacturerDao.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            if (!manufacturer.isDeleted()) {
                System.out.println(manufacturer);
            }
        }
        ///////////////////////////////////////////////
        Manufacturer savedManufacturer = manufacturerDao
                .create(new Manufacturer("Ntesr3", "Ctest3"));
        System.out.println("savedManufacturer = " + savedManufacturer);
        ///////////////////////////////////////////////
        boolean delete14 = manufacturerDao.delete(14L);
        System.out.println("delete14 = " + delete14);
        boolean delete15 = manufacturerDao.delete(15L);
        System.out.println("delete15 = " + delete15);
        ///////////////////////////////////////////////
    }
}
