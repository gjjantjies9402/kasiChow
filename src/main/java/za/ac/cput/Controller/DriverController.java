package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Service.Interface.IDriverService;

import java.util.Set;

@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private IDriverService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("drivers", service.getAll());
        return "driverHome";
    }
    @RequestMapping("/driver")
    public String driver() {
        System.out.println("Driver Page");
        return "driverHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Driver driver){
        return "driverAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Driver driver, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverAdd";
        Driver newDriver = DriverFactory.createId(driver.getName());
        service.create(newDriver);
        return "redirect:/driver/home";
    }

    @GetMapping(value = "/read/{id}")
    public Driver read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Driver driver = service.read(id);
        model.addAttribute("driver", driver);
        return "driverUpdate";
    }

    @PostMapping("/update")
    public String update(Driver driver, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverUpdate";
        service.update(driver);
        return "redirect:/driver/home";
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model){
        service.delete(id);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/driver/home";
    }

    @GetMapping("/all")
    public Set<Driver> getAll() {
        return service.getAll();
    }
}
