/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Controller class implementation
 * */
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Entity.registration;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Factory.registrationFactory;
import za.ac.cput.Service.Interface.RestaurantService;
import za.ac.cput.Service.impl.RegistrationServices;

import java.util.Set;
@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationServices service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("registration", service.getAll());
        return "register";
    }

    @GetMapping("/create")
    public String getCreateForm(registration register) {
        return "register";
    }

    @PostMapping("/create")

    public registration create(@RequestBody  registration register) {
        {

            registration newRegistration = registrationFactory.createRegistration(
                    register.getFirstName(),
                    register.getLastName(),
                    register.getUsername(),
                    register.getPassword(),
                    register.getConfirmPassword(),
                    register.getEmailAddress()
            );
            return service.create(newRegistration);

        }
    }

    @GetMapping(value = "/read/{id}")
    public registration read(@PathVariable String id) {
        return this.service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        registration reg = service.read(id);
        model.addAttribute("registration", reg);
        return "registrationUpdated";
    }

    @PostMapping("/update")
    public String update(registration register, BindingResult result, Model model) {
        if (result.hasErrors())
            return "registerUpdate";
        service.update(register);
        return "redirect:/registration/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("register", service.getAll());
        return "redirect:/registration/home";
    }

    @GetMapping(value = "/all")
    public Set<registration> getAll() {
        return service.getAll();
    }
}
