/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Controller class implementation
 * */
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Service.Interface.ICustomerService;

import java.util.List;
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customerHome";
    }
    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("customer") Customer customer) {
        return "registerAdd";
    }
    @PostMapping("/create")
    public String create (@ModelAttribute("customer") Customer customer, BindingResult result)
    {
        if (result.hasErrors())
            return "registerAdd";
        Customer newCustomer = CustomerFactory.createCustomer
                (
                        customer.getCustID(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getPrimaryNr(),
                        customer.getEmailAddress(),
                        customer.getCustAddress()
                );
        service.create(newCustomer);
        return  "redirect:/customer/home";
    }
    @GetMapping(value = "/read/{id}")
    public Customer read(@PathVariable String id) {
        return this.service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Customer reg = service.read(id);
        model.addAttribute("registration", reg);
        return "registrationUpdated";
    }

    @PostMapping("/update")
    public String update(Customer register, BindingResult result, Model model) {
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
    public List<Customer> getAll() {
        return service.getAll();
    }
}
