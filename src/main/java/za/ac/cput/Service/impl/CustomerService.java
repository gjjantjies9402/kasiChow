package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Contact;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Repository.Interface.ICustomerRepository;
import za.ac.cput.Service.Interface.IContactService;
import za.ac.cput.Service.Interface.ICustomerService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private static ICustomerService service = null;

    @Autowired
    private static ICustomerRepository repository;

    private CustomerService()
    {
        this.repository = repository;

    }

    public Set<Customer> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());

    }

    public Set<Customer> getAllFirstnamesWithA() {

        Set<Customer> customers = getAll();
        Set<Customer> firstnames = new HashSet<>();
        for (Customer customer : customers) {
            if(customer.getFirstName().trim().toLowerCase().startsWith("k")) {
                firstnames.add(customer);
            }
        }
        return firstnames;
    }

    public Customer getCustomerIMEI (String s) {

        Set<Customer> customers = getAll();
        return customers.stream().filter(customer -> customer.getCustIMEI().trim().equalsIgnoreCase(s))
                .findAny().orElse(null);
    }


    @Override
    public Customer create(Customer customer) {

        return this.repository.save(customer);

    }

    @Override
    public Customer read(String s) {

        return this.repository.findById(s).orElseGet(null);

    }

    @Override
    public Customer update(Customer customer) {

        if(this.repository.existsById(customer.getCustID())) {
            return this.repository.save(customer);
        }

        return null;

    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);

        if(this.repository.existsById(s)) return false;
        else return true;

    }
}
