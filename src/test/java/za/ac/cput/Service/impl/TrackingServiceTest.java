package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Tracking;
import za.ac.cput.Factory.TrackingFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TrackingServiceTest {
    private static TrackingService trackingServ;
    private static Tracking tracking = TrackingFactory.createTracking("ORD98", 2568, "Complete");


    @Test
    void create() {
        Tracking created = trackingServ.create(tracking);
        assertEquals(tracking.getOrderNr(), created.getOrderNr());
        System.out.println("\nCreated: " + created);
    }

    @Test
    void read() {
        Tracking read = trackingServ.read(tracking.getOrderNr());
        assertNotNull(read);
        System.out.println("\nRead:\n" + read.toString());
    }

    @Test
    void update() {
        Tracking tracking1 = new Tracking.Builder().copy(tracking).setOrderNr("ORD96").build();
        tracking1 = trackingServ.update(tracking1);
        System.out.println("\nUpdated: " + tracking1);
    }

    @Test
    void delete() {
        boolean deleteSuccessful = trackingServ.delete(tracking.getOrderNr());
        System.out.println("\nDeleted: ");
        assertTrue(deleteSuccessful);
    }

    @Test
    void getAll() {
        System.out.println("\nDisplay All: " + trackingServ.getAll());
    }

}