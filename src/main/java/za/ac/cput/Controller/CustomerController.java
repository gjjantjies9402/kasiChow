package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Service.impl.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer create (@RequestBody Customer customer)
    {
        Customer newCustomer = CustomerFactory.createCustomer
                (
                        customer.getCustID(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getPrimaryNr(),
                        customer.getEmailAddress(),
                        customer.getCustAddress()
                );
        return customerService.create(newCustomer);
    }

    @GetMapping("/read/{custID}")
    public Customer read (@PathVariable String custID)
    {
        return customerService.read(custID);
    }

    @PostMapping ("/update")
    public Customer update (@RequestBody Customer customer)
    {
        Customer update = customerService.update(customer);

        return update;
    }

    @DeleteMapping ("/delete/{custID}")
    public boolean delete (@PathVariable(value = "custID") String custID)
    {
        return customerService.delete(custID);
    }

    @GetMapping ("/getall")
    public List<Customer> getAll()
    {
        return customerService.getAll();
    }

}
