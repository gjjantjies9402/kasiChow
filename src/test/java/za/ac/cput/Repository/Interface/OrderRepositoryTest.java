//package za.ac.cput.Repository.Interface;
///**
// OrderRepositoryTest.java
// OrderRepositoryTest
// Author: Zimkhitha Nkqenkqa 216280427
// Date: 10 April 2022
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.Entity.Order;
//import za.ac.cput.Factory.OrderFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class OrderRepositoryTest {
//    private static OrderRepository orderRepository = OrderRepository.getRepository();
//    private static Order order = OrderFactory.createOrder(1416, "ORD98","DRV25", 10, "Delivered", "14:32");
//
//    @Test
//    void getRepository() {
//    }
//
//    @Test
//    void create() {
//        Order createdOrder = orderRepository.create(order);
//        assertEquals(createdOrder.getOrderID(), order.getOrderID());
//        System.out.println("Created: " + createdOrder);
//    }
//
//    @Test
//    void read() {
//        Order read = orderRepository.read(order.getOrderID());
//        assertNotNull(read);
//        System.out.println("Read :" + read);
//    }
//
//    @Test
//    void update() {
//        Order updateOrder = new Order.Builder().copy(order)
//                .setOrderID("ORD99")
//                .build();
//        assertEquals(updateOrder.getOrderID(), order.getOrderID());
//        System.out.println("Updated Order " + updateOrder);
//
//    }
//
//    @Test
//    void delete() {
//        boolean delete = orderRepository.delete(order.getOrderID());
//        assertTrue(delete);
//        System.out.println("Deleted: " + delete);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Order: \n" + orderRepository.getAll());
//    }
//}