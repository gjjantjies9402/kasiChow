package za.ac.cput.Repository;

import za.ac.cput.Entity.Order;

import java.util.HashSet;
import java.util.Set;

/**
 IOrderRepository.java
 IOrderRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

//public class OrderRepository implements IOrderRepository{
//    private static OrderRepository orderRepository = null;
//    private Set<Order> orderRepositoryDB = null;
//
//    private OrderRepository(){
//        orderRepositoryDB = new HashSet<Order>();
//        }
//
//    public static OrderRepository getRepository(){
//        if(orderRepository == null){
//            orderRepository = new OrderRepository();
//        }
//        return orderRepository;
//    }
//
//    @Override
//    public Set<Order> getAll() {
//        return orderRepositoryDB;
//    }
//
//
//    @Override
//    public Order create(Order order) {
//        boolean success = orderRepositoryDB.add(order);
//        if(!success)
//            return null;
//        return order;
//    }
//
//    @Override
//    public Order read(String s) {
//        Order order = orderRepositoryDB.stream()
//                .filter(e -> e.getOrderID().equals(s))
//                .findAny()
//                .orElse(null);
//        return order;
//    }
//
//    @Override
//    public Order update(Order order) {
//        Order prevOrder = read(order.getOrderID());
//        if (prevOrder != null){
//            orderRepositoryDB.remove(prevOrder);
//            orderRepositoryDB.add(order);
//            return order;
//
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        Order orderDeleted = read(s);
//        if (orderDeleted == null)
//            return false;
//        orderRepositoryDB.remove(orderDeleted);
//        return true;
//    }
//}
