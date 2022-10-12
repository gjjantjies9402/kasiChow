package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Service.impl.CustomerService;
import za.ac.cput.Service.impl.DriverService;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    public Driver create (@RequestBody Driver driver)
    {
        Driver newDriver = DriverFactory.createDriver
                (
                        driver.getDriverID(),
                        driver.getDriverLname(),
                        driver.getDriverLname(),
                        driver.getDriverContact()
                );
        return driverService.create(newDriver);
    }

    @GetMapping("/read/{driverID}")
    public Driver read (@PathVariable String driverID)
    {
        return driverService.read(driverID);
    }

    @PostMapping ("/update")
    public Driver update (@RequestBody Driver driver)
    {
        Driver update = driverService.update(driver);

        return update;
    }

    @DeleteMapping ("/delete/{driverID}")
    public String delete (@RequestBody Driver driver)
    {
        if (driverService.delete(driver.getDriverID()))

            return "Deleted";
        else
            return "Not Deleted";
    }

    @GetMapping ("/getall")
    public List<Driver> getAll()
    {
        return driverService.getAll();
    }

}
