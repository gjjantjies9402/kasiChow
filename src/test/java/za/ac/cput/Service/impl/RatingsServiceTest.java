package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Ratings;
import za.ac.cput.Factory.RatingsFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RatingsServiceTest {
    private static RatingsService ratingsServ;
    private static Ratings ratings = RatingsFactory.createRatings(8868, "ORD98", 5, "" );


    @Test
    void create() {
        Ratings created = ratingsServ.create(ratings);
        assertEquals(ratings.getOrderID(), created.getOrderID());
        System.out.println("\nCreated: " + created);
    }

    @Test
    void read() {
        Ratings read = ratingsServ.read(ratings.getOrderID());
        assertNotNull(read);
        System.out.println("\nRead:\n" + read);

    }

    @Test
    void update() {
        Ratings ratings1 = new Ratings.Builder().copy(ratings).setOrderID("ORD96").build();
        ratings1 = ratingsServ.update(ratings1);
        System.out.println("\nUpdated: " + ratings1);
    }

    @Test
    void delete() {
        boolean deleteSuccessful = ratingsServ.delete(ratings.getOrderID());
        assertTrue(deleteSuccessful);
        System.out.println("\nDeleted: " + true);

    }

    @Test
    void getAll() {
        assertEquals(1, ratingsServ.getAll().size());
        System.out.println("\nDisplay All: " + ratingsServ.getAll());
    }

}