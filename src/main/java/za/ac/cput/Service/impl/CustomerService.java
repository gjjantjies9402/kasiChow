package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Repository.Interface.ICustomerRepository;
import za.ac.cput.Service.Interface.ICustomerService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private static CustomerService service;

    @Autowired
    private ICustomerRepository repository;

    public static CustomerService getCustomerService() {

        if(service == null) {
            service = new CustomerService();
        }

        return service;
    }

    private CustomerService()
    {
        this.repository = repository;

    }

    public Set<Customer> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());

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

    public List<Customer> getAllCustomers() {
        return this.repository.findAll();
    }
}
