/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.login;
import za.ac.cput.Entity.orderItem;
import za.ac.cput.Factory.loginFactory;
import za.ac.cput.Factory.orderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class orderItemRepositoryTest {
    private static orderItemRepository oItem = orderItemRepository.getRepository();
    private static orderItem item = orderItemFactory.createOrderItem(2, 25.99, 51.98);

    @Test
    void create() {
        orderItem create = oItem.create(item);
        assertEquals(item.getTotalAmount(), create.getTotalAmount());
        System.out.println(create);
    }

    @Test
    void read() {
        orderItem read = oItem.read(item.getPrice());
        assertNotNull(read);
        System.out.println(read);
    }


    @Test
    void update() {
        orderItem update = new orderItem.Builder().copy(item).setQuantity(2).build();
        assertNull(oItem.update(update));
        System.out.println(update);
    }

    @Test
    void delete() {
        boolean deleted = oItem.delete(item.toString());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
            System.out.println(oItem.getAll());
    }
}