package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;
import za.ac.cput.Service.Interface.RestaurantService;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RestaurantServiceImplTest {
    @Autowired
    private static RestaurantService service ;
    private static Restaurant res = RestaurantFactory.buildRestaurant("Shop 012","McDonalds","Tygervalley Center" );

    @Test
    void a_create() {
        Restaurant create = service.create(res);
        assertEquals(res.getRestaurantId(), create.getRestaurantId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Restaurant read = service.read(res.getRestaurantId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Restaurant update = new Restaurant.Builder().copy(res).setRestaurantName("Gaynor").build();
        update = service.update(update);
        assertEquals(res.getRestaurantId(), update.getRestaurantId());
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean delete = service.delete(res.getRestaurantId());
        assertTrue(delete);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        assertEquals(1, service.getAll().size());
        System.out.println("Restaurants: " + service.getAll());
    }
}