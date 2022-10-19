package za.ac.cput.Factory;
/**
 TrackingFactoryTest.java
 TrackingFactoryTest
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Ratings;

import static org.junit.jupiter.api.Assertions.*;

class RatingsFactoryTest {

    @Test
    void createRatings() {
        Ratings ratings = new Ratings.Builder()
                .setRateID(8868)
                .setOrderID("ORD98")
                .setRateScale(5)
                .setRateReview("Service was great!")
                .build();


        assertEquals(8868, ratings.getRateID());
        assertEquals("ORD98", ratings.getOrderID());
        assertEquals(5, ratings.getRateScale());
        assertEquals("Service was great!", ratings.getRateReview());
    }
}