package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.orderItem;

import static org.junit.jupiter.api.Assertions.*;

class orderItemFactoryTest {

    @Test
    void createOrderItem() {
        orderItem oItem = new orderItem.Builder()
                .setPrice(25.99)
                .setQuantity(2)
                .setTotalAmount(51.98)
                .build();

        assertEquals(25.99, oItem.getPrice());
        assertEquals(2,oItem.getQuantity());
        assertEquals(51.98,oItem.getTotalAmount());
    }
}