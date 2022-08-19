package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Order;
import za.ac.cput.Repository.Interface.IOrderRepository;
import za.ac.cput.Service.Interface.IOrderService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository repository;


    @Override
    public Set<Order> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
}


    @Override
    public Order create(Order order) {
        return null;

    }

    @Override
    public Order read(Integer integer) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;

    }
}
