package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Repository.Interface.ICustomerRepository;
import za.ac.cput.Service.Interface.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private static ICustomerService customerService = null;

    @Autowired
    private ICustomerRepository customerRepository;

    private CustomerService()
    {
        //this.customerRepository = customerRepository;

    }

    public static ICustomerService getCustomerService() {

        if(customerService == null)
            customerService = new CustomerService();
            return customerService;

    }
    
    

    @Override
    public Customer create(Customer customer) {
        
         return this.customerRepository.save(customer);
        
    }

    @Override
    public Customer read(String s) {

        Optional<Customer> optCustomer = this.customerRepository.findById(s);
        return optCustomer.orElse(null);
        
    }

    @Override
    public Customer update(Customer customer) {

        if (this.customerRepository.existsById(customer.getCustID())) {
            return this.customerRepository.save(customer);
        }
        
        return null;
    }

    @Override
    public boolean delete(String s) {

        this.customerRepository.deleteById(s);

        if(this.customerRepository.existsById(s)) return false;
        else return true;
        
    }


    @Override
    public List<Customer> getAll() {
        
        return this.customerRepository.findAll();
        
    }
    
    public List<Customer> getAllCustomersStartingWithA() {
        
        List<Customer> customersWithA = new ArrayList<>();
        List<Customer> customers = getAll();

        for(Customer customer : customers) {

            if(customer.getFirstName().trim().toLowerCase().startsWith("a")){

                customersWithA.add(customer);
            }
        }

        return customersWithA;
    }
    
}
