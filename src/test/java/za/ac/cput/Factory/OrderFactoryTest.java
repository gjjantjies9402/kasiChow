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
        Order order = OrderFactory.createOrder("ORD98", 9684,684, 10, "Delivered");
        System.out.println(order.toString());
        assertNotNull(order);
    }
}