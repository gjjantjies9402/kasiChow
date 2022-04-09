package za.ac.cput.Factory;

/**
 * Author: GAYNOR JANTJIES 213069555
 * Factory class for creating instances of Store.Class
 * Created: 9/04/2022
 * */

import za.ac.cput.Entity.Store;
public class StoreFactory {

    public static Store buildStore(String storeId, String restaurantId, String marketId)

    {

        Store store = new Store.Builder()
                .setStoreId(storeId)
                .setRestaurantId(restaurantId)
                .setMarketId(marketId)
                .build();


        return store;
    }

}
