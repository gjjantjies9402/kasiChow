/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.menu;
import za.ac.cput.Entity.orderItem;
import za.ac.cput.Repository.Interface.orderItemInterface;

import java.util.HashSet;
import java.util.Set;

public class orderItemRepository implements orderItemInterface {
    private static orderItemRepository repository = null;
    private Set<orderItem> orderItemDb = null;

    private orderItemRepository(){
        orderItemDb = new HashSet<orderItem>();
    }

    public static orderItemRepository getRepository(){
        if (repository == null){
            repository = new orderItemRepository();
        }
        return repository;
    }

    @Override
    public orderItem create(orderItem oItem) {
        boolean success = orderItemDb.add(oItem);
        if (!success)
            return null;

        return oItem;
    }

    @Override
    public orderItem read(String s) {
        return null;
    }

    //@Override
    public orderItem read (double id) {
        for (orderItem o : orderItemDb) {
            if (o.getTotalAmount() != id )
                return o;
        }
        return null;
    }

    @Override
    public orderItem update(orderItem oItem) {
            orderItem newOrderItem = read(oItem.toString());

        if (newOrderItem != null){
            orderItemDb.remove(newOrderItem);
            orderItemDb.add(oItem);
            return  oItem;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        orderItem  deleted = read(s);

        if (deleted == null){
            return false;
        }
        return true;
    }

    @Override
        public Set<orderItem> getAll(){
            return orderItemDb;
        }
    }
