package taxi.controller.driver;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.service.CarService;
import taxi.service.DriverService;

public class GetMyCurrentCarsController extends HttpServlet {
    private static final int ID_POSITION = 1;
    private static final Injector injector = Injector.getInstance("taxi");
    private List<Driver> drivers;
    private CarService carService;
    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        carService = (CarService) injector.getInstance(CarService.class);
        driverService = (DriverService) injector.getInstance(DriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long currentDriverId = (Long) req.getSession().getAttribute("driver_id");

//        currentDriverId = 1L;

        String name = driverService.get(currentDriverId).getName();
        req.setAttribute("name", name);
        String licenseNumber = driverService.get(currentDriverId).getLicenseNumber();
        req.setAttribute("license_number", licenseNumber);

        List<Car> carsOfCurrentCDriver = carService.getAllByDriver(currentDriverId);
        req.setAttribute("my_cars", carsOfCurrentCDriver);
        req.getRequestDispatcher("/WEB-INF/views/driver/cars/my.jsp").forward(req, resp);





//        String id = req.getPathInfo().split("/")[ID_POSITION];
//        Car car = carService.get(Long.valueOf(id));
//        String model = car.getModel();
//        drivers = car.getDrivers();
//        req.setAttribute("id", id);
//        req.setAttribute("model", model);
//        Manufacturer manufacturer = car.getManufacturer();
//        req.setAttribute("manufacturer", manufacturer);
//        req.setAttribute("drivers", drivers);
//        List<Driver> driversRemained = driverService.getAll()
//                .stream()
//                .filter(d -> !drivers.contains(d))
//                .collect(Collectors.toList());
//        req.setAttribute("driversRemained", driversRemained);
//        req.getRequestDispatcher("/WEB-INF/views/car/drivers.jsp").forward(req, resp);
    }
}
