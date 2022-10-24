package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Entity.Order;
import za.ac.cput.Repository.Interface.IOrderRepository;
import za.ac.cput.Service.Interface.IOrderService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    private static IOrderService orderService = null;

    @Autowired
    private IOrderRepository repository;


    private OrderService() {
    }

    public static IOrderService getOrderService() {

        if(orderService == null)
            orderService = new OrderService();
        return orderService;

    }

    @Override
    public Order create(Order order) {
        return this.repository.save(order);

    }

    @Override
    public Order read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (this.repository.existsById(order.getOrderID()))
            return this.repository.save(order);
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        else
            return true;

    }

    @Override
    public List<Order> getAll() {

            return this.repository.findAll();
        }



}