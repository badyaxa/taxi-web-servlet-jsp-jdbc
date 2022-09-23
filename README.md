# Web security
- To get the actual parameters of the database tables, run script from the resources/init_db.sql file in the Workbench.
- Add two more fields (`login` and `password`) to your `Driver` class.
  We will simplify the task, and our Driver will behave as User.
- Modify the required JSP pages and corresponding controllers to support two new fields: `login` and `password`.
- Modify `DriverDaoImpl` and `CarDaoImpl` to fetch all columns for drivers, including new ones.
- Create new AuthenticationService with method ```Driver login(String login, String password);```
- Create new method ```Optional<Driver> findByLogin(String login)``` in DriverDao and DriverService.
- Use your new method _findByLogin_ in the ```authService.login(login, password)``` method to identify the user based on the login
- Implement `LoginController` with corresponding JSP page
- Implement `LogoutController` and add a corresponding button on all pages where it should be
- Implement user authentication based on HttpSession and filters. Only `LoginController` and `CreateDriverController` should be available for non authenticated users.
- Having information about currently logged-in user (e.g. driver), please implement the following controller `GetMyCurrentCarsController`.
  This controller is responsible for displaying the list of cars for currently logged driver (get info about the driver from the HttpSession).
  Hint: Use existed JSP page for displaying all cars.

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-web/web-security/java-web-security)
