package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Factory.SupermarketFactory;
import za.ac.cput.Service.Interface.SupermarketService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SupermarketServiceImplTest {
    @Autowired
    private static SupermarketService service ;
    private static Supermarket mar = SupermarketFactory.buildSupermarket("Shop 3a", "FoodLovers", " Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550");

    @Test
    void a_create() {
        Supermarket create = service.create(mar);
        assertEquals(mar.getMarketId(), create.getMarketId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Supermarket read = service.read(mar.getMarketId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Supermarket update = new Supermarket.Builder().copy(mar).setMarketName("PicknPay").build();
        update = service.update(update);
        assertEquals(mar.getMarketId(), update.getMarketId());
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean delete = service.delete(mar.getMarketId());
        assertTrue(delete);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        assertEquals(1, service.getAll().size());
        System.out.println("Supermarkets: " + service.getAll());
    }
}