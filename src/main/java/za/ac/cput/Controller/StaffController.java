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
import za.ac.cput.Entity.registration;
import za.ac.cput.Entity.staff;
import za.ac.cput.Service.impl.RegistrationServices;
import za.ac.cput.Service.impl.StaffServices;

import java.util.Set;

@RestController
@RequestMapping("kasichow/staff/type/")
public class StaffController {


    @Autowired
    private StaffServices services;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("staff", services.getAll());
        return "staffHome";
    }

    @GetMapping("/create")
    public String getCreateForm(staff staffs) {
        return "staffAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute staff staffs, BindingResult result, Model model) {
        if (result.hasErrors())
            return "staffAdd";
        services.create(staffs);
        return "redirect:/staff/home";
    }

    @GetMapping(value = "/read/{id}")
    public staff read(@PathVariable String id) {
        return this.services.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        staff staf = services.read(id);
        model.addAttribute("staff", staf);
        return "staffUpdated";
    }

    @PostMapping("/update")
    public String update(staff staff, BindingResult result, Model model) {
        if (result.hasErrors())
            return "staffUpdate";
        services.update(staff);
        return "redirect:/staff/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return services.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        services.delete(id);
        model.addAttribute("staff", services.getAll());
        return "redirect:/staff/home";
    }

    @GetMapping(value = "/all")
    public Set<staff> getAll() {
        return services.getAll();
    }
}
