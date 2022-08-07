package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.Factory.DeliveryAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryAddressRepositoryTest {

    private static DeliveryAddressRepository repository = DeliveryAddressRepository.getRepository();

    private static DeliveryAddress delivery = DeliveryAddressFactory.createDeliveryAddress("25", "32 Graceland Khayelitsha Cape Town 7783");
    private static DeliveryAddress delivery2 = DeliveryAddressFactory.createDeliveryAddress("32", "10 Dorset Street Woodstock Cape Town 7925");
    private static DeliveryAddress delivery3 = DeliveryAddressFactory.createDeliveryAddress("25", "32 Sable Square Century City Cape Town 7441");



    @Test
    void a_create() {

        DeliveryAddress created = repository.create(delivery);
        DeliveryAddress created2 = repository.create(delivery2);
        assertNotEquals(created.getDeliveryID(), created2.getDeliveryID());
        System.out.println("Created: " + created);
        System.out.println("Created: " + created2);
    }

    @Test
    void b_read() {

        DeliveryAddress read = repository.read(delivery2.getDeliveryID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {

        DeliveryAddress update = new DeliveryAddress.Builder().copy(delivery).setStreetAddress("32 Dorset Street Woodstock Cape Town 7925").build();
        assertNotNull(repository.update(update));
        System.out.println("Updated:" + update);
    }

    @Test
    void d_delete() {

        boolean success = repository.delete(delivery2.getDeliveryID());
        assertTrue(success);
        System.out.println("Delete:" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Display All: ");
        System.out.println(repository.getAll());
    }
}