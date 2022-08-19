/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemRepositoryTest {
    private static OrderItemRepository oItem = OrderItemRepository.getRepository();
    private static OrderItem item = OrderItemFactory.createOrderItem(2, 25.99, 51.98);

    @Test
    void create() {
        OrderItem create = oItem.create(item);
        assertEquals(item.getTotalAmount(), create.getTotalAmount());
        System.out.println(create);
    }

    @Test
    void read() {
        OrderItem read = oItem.read(item.getPrice());
        assertNotNull(read);
        System.out.println(read);
    }


    @Test
    void update() {
        OrderItem update = new OrderItem.Builder().copy(item).setQuantity(2).build();
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