package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryTest {

    private static RestaurantRepository restaurantRepository = RestaurantRepository.getRestaurantRepository();
    private static Restaurant res = RestaurantFactory.buildRestaurant("Shop 012","McDonalds","Tygervalley Center" );
    @Test
    void create() {
        Restaurant create = restaurantRepository.create(res);
        assertEquals(res.getRestaurantId(), create.getRestaurantId());
        System.out.println("Created: " + create);
    }

    @Test
    void read() {
        Restaurant read = restaurantRepository.read(res.getRestaurantId());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {

        Restaurant update = new Restaurant.Builder().copy(res)
                .setRestaurantId("Shop 012")
                .setRestaurantName("McDonalds")
                .setRestaurantLocation("Tygervalley Center")
                .build();

        System.out.println("Update: " + update);
    }

    @Test
    void delete() {
        boolean delete = restaurantRepository.delete((res.getRestaurantId()));
        assertTrue(delete);
        System.out.println("Delete: " + delete);
    }

    @Test
    void getAll() {
        System.out.println("Show all");
        System.out.println(restaurantRepository.getAll());
    }
}