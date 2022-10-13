package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer() {

        Customer customer = CustomerFactory.createCustomer("153", "Kanya", "Ramncwana", "0617713542", "kanyaramncwana@gmail.com", "10 Dorset Street, District Six, Cape Town 8001");
        assertNotNull(customer);
        System.out.println("Customer Created: "+customer);
    }

}

