package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Store;
import za.ac.cput.Factory.StoreFactory;
import za.ac.cput.Service.Interface.StoreService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StoreServiceImplTest {
    @Autowired
    private static StoreService service ;
    private static Store sto = StoreFactory.buildStore("012","KFC-023","SPAR-055" );

    @Test
    void a_create() {
        Store create = service.create(sto);
        assertEquals(sto.getRestaurantId(), create.getStoreId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Store read = service.read(sto.getStoreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Store update = new Store.Builder().copy(sto).setStoreId("123").build();
        update = service.update(update);
        assertEquals(sto.getStoreId(), update.getStoreId());
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean delete = service.delete(sto.getStoreId());
        assertTrue(delete);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        assertEquals(1, service.getAll().size());
        System.out.println("Stores: " + service.getAll());
    }
}