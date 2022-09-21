package taxi.controller.manufacturer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Manufacturer;
import taxi.service.ManufacturerService;

@WebServlet(urlPatterns = "/manufacturers/*")
public class GetManufacturerByIdController extends HttpServlet {
    private static final int ID_POSITION = 1;
    private static final Injector injector = Injector.getInstance("mate");
    private ManufacturerService manufacturerService;

    @Override
    public void init() throws ServletException {
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getPathInfo().split("/")[ID_POSITION];
        Manufacturer manufacturer = manufacturerService.get(Long.valueOf(id));
        String name = manufacturer.getName();
        String country = manufacturer.getCountry();
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("country", country);
        req.getRequestDispatcher("/WEB-INF/views/manufacturer/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getPathInfo().split("/")[ID_POSITION];
        Manufacturer updatedManufacturer = new Manufacturer();
        updatedManufacturer.setId(Long.valueOf(id));
        String name = req.getParameter("name");
        updatedManufacturer.setName(name);
        String country = req.getParameter("country");
        updatedManufacturer.setCountry(country);
        Manufacturer manufacturer = manufacturerService.update(updatedManufacturer);
        req.setAttribute("id", id);
        req.setAttribute("name", manufacturer.getName());
        req.setAttribute("country", manufacturer.getCountry());
        req.setAttribute("title", "Manufacturer ("
                + name + "/" + country
                + ") has been successfully updated");
        req.getRequestDispatcher("/WEB-INF/views/manufacturer/edit.jsp").forward(req, resp);
    }
}
