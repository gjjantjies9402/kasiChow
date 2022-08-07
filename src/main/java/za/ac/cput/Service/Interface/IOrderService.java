package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Order;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface IOrderService extends IService<Order, Integer> {
    public Set<Order> getAll();
}

