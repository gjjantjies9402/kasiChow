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
//    private static Order order = OrderFactory.createOrder("ORD98", 9684, 684, 10, "Delivered");
//
//    @Test
//    void getRepository() {
//    }
//
//    @Test
//    void create() {
//        Order createdOrder = orderRepository.create(order);
//        assertEquals(createdOrder.getOrderNr(), order.getOrderNr());
//        System.out.println("Created: " + createdOrder);
//    }
//
//    @Test
//    void read() {
//        Order read = orderRepository.read(order.getOrderNr());
//        assertNotNull(read);
//        System.out.println("Read :" + read);
//    }
//
//    @Test
//    void update() {
//        Order updateOrder = new Order.Builder().copy(order)
//                .setOrderNr("ORD99")
//                .build();
//        assertEquals(updateOrder.getOrderNr(), order.getOrderNr());
//        System.out.println("Updated Order " + updateOrder);
//
//    }
//
//    @Test
//    void delete() {
//        boolean delete = orderRepository.delete(order.getOrderNr());
//        assertTrue(delete);
//        System.out.println("Deleted: " + delete);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Order: \n" + orderRepository.getAll());
//    }
//}