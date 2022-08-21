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
    private static Order order = OrderFactory.createOrder("ORD98", 9684,684, 10, "Delivered");

    @Test
    void create() {
        Order created = orderServ.create(order);
        assertEquals(order.getOrderNr(), created.getOrderNr());
        System.out.println("\nCreated: " + created);
    }

    @Test
    void read() {
        Order read = orderServ.read(order.getOrderNr());
        assertNotNull(read);
        System.out.println("\nRead:\n" + read.toString());
    }

    @Test
    void update() {
        Order order1 = new Order.Builder().copy(order).setOrderNr("ORD96").build();
        order1 = orderServ.update(order1);
        System.out.println("\nUpdated: " + order1);
    }

    @Test
    void delete() {
        boolean deleteSuccessful = orderServ.delete(order.getOrderNr());
        System.out.println("\nDeleted: ");
        assertTrue(deleteSuccessful);
    }

    @Test
    void getAll() {
        System.out.println("\nDisplay All: " + orderServ.getAll());
    }
}