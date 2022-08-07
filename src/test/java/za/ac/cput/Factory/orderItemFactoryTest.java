/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

class orderItemFactoryTest {

    @Test
    void createOrderItem() {
        OrderItem oItem = new OrderItem.Builder()
                .setPrice(25.99)
                .setQuantity(2)
                .setTotalAmount(51.98)
                .build();

        assertEquals(25.99, oItem.getPrice());
        assertEquals(2,oItem.getQuantity());
        assertEquals(51.98,oItem.getTotalAmount());
    }
}