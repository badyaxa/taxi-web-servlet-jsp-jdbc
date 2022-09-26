package taxi.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.DriverService;

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
        req.setAttribute("name", name);
        String licenseNumber = req.getParameter("license_number").trim();
        req.setAttribute("license_number", licenseNumber);
        String login = req.getParameter("login").trim().toLowerCase();
        req.setAttribute("login", login);
        String password = req.getParameter("password").trim();
        String repeatPassword = req.getParameter("repeat_password").trim();
        if (name.isBlank()
                || name.isEmpty()
                || name.length() < 3
                || licenseNumber.isEmpty()
                || licenseNumber.isBlank()
                || licenseNumber.length() < 3) {
            req.setAttribute("title", "<p style=\"color:red\">enter the correct data</p>");
            req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
        } else if (!driverService.findByLogin(login).isEmpty()) {
            req.setAttribute("title", "<p style=\"color:red\">this login is already in use</p>");
            req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
        } else if (login.isEmpty()
                || login.isBlank()
                || login.length() < 3) {
            req.setAttribute("title", "<p style=\"color:red\">this login is to short</p>");
            req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
        } else if (!password.equals(repeatPassword)) {
            req.setAttribute("title", "<p style=\"color:red\">"
                    + "password and repeat-password do not match</p>");
            req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
        } else if (password.isEmpty()
                || password.isBlank()
                || password.length() < 3) {
            req.setAttribute("title", "<p style=\"color:red\">password is to short</p>");
            req.getRequestDispatcher("/WEB-INF/views/driver/create.jsp").forward(req, resp);
        } else {
            Driver newDriver = new Driver();
            newDriver.setName(name);
            newDriver.setLicenseNumber(licenseNumber);
            newDriver.setLogin(login);
            newDriver.setPassword(password);
            driverService.create(newDriver);
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
