package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Repository.Interface.OrderItemInterface;
import za.ac.cput.Service.Interface.IOrderItemService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemInterface orderItemRepository;

    private static IOrderItemService orderItemService = null;

    private OrderItemService(){

    }

    public static IOrderItemService getOrderItemService() {
        if(orderItemService == null)
            orderItemService = new OrderItemService();
        return orderItemService;
    }

    @Override
    public Set<OrderItem> getAll() {return this.orderItemRepository.findAll().stream().collect(Collectors.toSet());}

    @Override
    public OrderItem create(OrderItem orderItem) {
        return this.orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem read(String s) {
        return this.orderItemRepository.findById(s).orElseGet(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        if(this.orderItemRepository.existsById(orderItem.getItemID())) {
            return this.orderItemRepository.save(orderItem);
        }
//        return this.orderItemRepository.save(orderItem);
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.orderItemRepository.deleteById(s);
        return true;
    }
}
//
//
