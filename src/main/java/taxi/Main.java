package taxi;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.model.Manufacturer;
import taxi.service.CarService;
import taxi.service.DriverService;
import taxi.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("taxi.jdbc");

    public static void main(String[] args) {
        /////////////Manufacturer/////////////
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        /////create toyota/////
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("Toyota");
        newManufacturer.setCountry("Japan");
        Manufacturer toyota = manufacturerService.create(newManufacturer);
        System.out.println("createdManufacturer = " + toyota);
        /////getAll manufacturers/////
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        /////////////Driver////////////
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        /////create driver/////
        Driver bohdan = new Driver();
        bohdan.setName("Bohdan");
        bohdan.setLicenseNumber(String.valueOf(new Random().nextInt(999999999)));
        bohdan = driverService.create(bohdan);
        System.out.println("createdDriver = " + bohdan);
        /////getAll drivers/////
        System.out.println("-------getAllDrivers-------");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        /////////////Car////////////
        CarService carService = (CarService)
                injector.getInstance(CarService.class);
        /////create toyota RAV4 /////
        Car newCarToyotaRav4 = new Car();
        newCarToyotaRav4.setManufacturer(manufacturerService.get(toyota.getId()));
        newCarToyotaRav4.setModel("RAV4");
        newCarToyotaRav4.setDrivers(new HashSet<>(drivers));
        Car createdCar = carService
                .create(newCarToyotaRav4);
        System.out.println("createdCar = " + createdCar);
        /////get/////
        Car toyotaRav4 = carService.get(createdCar.getId());
        System.out.println("getCar = " + toyotaRav4);
        /////getAll/////
        System.out.println("-------getAllCars-------");
        List<Car> cars = carService.getAll();
        cars.forEach(System.out::println);
        /////addDriverToCar/////
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber(String.valueOf(new Random().nextInt(999999999)));
        bob = driverService.create(bob);
        System.out.println("createdDriver = " + bob);

        System.out.println("-------getAllDrivers------");
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        carService.addDriverToCar(bob, toyotaRav4);
        System.out.println("toyotaRav4.allDrivers = " + carService.get(toyotaRav4.getId()));
        carService.addDriverToCar(bob, toyotaRav4);
        carService.addDriverToCar(bob, toyotaRav4);
        carService.addDriverToCar(bob, toyotaRav4);

        /////removeDriverFromCar/////
        System.out.println("toyotaRav4.allDrivers = " + carService.get(toyotaRav4.getId()));
        carService.removeDriverFromCar(bob, toyotaRav4);
        System.out.println("toyotaRav4.allDrivers = " + carService.get(toyotaRav4.getId()));
        carService.removeDriverFromCar(bob, toyotaRav4);
        System.out.println("toyotaRav4.allDrivers = " + carService.get(toyotaRav4.getId()));

        carService.addDriverToCar(bob, toyotaRav4);

        /////getAllByDriver/////
        List<Car> bohdanCars = carService.getAllByDriver(bohdan.getId());
        System.out.println("bohdanCars = " + bohdanCars);
        List<Car> bobCars = carService.getAllByDriver(bob.getId());
        System.out.println("bobCars = " + bobCars);
    }
}
