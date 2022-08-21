package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceTest {

    private static CustomerService service = CustomerService.getCustomerService();

    private static Customer customer = CustomerFactory.createCustomer("45251", "Qhama", "Zintweni", "152HGHG565J");

    private static Customer customer2 = CustomerFactory.createCustomer("78953", "Christian", "Grey", "1352JJH52");

    private static Customer customer3 = CustomerFactory.createCustomer("12345", "Nosive", "Xhamela", "566554KHN554L");

    @Test
    void getService() {

        CustomerService customerService = CustomerService.getCustomerService();

    }

    @Test
    void create() {

        Customer created = service.create(customer3);
        assertEquals(created.getCustID(), customer3.getCustID());
        System.out.println("Create: " + created);

    }


    @Test
    void read() {

        Customer cust = service.read(customer2.getCustIMEI());
        assertNotNull(cust);
        System.out.println("Read: " + cust);

    }


    @Test
    void update() {

        Customer updated = new Customer.Builder().copy(customer).setLastName("Leve").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);

    }

    @Test
    void delete() {

        boolean success = service.delete(customer2.getCustID());
        assertTrue (success);
        System.out.println("Delete: " + success);

    }

    @Test
    void getAllCustomers() {

        System.out.println("Customers: ");
        System.out.println(service.getAllCustomers());

    }

}