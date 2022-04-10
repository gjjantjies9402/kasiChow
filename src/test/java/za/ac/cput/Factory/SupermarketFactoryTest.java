package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: GAYNOR JANTJIES 213069555
 * Test for RestaurantFactory.Class
 * Restaurant cannot instantiate without the ID, Name and Location
 * Created: 9/04/2022
 * */

public class SupermarketFactoryTest {

    @Test
    void buildSupermarket() {

        Supermarket supermarket = new Supermarket.Builder()
                .setMarketId("Shop 3a")
                .setMarketName("FoodLovers")
                .setMarketLocation(" Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550")
                .build();


        assertEquals("Shop 3a",supermarket.getMarketId());
        assertEquals("FoodLovers",supermarket.getMarketName());
        assertEquals(" Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550",supermarket.getMarketLocation());

    }


}
