package za.ac.cput.Factory;

/**
 * Author: GAYNOR JANTJIES 213069555
 * Factory class for creating instances of Restaurant.Class
 * Created: 9/04/2022
 * */

import za.ac.cput.Entity.Restaurant;

public class RestaurantFactory {

    public static Restaurant buildRestaurant(String restaurantId, String restaurantName, String restaurantLocation)

    {

        Restaurant restaurant = new Restaurant.Builder()
                .setRestaurantId(restaurantId)
                .setRestaurantName(restaurantName)
                .setRestaurantLocation(restaurantLocation)
                .build();


        return restaurant;
    }

}
