package za.ac.cput.Service.Interface;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Order;
import za.ac.cput.Service.IService;

import java.util.List;

@Service
public interface IOrderService extends IService<Order, String> {
    public List<Order> getAll();
}

