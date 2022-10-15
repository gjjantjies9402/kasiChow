package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Service.impl.CustomerService;

import java.util.Set;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("customers", customerService.getAll());
        return "customerHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Customer customer){
        return "customerAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Customer customer, BindingResult result, Model model) {
        if (result.hasErrors())
            return "customerAdd";
        Customer newCustomer = CustomerFactory.createCustomer(customer.getCustID(),customer.getCustIMEI(),customer.getFirstName(), customer.getLastName());
        customerService.create(newCustomer);
        return "redirect:/customer/home";
    }

    @GetMapping(value = "/read{customerId}")
    public Customer read(@PathVariable String customerId) {
        return customerService.read(customerId);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.read(id);
        model.addAttribute("customer", customer);
        return "customerUpdate";
    }

    @PostMapping("/update")
    public String update(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors())
            return "customerUpate";
        customerService.update(customer);
        return "redirect:/customer/home";
    }

    @DeleteMapping(value = "/delete/{customerId}")
    public boolean delete(@PathVariable("customerId") String customerId) {
        return customerService.delete(customerId);
    }

    @GetMapping("/delete/{customerId}")
    public String delete(@PathVariable("customerId") String customerId, Model model){
        customerService.delete(customerId);
        model.addAttribute("customer", customerService.getAll());
        return "redirect:/customer/home";
    }

    @GetMapping(value = "/getall")
    public Set<Customer> getall() {
        return customerService.getAll();
    }

}
