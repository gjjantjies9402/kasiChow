package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Customer;
import za.ac.cput.Service.IService;

import java.util.List;

public interface ICustomerService extends IService<Customer, String> {

    List <Customer> getAll();

}
