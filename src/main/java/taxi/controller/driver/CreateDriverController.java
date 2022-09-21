package taxi.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.DriverService;

@WebServlet(urlPatterns = "/drivers/add")
public class CreateDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        driverService = (DriverService) injector.getInstance(DriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("title", "CREATE / ADD driver.");
        req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        String licenseNumber = req.getParameter("licenseNumber").trim();
        if (name.isBlank()
                || name.isEmpty()
                || name.length() < 3
                || licenseNumber.isEmpty()
                || licenseNumber.isBlank()
                || licenseNumber.length() < 3) {
            req.setAttribute("title", "<p style=\"color:red\">enter the correct data</p>");
            req.setAttribute("name", name);
            req.setAttribute("licenseNumber", licenseNumber);
        } else {
            Driver newDriver = new Driver();
            newDriver.setName(name);
            newDriver.setLicenseNumber(licenseNumber);
            Driver createdDriver = driverService.create(newDriver);
            Long id = createdDriver.getId();
            req.setAttribute("title", "Driver ("
                    + "<a href='" + id + "'>" + name + "</a>"
                    + ") has been successfully created,<br> do you want to create another one?");
        }
        req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
    }
}
