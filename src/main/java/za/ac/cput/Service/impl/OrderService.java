package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Orders;
import za.ac.cput.Repository.Interface.IOrderRepository;
import za.ac.cput.Service.Interface.IOrderService;

import java.util.List;

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
    public Orders create(Orders order) {
        return this.repository.save(order);

    }

    @Override
    public Orders read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Orders update(Orders order) {
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
    public List<Orders> getAll() {

        return this.repository.findAll();
    }



}