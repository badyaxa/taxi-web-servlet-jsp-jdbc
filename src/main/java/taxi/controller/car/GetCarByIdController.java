package taxi.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.model.Manufacturer;
import taxi.service.CarService;
import taxi.service.ManufacturerService;

public class GetCarByIdController extends HttpServlet {
    private static final int ID_POSITION = 1;
    private static final Injector injector = Injector.getInstance("taxi");
    private List<Driver> drivers;
    private ManufacturerService manufacturerService;
    private CarService carService;

    @Override
    public void init() throws ServletException {
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        carService = (CarService) injector.getInstance(CarService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("manufacturers", manufacturerService.getAll());
        String id = req.getPathInfo().split("/")[ID_POSITION];
        Car car = carService.get(Long.valueOf(id));
        String model = car.getModel();
        drivers = car.getDrivers();
        req.setAttribute("id", id);
        req.setAttribute("model", model);
        Manufacturer manufacturer = car.getManufacturer();
        req.setAttribute("manufacturer", manufacturer);
        req.setAttribute("manufacturerId", manufacturer.getId());
        req.setAttribute("drivers", drivers);
        req.getRequestDispatcher("/WEB-INF/views/car/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getPathInfo().split("/")[ID_POSITION];
        String model = req.getParameter("model").trim();
        String manufacturerId = req.getParameter("manufacturer").trim();
        if (model.isBlank()
                || model.isEmpty()
                || model.length() < 2) {
            req.setAttribute("title", "<p style=\"color:red\">enter the correct data</p>");
        } else {
            Manufacturer manufacturer = manufacturerService.get(Long.valueOf(manufacturerId));
            Car newCar = new Car();
            newCar.setId(Long.valueOf(id));
            newCar.setModel(model);
            newCar.setDrivers(drivers);
            newCar.setManufacturer(manufacturer);
            carService.update(newCar);
            req.setAttribute("id", id);
            req.setAttribute("manufacturer", manufacturer);
            req.setAttribute("manufacturerId", manufacturer.getId());
            req.setAttribute("drivers", drivers);
            req.setAttribute("title", "Car ("
                    + manufacturer.getName() + "/" + model
                    + ") has been successfully updated");
        }
        req.setAttribute("model", model);
        req.setAttribute("manufacturers", manufacturerService.getAll());
        req.getRequestDispatcher("/WEB-INF/views/car/edit.jsp").forward(req, resp);
    }
}
