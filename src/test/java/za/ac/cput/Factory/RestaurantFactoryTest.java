package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: GAYNOR JANTJIES 213069555
 * Test for RestaurantFactory.Class
 * Restaurant cannot instantiate without the ID, Name and Location
 * Created: 9/04/2022
 * */

public class RestaurantFactoryTest {

    @Test
    void buildRestaurant() {

        Restaurant restaurant = new Restaurant.Builder()
                .setRestaurantId("Shop 012")
                .setRestaurantName("McDonalds")
                .setRestaurantLocation("Tygervalley Center")
                .build();

        assertEquals("Shop 012",restaurant.getRestaurantId());
        assertEquals("McDonalds",restaurant.getRestaurantName());
        assertEquals("Tygervalley Center",restaurant.getRestaurantLocation());

    }


}
