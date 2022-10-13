package za.ac.cput.Factory;
/**
 OrderFactoryTest.java
 OrderFactoryTest
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Order;
import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void createOrder() {
        Order order = new Order.Builder()
                .setCustID(1416)
                .setOrderID("ORD98")
                .setDriverID(6804)
                .setItemID(10)
                .setTrackStatus("Delivered")
                .setTrackETA("Delivered")
                .build();


        assertEquals(1416, order.getCustID());
        assertEquals("ORD98", order.getOrderID());
        assertEquals(6804, order.getDriverID());
        assertEquals(10, order.getItemID());
        assertEquals("Delivered", order.getTrackStatus());
        assertEquals("14:32", order.getTrackETA());
    }
}