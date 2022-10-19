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
                .setItemID("25")
                .setQuantity(2)
                .setTotalAmount(51.98)
                .build();

        assertEquals(25, oItem.getItemID());
        assertEquals(2,oItem.getQuantity());
        assertEquals(51.98,oItem.getTotalAmount());
    }
}
//