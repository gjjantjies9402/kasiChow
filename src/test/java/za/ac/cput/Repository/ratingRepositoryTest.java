/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.rating;
import za.ac.cput.Factory.orderItemFactory;
import za.ac.cput.Factory.ratingFactory;

import static org.junit.jupiter.api.Assertions.*;

class ratingRepositoryTest {

    private static ratingRepository rateRepo = ratingRepository.getRepository();
    private static rating rate = ratingFactory.createRating(1, 1234, "****", "Service was great");

    @Test
    void create() {
        rating create = rateRepo.create(rate);
        assertEquals(rate.getRateID(), create.getRateID());
        System.out.println(create);
    }

    @Test
    void read() {
        rating read = rateRepo.read(rate.getRateID());
        assertNotNull(read);
        System.out.println(read);
    }


    @Test
    void update() {
        rating update = new rating.Builder().build();
        assertNull(rateRepo.update(update));
        System.out.println(update);
    }

    @Test
    void delete() {
        boolean deleted = rateRepo.delete(rate.toString());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
        System.out.println(rateRepo.getAll());
    }

}