package taxi.controller.car;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.service.CarService;

public class GetAllCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private CarService carService;

    @Override
    public void init() throws ServletException {
        carService = (CarService) injector.getInstance(CarService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Collection<Car> allCars = carService.getAll();
        req.setAttribute("cars", allCars);
        req.getRequestDispatcher("/WEB-INF/views/car/all.jsp").forward(req, resp);
    }
}
