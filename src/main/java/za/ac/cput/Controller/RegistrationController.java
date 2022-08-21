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
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Entity.registration;
import za.ac.cput.Service.Interface.RestaurantService;
import za.ac.cput.Service.impl.RegistrationServices;

import java.util.Set;
@RestController
@RequestMapping("kasichow/registration/type/")
public class RegistrationController {

    @Autowired
    private RegistrationServices service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("registration", service.getAll());
        return "RegisterHome";
    }

    @GetMapping("/create")
    public String getCreateForm(registration register) {
        return "registerAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute registration registers, BindingResult result, Model model) {
        if (result.hasErrors())
            return "restaurantAdd";
        service.create(registers);
        return "redirect:/registration/home";
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
