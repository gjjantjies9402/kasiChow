package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Factory.DeliveryAddressFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryAddressServiceTest {

    private static DeliveryAddressService service = DeliveryAddressService.getDeliveryAddressService();

    private static DeliveryAddress deliveryAddress = DeliveryAddressFactory.createDeliveryAddress("25265", "10 Dorset Street Woodstock");

    private static DeliveryAddress deliveryAddress1 = DeliveryAddressFactory.createDeliveryAddress("02369", "43 Graceland Khayelitsha");

    private static DeliveryAddress deliveryAddress3 = DeliveryAddressFactory.createDeliveryAddress("74123",  "50 Voortreker Road Parow");


    @Test
    void getService() {

        DeliveryAddressService deliveryAddressService = DeliveryAddressService.getDeliveryAddressService();

    }

    @Test
    void create() {

        DeliveryAddress created = service.create(deliveryAddress);
        assertEquals(created.getDeliveryID(), deliveryAddress.getDeliveryID());
        System.out.println("Create: " + created);

    }


    @Test
    void read() {

        DeliveryAddress del = service.read(deliveryAddress1.getStreetAddress());
        assertNotNull(del);
        System.out.println("Read: " + del);

    }


    @Test
    void update() {

        DeliveryAddress updated = new DeliveryAddress.Builder().copy(deliveryAddress3).setStreetAddress("4 Sir Lowry Road Mowbray").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);

    }

    @Test
    void delete() {

        boolean success = service.delete(deliveryAddress1.getDeliveryID());
        assertTrue (success);
        System.out.println("Delete: " + success);

    }

    @Test
    void getAllDeliveryAddresses() {

        System.out.println("Delivery Addresses: ");
        System.out.println(service.getAllDeliveryAddresses());

    }

}