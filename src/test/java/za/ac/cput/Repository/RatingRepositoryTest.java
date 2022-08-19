/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Rating;
import za.ac.cput.Factory.RatingFactory;

import static org.junit.jupiter.api.Assertions.*;

class RatingRepositoryTest {

    private static RatingRepository rateRepo = RatingRepository.getRepository();
    private static Rating rate = RatingFactory.createRating("1", 1234, "****", "Service was great");

    @Test
    void create() {
        Rating create = rateRepo.create(rate);
        assertEquals(rate.getRateID(), create.getRateID());
        System.out.println(create);
    }

    @Test
    void read() {
        Rating read = rateRepo.read(rate.getRateID());
        assertNotNull(read);
        System.out.println(read);
    }


    @Test
    void update() {
        Rating update = new Rating.Builder().build();
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