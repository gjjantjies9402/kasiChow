package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Service.impl.DriverService;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("drivers", driverService.getAll());
        return "driverHome";
    }

    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("driver") Driver driver){
        return "driverAdd";
    }


    @PostMapping(value = "/create")
    public String create (@ModelAttribute("driver") Driver driver, BindingResult result)
    {
        if (result.hasErrors())
            return "driverAdd";
        Driver newDriver = DriverFactory.createDriver(
                        driver.getDriverID(),
                        driver.getDriverFname(),
                        driver.getDriverLname(),
                        driver.getDriverContact()
                );
         driverService.create(newDriver);
         return "redirect:/driver/home";
    }


    @GetMapping("/read/{driverID}")
    public Driver read (@PathVariable String driverID)
    {
        return driverService.read(driverID);
    }

    @PostMapping ("/update")
    public Driver update (@RequestBody Driver driver)
    {

        return driverService.update(driver);
    }

    @DeleteMapping ("/delete/{driverID}")
    public boolean delete (@PathVariable(value = "driverID") String driverID)
    {
        return driverService.delete(driverID);
    }


    @GetMapping("/all")
    public List<Driver> getAll() {
        return driverService.getAll();
    }
}
