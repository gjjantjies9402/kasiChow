package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.OrderItem;

import java.util.Set;

public interface IOrderItemService {
    Set<OrderItem> getAll();

    OrderItem create(OrderItem orderItem);

    //
    OrderItem read(String s);

    //
    OrderItem update(OrderItem orderItem);

    //
    boolean delete(String s);
}

//