///**
// * CustomerRepository.java
// * Repository for Customer
// * Author: Kanya Ramncwana (218297521)
// * Date: 09 April 2022
// * Date Modified: 07 August 2022
// */
//package za.ac.cput.Repository;
//
//import za.ac.cput.Entity.Customer;
//import za.ac.cput.Repository.Interface.ICustomerRepository;
//import za.ac.cput.Repository.Interface.ICustomerRepositoryUpdated;
//
//import java.util.HashSet;HashSet
//import java.util.Set;
//
//@Deprecated
//public class CustomerRepository implements ICustomerRepositoryUpdated {
//
//    private static CustomerRepository repository = null;
//    private Set<Customer> customerDB;
//
//    private CustomerRepository() {
//
//        customerDB = new HashSet<Customer>();
//
//    }
//
//    public static CustomerRepository getRepository(){
//        if (repository == null)
//        {
//            repository = new CustomerRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Customer create(Customer customer) {
//
//        boolean success = customerDB.add(customer);
//        if (!success)
//            return null;
//        return customer;
//
//    }
//
//    @Override
//    public Customer read(String id) {
//        Customer customer = customerDB.stream()
//                .filter(c -> c.getCustID().equals(id))
//                . findAny()
//                .orElse(null);
//
//        return customer;
//    }
//
//    @Override
//    public Customer update(Customer customer) {
//
//        Customer prevCust = read(customer.getCustID());
//
//        if (prevCust != null)
//        {
//            customerDB.remove(prevCust);
//            customerDB.add(customer);
//
//            return customer;
//        }
//
//        return  customer;
//    }
//
//    @Override
//    public boolean delete(String id) {
//
//        Customer customerDelete = read(id);
//
//        if(customerDelete == null)
//            return  false;
//        customerDB.remove(customerDelete);
//        return  true;
//
//    }
//
//    @Override
//    public Set<Customer> getAll() {
//        return customerDB;
//    }
//
//}
