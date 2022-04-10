/*CustomerInterface.java
Interface for CustomerRepository
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Interface;

import za.ac.cput.Entity.Customer;

import java.util.Set;

public interface CustomerInterface extends iRepository<Customer,String>
{
        public Set<Customer> getAll();
}
