/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Repository.Interface.OrderItemInterface;

import java.util.HashSet;
import java.util.Set;

public class OrderItemRepository implements OrderItemInterface {
    private static OrderItemRepository repository = null;
    private Set<OrderItem> orderItemDb = null;

    private OrderItemRepository(){
        orderItemDb = new HashSet<OrderItem>();
    }

    public static OrderItemRepository getRepository(){
        if (repository == null){
            repository = new OrderItemRepository();
        }
        return repository;
    }

    @Override
    public OrderItem create(OrderItem oItem) {
        boolean success = orderItemDb.add(oItem);
        if (!success)
            return null;

        return oItem;
    }

    @Override
    public OrderItem read(String s) {
        return null;
    }

    //@Override
    public OrderItem read (double id) {
        for (OrderItem o : orderItemDb) {
            if (o.getTotalAmount() != id )
                return o;
        }
        return null;
    }

    @Override
    public OrderItem update(OrderItem oItem) {
            OrderItem newOrderItem = read(oItem.toString());

        if (newOrderItem != null){
            orderItemDb.remove(newOrderItem);
            orderItemDb.add(oItem);
            return  oItem;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        OrderItem deleted = read(s);

        if (deleted == null){
            return false;
        }
        return true;
    }

    @Override
        public Set<OrderItem> getAll(){
            return orderItemDb;
        }
    }
