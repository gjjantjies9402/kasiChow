/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Rating;

import static org.junit.jupiter.api.Assertions.*;

class ratingFactoryTest {

    @Test
    void createRating() {
        Rating rate = new Rating.Builder()
                .setRateID("1")
                .setRateReview("Service was great")
                .setRateStars("****")
                .setOrderNr(1234)
                .build();


         assertEquals("1", rate.getRateID());
         assertEquals("Service was great", rate.getRateReview());
         assertEquals("****", rate.getRateStars());
         assertEquals(1234, rate.getOrderNr());
    }
}