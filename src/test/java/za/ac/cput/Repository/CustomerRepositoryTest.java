package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Contact;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();

    private static Customer customer = CustomerFactory.createCustomer("263", "Mandisa","Msongelwa", "28852752");
    private static Customer customer2 = CustomerFactory.createCustomer("279", "Lucky", "Smith", "5654648");
    private static Customer customer3 = CustomerFactory.createCustomer("153", "Nomaxabiso", "Kwanga", "55656565");


    @Test
    void a_create() {

        Customer created = repository.create(customer);
        Customer created2 = repository.create(customer2);
        assertNotEquals(created.getCustID(), created2.getCustID());
        System.out.println("Created: " + created);
        System.out.println("Created: " + created2);

    }

    @Test
    void b_read() {

        Customer read = repository.read(customer.getCustID());
        assertNotNull(read);
        System.out.println("Read: " + read);

    }

    @Test
    void c_update() {

        Customer update = new Customer.Builder().copy(customer).setCustIMEI("565466255").build();
        assertNotNull(repository.update(update));
        System.out.println("Updated:" + update);
    }

    @Test
    void d_delete() {

        boolean success = repository.delete(customer.getCustID());
        assertTrue(success);
        System.out.println("Delete:" + success);
    }

    @Test
    void e_getAll() {

        System.out.println("Display All: ");
        System.out.println(repository.getAll());
    }
}