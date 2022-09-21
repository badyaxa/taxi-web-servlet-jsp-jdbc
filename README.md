# Web practice. Implement JSP pages and their corresponding controllers

!Note: let's install Tomcat 9.0.50. If you decide to install version 10 and above, 
you should use [a different dependency for servlets](https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api/5.0.0) and [JSTL](https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/2.0.0) as well.

- To get the actual parameters of the database tables, run script from the resources/init_db.sql file in the Workbench. 
- Create a new controller: Implement creating a driver
- Create a new controller: Display all drivers
- Create a new controller: Implement creating a manufacturer
- Create a new controller: Implement creating a car (with no drivers by default)
- Create a new controller: Implement adding driver to car.

HINT: while implementing the last requirement, create just two fields on JSP where you will pass corresponding id values.
You can redirect to `/index` page or any other page after your business login in `doPost()` method is applied.

### Example how to implement adding driver to car:
```java
public class AddDriverToCarController extends HttpServlet {    
    private static final Injector injector = Injector.getInstance("mate.academy"); // be careful with copy-paste
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long driverId = Long.valueOf(request.getParameter("driver_id"));
        Long carId = Long.valueOf(request.getParameter("car_id"));
        Car car = carService.get(carId);
        Driver driver = driverService.get(driverId);
        // continue your implementation 
    }
}
```

### Typical mistakes:
- Do not forget to import additional maven library for jstl
- Do not forget to declare `taglib` prefix where applicable

### Advanced:
- Create a new controller: Display all manufacturers with ability to delete a certain manufacturer
- Display all drivers with ability to delete a certain driver
- Create a new controller: Display all cars (with manufacturer and drivers) with ability to delete a certain car

__Before submitting solution make sure you checked it first with__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-web/web-practice/java-web-practice)
