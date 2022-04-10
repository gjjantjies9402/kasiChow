/*CustomerRepository.java
Repository for Customer
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.Customer;
import za.ac.cput.Repository.Interface.CustomerInterface;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements CustomerInterface {

    private static CustomerRepository repository = null;
    private Set<Customer> customerDB;

    private CustomerRepository() {

        customerDB = new HashSet<Customer>();

    }

    public static CustomerRepository getRepository(){
        if (repository == null)
        {
            repository = new CustomerRepository();
        }
        return repository;
    }



    @Override
    public Customer create(Customer customer) {

        boolean success = customerDB.add(customer);
        if (!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String s) {

        Customer customer = customerDB.stream()
                .filter(c -> c.getCustID().equals(s))
                . findAny()
                .orElse(null);

        return customer;
    }

    @Override
    public Customer update(Customer customer) {

        Customer prevCust = read(customer.getCustID());

        if (prevCust != null)
        {
            customerDB.remove(prevCust);
            customerDB.add(customer);

            return customer;
        }

        return  customer;
    }

    @Override
    public boolean delete(String s) {

        Customer customerDelete = read(s);

        if(customerDelete == null)
            return  false;
        customerDB.remove(customerDelete);
        return  true;
    }

    @Override
    public Set<Customer> getAll() {

        return customerDB;
    }
}
