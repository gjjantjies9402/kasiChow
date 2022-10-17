package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Order;
import za.ac.cput.Factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private static OrderService orderServ;
    private static Order order = OrderFactory.createOrder(1416, "ORD98","DRV25", 10, "Delivered", "14:32");

    @Test
    void create() {
        Order created = orderServ.create(order);
        assertEquals(order.getOrderID(), created.getOrderID());
        System.out.println("\nCreated: " + created);
    }

    @Test
    void read() {
        Order read = orderServ.read(order.getOrderID());
        assertNotNull(read);
        System.out.println("\nRead:\n" + read);
    }

    @Test
    void update() {
        Order order1 = new Order.Builder().copy(order).setOrderID("ORD96").build();
        order1 = orderServ.update(order1);
        System.out.println("\nUpdated: " + order1);
    }

    @Test
    void delete() {
        boolean deleteSuccessful = orderServ.delete(order.getOrderID());
        System.out.println("\nDeleted: ");
        assertTrue(deleteSuccessful);
    }

    @Test
    void getAll() {
        System.out.println("\nDisplay All: " + orderServ.getAll());
    }
}