package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Service.impl.CustomerService;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customerHome";
    }
    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("customer") Customer customer) {
        return "customerAdd";
    }
    @PostMapping("/create")
    public String create (@ModelAttribute("customer") Customer customer, BindingResult result)
    {
        if (result.hasErrors())
            return "customerAdd";
        Customer newCustomer = CustomerFactory.createCustomer
                (
                        customer.getCustID(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getPrimaryNr(),
                        customer.getEmailAddress(),
                        customer.getCustAddress()
                );
         customerService.create(newCustomer);
         return  "redirect:/customer/home";
    }

    @GetMapping("/read/{custID}")
    public Customer read (@PathVariable String custID)
    {
        return customerService.read(custID);
    }

    @GetMapping("/update/{custID}")
    public String getUpdateForm(@PathVariable("custID") String custID, Model model) {
        Customer customer = customerService.read(custID);
        model.addAttribute("customer", customer);
        return "customerUpdate";
    }

    @PostMapping("/update")
    public String update(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors())
            return "customerUpdate";
        customerService.update(customer);
        return "redirect:/customer/home";
    }

    @DeleteMapping ("/delete/{custID}")
    public boolean delete (@PathVariable(value = "custID") String custID)
    {
        return customerService.delete(custID);
    }
    @GetMapping("/delete/{custID}")
    public String delete(@PathVariable("custID") String custID, Model model) {
        customerService.delete(custID);
        model.addAttribute("customers", customerService.getAll());
        return "redirect:/customer/home";
    }
    @GetMapping ("/getall")
    public List<Customer> getAll()
    {
        return customerService.getAll();
    }

}
