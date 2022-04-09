package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Store;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Author: GAYNOR JANTJIES 213069555
 * Test for StoreFactory.Class
 * Store is an aggregate and cannot be instantiated without a Restaurant or a Supermarket
 * Created: 9/04/2022
 * */

public class StoreFactoryTest {

    @Test
    void buildRestaurant() {

        Store store = new Store.Builder()
                .setStoreId("012")
                .setRestaurantId("KFC-023")
                .setMarketId("SPAR-055")
                .build();

        assertEquals("012",store.getStoreId());
        assertEquals("KFC-023",store.getRestaurantId());
        assertEquals("SPAR-055",store.getMarketId());

    }


}
